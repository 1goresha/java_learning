package com.company;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilesUtil {

    public void getFiles(String path) {
        int countOfChar = 0;
//        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            for (int i = 0; i <= quantity; i++) {
//
//            }
            List<String> list = this.generateParagraph();
            byte[] bytes;
            for (String s : list) {
                for (int b : s.getBytes()) {
                    fileOutputStream.write(b);
                    countOfChar++;
                    if (countOfChar >= 60){
                        fileOutputStream.write('\n');
                        countOfChar = 0;
                    }
                }
//                bytes = s.getBytes();
//                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public String generateWord() {
        int randomCharCount = this.generateRandomInRange(1, 15);
        char randomChar;
        String word = "";
        for (int i = 0; i < randomCharCount; i++) {
            randomChar = (char) this.generateRandomInRange(97, 122);
            word += randomChar;
        }
        return word + " ";
    }

    public List<String> generateSentence() {
        int randomWordCount = this.generateRandomInRange(1, 15);
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < randomWordCount; i++) {
            wordList.add(this.generateWord());
        }
        String temp = wordList.get(0).substring(0, 1).toUpperCase();
        wordList.set(0, temp);
        int randomPunctuation = this.generateRandomInRange(0, 100);
        if (randomPunctuation >= 0 && randomPunctuation <= 33) {
            temp = wordList.get(wordList.size() - 1) + "! ";
            wordList.set(wordList.size() - 1, temp);
        } else if (randomPunctuation >= 34 && randomPunctuation <= 66) {
            temp = wordList.get(wordList.size() - 1) + "? ";
            wordList.set(wordList.size() - 1, temp);
        } else if (randomPunctuation >= 67 && randomPunctuation <= 100) {
            temp = wordList.get(wordList.size() - 1) + ". ";
            wordList.set(wordList.size() - 1, temp);
        }
        return wordList;
    }

    public List<String> generateParagraph() {
        List<String> sentencesList = new ArrayList<>();
        int randomSentence = this.generateRandomInRange(1, 20);
        for (int i = 0; i < randomSentence; i++) {
            sentencesList.addAll(generateSentence());
        }
        String s = sentencesList.get(sentencesList.size() - 1) + "\r\n";
        sentencesList.set(sentencesList.size() - 1, s);
        return sentencesList;
    }

    private int generateRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public String[] generateArrayOfString(){
        int randomWord = this.generateRandomInRange(1, 1000);
        String[] arr = new String[randomWord];
        for (int i = 0; i < randomWord; i++){
            arr[i] = " >>>word" + i + "<<< ";
        }
        return arr;
    }

}
