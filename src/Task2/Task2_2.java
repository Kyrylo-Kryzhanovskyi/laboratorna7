package Task2;


import java.io.*;
import java.nio.file.Files;

public class Task2_2 {
    public static void main(String[] args){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = null;
        try {
            file = File.createTempFile("tempfile", ".txt", new File(System.getProperty("user.dir")));

            System.out.println("Тимчасовий файл створено: " + file.getAbsolutePath() + " після завершення програми, файл видалиться");
            System.out.println("Введіть дані у файл. Для завершення введення файлу введіть 'q!' на початку рядка.");
            try(BufferedWriter outputStream = new BufferedWriter(new FileWriter(file)) ) {
                while (true) {
                    String input = reader.readLine();
                    if (input.startsWith("q!")) {
                        break;
                    }
                    outputStream.write(input);
                    outputStream.newLine();
                }
            }
            System.out.println("Вміст тимчасового файлу:");
            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("Програма завершена. Тимчасовий файл буде автоматично видалений.");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file != null) {
                if (file.delete()) {
                    System.out.println("Файл успішно видалено.");
                } else {
                    System.out.println("Не вдалося видалити файл.");
                }
            }
        }
    }
}
