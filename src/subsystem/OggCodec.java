package subsystem;

public class OggCodec implements Codec {

    @Override
    public String getFormat() {
        return "OGG";
    }

    @Override
    public int getMaxBitrateKbps() {
        return 500;
    }

    @Override
    public MediaFile encode(MediaFile source, int bitrateKbps) {
        System.out.println("[OggCodec] Encoding " + source.getFileName()
                + " to OGG at " + bitrateKbps + " kbps");
        return source.withFormat("OGG", bitrateKbps);
    }
}