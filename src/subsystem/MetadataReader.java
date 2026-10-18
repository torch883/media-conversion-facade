package subsystem;

import java.util.HashMap;
import java.util.Map;

public class MetadataReader {

    private final Map<String, MediaFile> library = new HashMap<>();

    public MetadataReader() {
        library.put("song.wav", new MediaFile("song.wav", "WAV", 180, 1411, 60));
        library.put("podcast.mp3", new MediaFile("podcast.mp3", "MP3", 1800, 128, 120));
        library.put("voice.ogg", new MediaFile("voice.ogg", "OGG", 60, 96, 45));
    }

    public MediaFile read(String fileName) {
        System.out.println("[MetadataReader] Reading metadata of " + fileName);
        MediaFile file = library.get(fileName);
        if (file == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        return file;
    }
}