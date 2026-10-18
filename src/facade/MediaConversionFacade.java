package facade;

import subsystem.AudioMixer;
import subsystem.BitrateReader;
import subsystem.Codec;
import subsystem.CodecFactory;
import subsystem.MediaFile;
import subsystem.MetadataReader;
import java.util.List;

public class MediaConversionFacade {

    private final MetadataReader metadataReader = new MetadataReader();
    private final CodecFactory codecFactory = new CodecFactory();
    private final BitrateReader bitrateReader = new BitrateReader();
    private final AudioMixer audioMixer = new AudioMixer();

    public String convert(String fileName, String targetFormat) {
        try {
            MediaFile source = metadataReader.read(fileName);
            Codec codec = codecFactory.getCodec(targetFormat);
            int bitrate = bitrateReader.chooseBitrate(source, codec);
            MediaFile normalized = audioMixer.normalize(source);
            MediaFile result = codec.encode(normalized, bitrate);
            return result.getFileName();
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Cannot convert '" + fileName
                    + "' to " + targetFormat + ": " + e.getMessage(), e);
        }
    }
    public String getFileInfo(String fileName) {
        try {
            return metadataReader.read(fileName).toString();
        } catch (IllegalArgumentException e) {
            throw new ConversionException("Cannot read '" + fileName
                    + "': " + e.getMessage(), e);
        }
    }

    public List<String> getSupportedFormats() {
        return codecFactory.getSupportedFormats();
    }
}