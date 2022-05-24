package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void saveGame() {
        try (FileOutputStream fos = new FileOutputStream("C://Games//savegames//save.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new GameProgress(100, 1, 1, 32.1));
            oos.writeObject(new GameProgress(90, 2, 2, 50));
            oos.writeObject(new GameProgress(80, 3, 3, 77));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String createDir(String address, String name) {
        File dir = new File(address);
        if (dir.mkdir()) {
            return " папка " + name + " - создана;";
        }
        return " не создана;";
    }

    public static String createFile(String address, String name) {
        File fileMain = new File(address);
        try {
            if (fileMain.createNewFile()) {
                return " файл " + name + " - создан;";
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return " не создан;";
    }

    public static void zipFiles(String zipAddress, String objectAddress, String name) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipAddress))) {
            // zip - создали архив
            FileInputStream fis = new FileInputStream(objectAddress);
            ZipEntry entry = new ZipEntry(name);
            zip.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            //считать упаковываемый файл с помощью метода read()
            fis.read(buffer);
            //записать его с помощью метода write()
            zip.write(buffer);
            //закрываем поток
            zip.closeEntry();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();

        text.append(createDir("C://Games", "Games"));
        text.append(createDir("C://Games//src", "src"));
        text.append(createDir("C://Games//res", "res"));
        text.append(createDir("C://Games//savegames", "savegames"));
        text.append(createDir("C://Games//temp", "temp"));
        text.append(createDir("C://Games//src//main", "main"));
        text.append(createDir("C://Games//src//test", "test"));
        text.append(createFile("C://Games//src//main//Main.java", "Main.java"));
        text.append(createFile("C://Games//src//main//Utils.java", "Utils.java"));
        text.append(createDir("C://Games//res//drawables", "drawables"));
        text.append(createDir("C://Games//res//vectors", "vectors"));
        text.append(createDir("C://Games//res//icons", "icons"));
        text.append(createFile("C://Games//temp//temp.txt", "temp.txt"));

        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
            writer.append(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        saveGame();

        zipFiles("C://Games//savegames//save.zip", "C://Games//savegames//save.dat", "packed_save.dat");
    }
}
