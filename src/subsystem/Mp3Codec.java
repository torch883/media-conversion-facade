package subsystem;

public class Mp3Codec implements Codec {

    @Override
    public String getFormat() {
        return "MP3";
    }

    @Override
    public int getMaxBitrateKbps() {
        return 320;
    }

    @Override
    public MediaFile encode(MediaFile source, int bitrateKbps) {
        System.out.println("[Mp3Codec] Encoding " + source.getFileName()
                + " to MP3 at " + bitrateKbps + " kbps");
        return source.withFormat("MP3", bitrateKbps);
    }
}