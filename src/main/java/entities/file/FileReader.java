package entities.file;

import entities.exceptions.FileNotFoundException;
import entities.exceptions.ProgramException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public  abstract class FileReader {

    public static List<String> getFileLines(String filePath) throws ProgramException {

        List<String> fileLine = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            stream.forEach(fileLine::add);
        } catch (IOException ioe) {
            throw new FileNotFoundException("you can not read the file!");
        }

        return fileLine;
    }
}
