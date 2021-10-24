package com.company;

import javafx.scene.chart.ScatterChart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilesUtil {

    public void getFiles(String path, int quantity, int size, String[] words, int probability) {
        int countOfChar = 0;
        int countOfSize = 0;
        String fileName = "text";
        try {
            for (int i = 1; i <= quantity; i++) {
                FileOutputStream fileOutputStream = new FileOutputStream(path + fileName + i + ".txt");
                List<String> list = this.generateText(size, words, probability);
                label:
                while (countOfSize <= size) {
                    for (String s : list) {
                        for (int b : s.getBytes()) {
                            if (countOfChar >= 60) {
                                fileOutputStream.write('\n');
                                countOfSize++;
                                countOfChar = 0;
                            }
                            if (countOfSize >= size) {
                                countOfSize = 0;
                                fileOutputStream.close();
                                break label;
                            }
                            fileOutputStream.write(b);
                            countOfChar++;
                            countOfSize++;
                        }
                    }
                }
                countOfSize = 0;
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private String generateWord() {
        int randomCharCount = this.generateRandomInRange(1, 15);
        char randomChar;
        String word = "";
        for (int i = 0; i < randomCharCount; i++) {
            randomChar = (char) this.generateRandomInRange(97, 122);
            word += randomChar;
        }
        return word + " ";
    }

    private List<String> generateSentence(String[] words, int probability) {
        int randomWordCount = this.generateRandomInRange(1, 15);
        int randomIndex = this.generateRandomInRange(0, words.length - 1);
        List<String> wordList = new ArrayList<>();
        boolean sw = true;
        for (int i = 0; i < randomWordCount; i++) {
            wordList.add(this.generateWord());
            if (Math.random() <= (double) 1 / probability && sw) {
                wordList.add(words[randomIndex]);
                sw = false;
            }
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

    private List<String> generateParagraph(String[] words, int probability) {
        List<String> sentencesList = new ArrayList<>();
        int randomSentence = this.generateRandomInRange(1, 20);
        for (int i = 0; i < randomSentence; i++) {
            sentencesList.addAll(generateSentence(words, probability));
        }
        String s = sentencesList.get(sentencesList.size() - 1) + "\r\n";
        sentencesList.set(sentencesList.size() - 1, s);
        return sentencesList;
    }

    private int generateRandomInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private List<String> generateText(int size, String[] words, int probability) {
        int textCount = 0;
        List<String> finalList = new ArrayList<>();
        while (textCount < size) {
            finalList.addAll(this.generateParagraph(words, probability));
            for (String s : finalList) {
                for (int i : s.getBytes()) {//очень редко выкидывает NullPointerException, хз почему...
                    textCount++;
                }
            }
        }
        return finalList;
    }

}
