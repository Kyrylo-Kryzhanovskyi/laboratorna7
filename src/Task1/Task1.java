package Task1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Task1 {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        System.out.println("Домашній каталог: " + homeDir);
        Path path = Paths.get(homeDir);
        System.out.println(path.getRoot().toString().replace('\\',' '));
        for (Path one : path) {
            System.out.println("\\" + one.getFileName());
        }
        String currentDir = System.getProperty("user.dir");
        System.out.println("\nПоточний каталог: " + currentDir);
        path = Paths.get(currentDir);
        System.out.println(path.getRoot().toString().replace('\\',' '));
        for (Path one : path) {
            System.out.println("\\" + one.getFileName());
        }
    }

}
