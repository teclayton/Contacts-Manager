

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileManager {

    public static List<String> pull(String filepath) {
        Path path = Paths.get(filepath);

        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.printf("Error when trying to pull %s: %s\n", filepath, e.getMessage());
            System.exit(1);
            //I don't know why I have to do this next part ¯\_(ツ)_/¯
            return new ArrayList<>();
        }
    }


    public static void place(String filename, List<String> contents) {
        place(filename, contents, false);
    }
    public static void place(String filename, List<String> contents, boolean append) {
        StandardOpenOption option = append ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING;
        Path path = Paths.get(filename);

        if (! Files.exists(path)) {
            try {
                Files.createDirectories(path);
                Files.createFile(path);
            } catch (IOException e) {
                System.out.printf("Error creating file %s: %s\n", path, e.getMessage());
                System.exit(1);
            }
        }
        // writes content to file
        try {
            Files.write(path, contents, option);
        } catch (IOException e) {
            System.out.printf("Error writing contents to %s: %s\n", filename, e.getMessage());
            System.exit(1);
        }
    }

}