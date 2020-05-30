package com.company;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilesUtil {

    public void getFiles(String path) {
//        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            for (int i = 0; i <= quantity; i++) {
//
//            }
            List<String> list = this.generateParagraph();
            byte[] bytes;
            for (String s : list
            ) {
                bytes = s.getBytes();
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String generateWord() {
        int randomCharCount = this.generateRandomInRange(1, 15);
        char randomChar;
        String word = "";
        for (int i = 1; i <= randomCharCount; i++) {
            randomChar = (char) this.generateRandomInRange(97, 122);
            word += randomChar;
        }
        return word + " ";
    }

    public List<String> generateSentence() {
        int count = 0;
        int randomWordCount = this.generateRandomInRange(1, 15);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= randomWordCount; i++) {
            list.add(this.generateWord());
            count += list.get(i).length();
            if (count >= 60) {
                list.add("\n");
            }
        }
        String s = list.get(1).substring(0, 1).toUpperCase();
        list.set(1, s);
        int randomPunkctuation = this.generateRandomInRange(0, 100);
        if (randomPunkctuation >= 0 && randomPunkctuation <= 33) {
            list.add("!");
            list.add(" ");
        } else if (randomPunkctuation >= 34 && randomPunkctuation <= 66) {
            list.add("?");
            list.add(" ");
        } else if (randomPunkctuation >= 67 && randomPunkctuation <= 100) {
            list.add(".");
            list.add(" ");
        }
        return list;
    }

    public List<String> generateParagraph() {
        List<String> lists = new ArrayList<>();
        int randomSentense = this.generateRandomInRange(1, 20);
        for (int i = 1; i <= randomSentense; i++) {
            lists.addAll(generateSentence());
        }
        lists.add("\n");
        lists.add("\r");
        return lists;
    }

    private int generateRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
