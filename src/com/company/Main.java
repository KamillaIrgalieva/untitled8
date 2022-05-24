package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();

        File dir = new File("C://Games");
        if (dir.mkdir()) {
            text.append("папка Games - создана;");
            System.out.println("папка Games - создана");
        }


        File dirSrc = new File("C://Games", "src");
        if (dirSrc.mkdir()) {
            text.append(" папка src - создана;");
            System.out.println("папка src - создана");
        }


        File dirRes = new File("C://Games", "res");
        if (dirRes.mkdir()) {
            text.append(" папка res - создана;");
            System.out.println("папка res - создана");
        }


        File dirSavegames = new File("C://Games", "savegames");
        if (dirSavegames.mkdir()) {
            text.append(" папка savegames - создана;");
            System.out.println("папка savegames - создана");
        }
        ;

        File dirTemp = new File("C://Games", "temp");
        if (dirTemp.mkdir()) {
            text.append(" папка temp - создана;");
            System.out.println("папка temp - создана");
        }


        File dirMain = new File("C://Games//src", "main");
        if (dirMain.mkdir()) {
            text.append(" папка main - создана;");
            System.out.println("папка main - создана");
        }


        File dirTest = new File("C://Games//src", "test");
        if (dirTest.mkdir()) {
            text.append(" папка test - создана;");
            System.out.println("папка test - создана");
        }


        File fileMain = new File("C://Games//src//main", "Main.java");
        try {
            if (fileMain.createNewFile()) {
                text.append(" файл Main.java - создан;");
                System.out.println("файл Main.java - создан");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File fileUtils = new File("C://Games//src//main//Utils.java");
        try {
            if (fileUtils.createNewFile()) {
                text.append(" файл Utils.java - создан;");
                System.out.println("файл Utils.java - создан");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        File dirDrawables = new File("C://Games//res//drawables");
        if (dirDrawables.mkdir()) {
            text.append(" папка drawables - создана;");
            System.out.println("папка drawables - создана");
        }

        File dirVectors = new File("C://Games//res//vectors");
        if (dirVectors.mkdir()) {
            text.append(" папка vectors - создана;");
            System.out.println("папка vectors - создана");
        }

        File dirIcons = new File("C://Games//res//icons");
        if (dirIcons.mkdir()) {
            text.append(" папка icons - создана;");
            System.out.println("папка icons - создана");
        }

        File fileTemp = new File("C://Games//temp//temp.txt");
        try {
            if (fileTemp.createNewFile()) {
                text.append(" файл temp.txt - создан;");
                System.out.println("файл temp.txt - создан");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
            writer.append(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
