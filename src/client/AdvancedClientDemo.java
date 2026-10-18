package client;

import subsystem.Codec;
import subsystem.MediaFile;
import subsystem.MetadataReader;
import subsystem.OggCodec;

public class AdvancedClientDemo {
    public static void main(String[] args) {
        MetadataReader reader = new MetadataReader();
        MediaFile file = reader.read("podcast.mp3");

        Codec codec = new OggCodec();
        MediaFile result = codec.encode(file, 64);

        System.out.println("Custom result: " + result);
    }
}