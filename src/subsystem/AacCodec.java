package subsystem;

public class AacCodec implements Codec {

    @Override
    public String getFormat() {
        return "AAC";
    }

    @Override
    public int getMaxBitrateKbps() {
        return 256;
    }

    @Override
    public MediaFile encode(MediaFile source, int bitrateKbps) {
        System.out.println("[AacCodec] Encoding " + source.getFileName()
                + " to AAC at " + bitrateKbps + " kbps");
        return source.withFormat("AAC", bitrateKbps);
    }
}