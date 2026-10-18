package subsystem;
import java.util.List;

public class CodecFactory {
    public List<String> getSupportedFormats() {
        return List.of("MP3", "OGG", "AAC");
    }
    public Codec getCodec(String format) {
        System.out.println("[CodecFactory] Looking for codec: " + format);

        switch (format.toUpperCase()) {
            case "MP3":
                return new Mp3Codec();
            case "OGG":
                return new OggCodec();
            case "AAC":
                return new AacCodec();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}