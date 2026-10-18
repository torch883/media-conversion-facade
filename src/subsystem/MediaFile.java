package subsystem;

public class MediaFile {

    private final String fileName;
    private final String format;
    private final int durationSeconds;
    private final int bitrateKbps;
    private final int volumePercent;

    public MediaFile(String fileName, String format, int durationSeconds,
                     int bitrateKbps, int volumePercent) {
        this.fileName = fileName;
        this.format = format;
        this.durationSeconds = durationSeconds;
        this.bitrateKbps = bitrateKbps;
        this.volumePercent = volumePercent;
    }

    public String getFileName() { return fileName; }
    public String getFormat() { return format; }
    public int getDurationSeconds() { return durationSeconds; }
    public int getBitrateKbps() { return bitrateKbps; }
    public int getVolumePercent() { return volumePercent; }

    public int getSizeKb() {
        return bitrateKbps * durationSeconds / 8;
    }

    public String getBaseName() {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return fileName;
        }
        return fileName.substring(0, dotIndex);
    }

    public MediaFile withVolume(int newVolumePercent) {
        return new MediaFile(fileName, format, durationSeconds,
                bitrateKbps, newVolumePercent);
    }

    public MediaFile withFormat(String newFormat, int newBitrateKbps) {
        String newFileName = getBaseName() + "." + newFormat.toLowerCase();
        return new MediaFile(newFileName, newFormat, durationSeconds,
                newBitrateKbps, volumePercent);
    }

    @Override
    public String toString() {
        return fileName + " [" + format + ", " + durationSeconds + " sec, "
                + bitrateKbps + " kbps, volume " + volumePercent + "%, ~"
                + getSizeKb() + " KB]";
    }
}