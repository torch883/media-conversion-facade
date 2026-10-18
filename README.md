# Media Conversion Facade

Assignment #4 - Facade Pattern (ShP-2216). Java 17, no external libraries.

## Idea
Converting a media file needs four steps in the right order: read metadata,
choose a codec, choose a bitrate, normalize volume, then encode.
MediaConversionFacade hides all of it behind one method:
convert(fileName, targetFormat).

## Structure
- subsystem/ - MetadataReader, CodecFactory, Codec (Mp3/Ogg/Aac), BitrateReader, AudioMixer, MediaFile
- facade/ - MediaConversionFacade, ConversionException
- client/ - Main (uses only the Facade), AdvancedClientDemo (uses the subsystem directly)

## Run
Open the project in IntelliJ IDEA (JDK 17) and run client.Main.

## Pattern roles
- Facade: MediaConversionFacade
- Subsystem: MetadataReader, CodecFactory, Codec, BitrateReader, AudioMixer
- Client: Main

Subsystem classes know nothing about the Facade and can be used without it.