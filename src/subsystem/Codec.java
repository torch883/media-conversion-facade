package subsystem;

public interface Codec {
    String getFormat();
    int getMaxBitrateKbps();
    MediaFile encode(MediaFile source, int bitrateKbps);
}