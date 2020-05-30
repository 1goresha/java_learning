package com.company;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilesUtil {
    private List<String> stringList;
    private Random random;

    public FilesUtil() {
        this.stringList = new ArrayList<>();
        random = new Random();
    }

    public void getFiles(String path, int quantity, int size, String[] words, int probability) {
        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            for (int i = 0; i <= quantity; i++) {

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void generateWord() {
        int randomCount = this.generateRandomInRange(1, 15);
        char randomChar;
        String word = "";
        for (int i = 1; i <= randomCount; i++) {
            randomChar = (char) this.generateRandomInRange(65, 122);
            word += randomChar;
        }
    }

    private List<String> generateSentence() {
        return null;
    }

    private List<List<String>> generateParagraph() {
        return null;
    }

    private int generateRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
