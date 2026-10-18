package client;

import facade.ConversionException;
import facade.MediaConversionFacade;

public class Main {
    public static void main(String[] args) {
        MediaConversionFacade mediaFacade = new MediaConversionFacade();

        System.out.println("Supported formats: " + mediaFacade.getSupportedFormats());
        System.out.println("Input file: " + mediaFacade.getFileInfo("song.wav"));
        System.out.println();

        convertAndPrint(mediaFacade, "song.wav", "mp3");
        convertAndPrint(mediaFacade, "podcast.mp3", "aac");
        convertAndPrint(mediaFacade, "voice.ogg", "mp3");

        convertAndPrint(mediaFacade, "missing.mp3", "ogg");
        convertAndPrint(mediaFacade, "song.wav", "flac");
    }

    private static void convertAndPrint(MediaConversionFacade mediaFacade,
                                        String fileName, String format) {
        System.out.println("=== " + fileName + " -> " + format + " ===");
        try {
            String result = mediaFacade.convert(fileName, format);
            System.out.println("Done: " + result);
        } catch (ConversionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println();
    }
}