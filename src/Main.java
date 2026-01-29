import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        String basePath = "C://Games";

        createDirectory(basePath + "/src/main");
        createDirectory(basePath + "/src/test");
        createDirectory(basePath + "/res/drawables");
        createDirectory(basePath + "/res/vectors");
        createDirectory(basePath + "/res/icons");
        createDirectory(basePath + "/savegames");
        createDirectory(basePath + "/temp");

        createFile(basePath + "/src/main/Main.java");
        createFile(basePath + "/src/main/Utils.java");

        File tempFile = createFile(basePath + "/temp/temp.txt");

        writeLogToFile(tempFile);

        System.out.println(log.toString());
    }

    private static void createDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Успешно создана директория: " + path + "\n");
        } else {
            log.append("Не удалось создать директорию: " + path + "\n");
        }
    }

    private static File createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Успешно создан файл: " + path + "\n");
            } else {
                log.append("Не удалось создать файл: " + path + "\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла " + path + ": " + e.getMessage() + "\n");
        }
        return file;
    }

    private static void writeLogToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(log.toString());
            log.append("Лог успешно записан в файл: " + file.getPath() + "\n");
        } catch (IOException e) {
            log.append("Ошибка при записи лога в файл: " + e.getMessage() + "\n");
        }
    }
}