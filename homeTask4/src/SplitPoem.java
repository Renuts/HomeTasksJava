import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SplitPoem {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("poem.txt"), StandardCharsets.UTF_8);
            splitAndSaveParagraphs(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void splitAndSaveParagraphs(List<String> lines) {
        int partNumber = 1;
        StringBuilder paragraph = new StringBuilder();

        for (String line : lines) {
            if (line.trim().isEmpty() && paragraph.length() > 0) {
                saveParagraph(partNumber++, paragraph.toString().trim());
                paragraph.setLength(0);
            } else {
                paragraph.append(line).append("\n");
            }
        }

        if (paragraph.length() > 0) {
            saveParagraph(partNumber, paragraph.toString().trim());
        }
    }

    private static void saveParagraph(int partNumber, String paragraph) {
        String fileName = "part" + partNumber + ".txt";
        try {
            Files.writeString(Paths.get(fileName), paragraph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
