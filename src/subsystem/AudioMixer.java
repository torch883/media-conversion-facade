package subsystem;

public class AudioMixer {

    private static final int TARGET_VOLUME_PERCENT = 80;

    public MediaFile normalize(MediaFile source) {
        System.out.println("[AudioMixer] Normalizing volume " + source.getVolumePercent()
                + "% -> " + TARGET_VOLUME_PERCENT + "%");
        return source.withVolume(TARGET_VOLUME_PERCENT);
    }
}