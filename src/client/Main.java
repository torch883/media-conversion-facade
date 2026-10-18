import subsystem.AudioMixer;
import subsystem.BitrateReader;
import subsystem.Codec;
import subsystem.CodecFactory;
import subsystem.MediaFile;
import subsystem.MetadataReader;

public class Main {
    public static void main(String[] args) {
        MetadataReader metadataReader = new MetadataReader();
        CodecFactory codecFactory = new CodecFactory();
        BitrateReader bitrateReader = new BitrateReader();
        AudioMixer audioMixer = new AudioMixer();

        MediaFile source = metadataReader.read("song.wav");
        Codec codec = codecFactory.getCodec("mp3");
        int bitrate = bitrateReader.chooseBitrate(source, codec);
        MediaFile normalized = audioMixer.normalize(source);
        MediaFile result = codec.encode(normalized, bitrate);

        System.out.println("Result: " + result);
    }
}