package Task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Task2 {
    public static void main(String[] args){
        Path tempFile = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            tempFile = Files.createTempFile(Paths.get(System.getProperty("user.dir")),"tempfile", ".txt");
            System.out.println("Тимчасовий файл створено: " + tempFile.toString() + " після завершення програми, файл видалиться");
            System.out.println("Введіть дані у файл. Для завершення введення файлу введіть 'q!' на початку рядка.");
            while (true) {
                String input = reader.readLine();
                if (input.startsWith("q!")) {
                    break;
                }
                Files.writeString(tempFile, System.lineSeparator() + input, StandardOpenOption.APPEND);
            }
            String content = Files.readString(tempFile);
            System.out.println("Вміст тимчасового файлу: " + content);
            System.out.println("Програма завершена. Тимчасовий файл буде автоматично видалений.");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (tempFile !=null) {
                try {
                    Files.delete(tempFile);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
