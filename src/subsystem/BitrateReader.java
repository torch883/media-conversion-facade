package subsystem;

public class BitrateReader {

    public int chooseBitrate(MediaFile source, Codec codec) {
        int sourceBitrate = source.getBitrateKbps();
        int maxBitrate = codec.getMaxBitrateKbps();
        int chosen = Math.min(sourceBitrate, maxBitrate);
        System.out.println("[BitrateReader] Source bitrate: " + sourceBitrate
                + " kbps, codec max: " + maxBitrate + " kbps -> using " + chosen + " kbps");
        return chosen;
    }
}