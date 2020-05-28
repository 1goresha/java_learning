package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileUtil fileUtil = new FileUtil("file_for_sorting.txt", "file_for_sorted.txt");
        fileUtil.readFileAndSortWordsByAlphabet();
        fileUtil.writeToFile();
//        fileUtil.showSortWords();
    }
}
