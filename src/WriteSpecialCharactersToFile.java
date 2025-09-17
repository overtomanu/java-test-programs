import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class WriteSpecialCharactersToFile {

    public static void writeStringToFile(String filepath, String contents) throws IOException {
        // from https://www.baeldung.com/java-write-to-file
        Path path = Paths.get(filepath);
        byte[] strToBytes = contents.getBytes();

        Files.write(path, strToBytes);
    }

    public static void main(String[] args) throws IOException {
        String strWithSpecialCharacters = "a\u0000b\u0007c\u008fd";
        /*System.out.println(
                strWithSpecialCharacters.replaceAll("\\p{Cc}", "")
        ); // abcd*/

        String tempDirPath = System.getProperty("java.io.tmpdir");
        String filePath = tempDirPath + "/file-with-special-chars-" + LocalDate.now() + ".txt";
        String content = "string with special characters: " + strWithSpecialCharacters;
        content += "\nstring with special characters replaced: " + strWithSpecialCharacters.replaceAll("\\p{Cc}", "");
        writeStringToFile(filePath, content);

        System.out.println("wrote contents to " + filePath);
    }
}
