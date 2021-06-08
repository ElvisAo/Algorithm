package preprocess;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
    public static void replaceChar(String fileName, char target, char... args) throws IOException {
        FileReader reader = new FileReader(fileName);
        char[] buffer = new char[4096];
        int ln = reader.read(buffer);
        reader.close();
        for (int i = 0; i < ln; i++) {
            for (char c : args) {
                if (buffer[i] == c) buffer[i] = target;
            }
        }
        FileWriter writer = new FileWriter(fileName, false);
        writer.write(buffer, 0, ln);
        writer.close();
    }

    public static String getCurrentInputFile() {
        return null;
    }
}
