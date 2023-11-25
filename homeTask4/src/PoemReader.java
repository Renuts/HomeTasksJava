import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PoemReader {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        readPoem(queue);
        displayPoemWithDelay(queue);
    }

    private static void readPoem(Queue<String> queue) {
        try (BufferedReader br = new BufferedReader(new FileReader("poem.txt", StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayPoemWithDelay(Queue<String> queue) {
        Random random = new Random();

        while (!queue.isEmpty()) {
            String line = queue.poll();
            // Используем UTF-8 для корректного отображения русского текста в консоли
            System.out.println(line);

            // Генерация случайной задержки от 1 до 3 секунд
            int delay = random.nextInt(3) + 1;
            try {
                Thread.sleep(delay * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
