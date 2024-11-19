package Task3;

import java.io.IOException;
import java.io.File;
// cd src
// javac Task3/Task3.java
// java Task3/Task3 /tmp abc
public class Task3 {
    public static void main(String[] args)  {
        String fileRegex = "";
        if (args.length !=1 && args.length != 2 ) {
                System.out.println("Помилка: вкажіть 1 або 2 параметра. Приклад: /tmp abc");
                return;
        } else if (args.length == 2){
            fileRegex = args[1];
        }
        String catalogName = System.getProperty("user.dir") + args[0];
        File catalogFile = new File(catalogName);
        File [] files = catalogFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().startsWith(fileRegex)) {
                    System.out.println(file.getName());
                }
            }
        }
        else {
            System.out.println("No files found");
        }


    }
}
