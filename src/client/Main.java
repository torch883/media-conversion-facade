package client;

import facade.MediaConversionFacade;

public class Main {
    public static void main(String[] args) {
        MediaConversionFacade mediaFacade = new MediaConversionFacade();
        String result = mediaFacade.convert("song.wav", "mp3");
        System.out.println("Result: " + result);
    }
}