package Task4;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

// cd src
// javac Task4/Task4.java
// java Task4/Task4 /Task4/source.txt /Task4/tmp/gfffg/source_copy.txt або java Task4/Task4 /Task4/source.txt /Task4/tmp/gfffg
public class Task4 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Помилка: вкажіть шлях до файлу-джерела та назву каталогу куди копіювати. Приклад: /Task3/source.txt /Task3/source_copy.txt");
            return;
        }
        String absolutePath = System.getProperty("user.dir");
        String pathSource = absolutePath +  args[0].replace("/", File.separator);
        String pathTarget = absolutePath +  args[1].replace("/", File.separator);
        Path pathS = Path.of(pathSource);
        String nameTarget = "copy" + pathS.getFileName().toString();

        if (pathTarget.endsWith(".txt")) {
            int lastInd = pathTarget.lastIndexOf(File.separator);
            nameTarget = pathTarget.substring(lastInd + 1);
            pathTarget = pathTarget.substring(0, lastInd);
        }
        File file = new File(pathTarget);
        if(!file.exists()){
            if(!file.mkdirs()){
                System.out.println("Батьківські каталоги не створенні :: ERROOOR");
                return;
            }
        }

        Path pathT = Path.of(pathTarget + File.separator + nameTarget);
        try {
            Files.copy(pathS, pathT);
        } catch (FileAlreadyExistsException e) {
            File file1 = new File(pathT.toString());
            if(file1.delete()){
                try {
                    Files.copy(pathS, pathT);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
