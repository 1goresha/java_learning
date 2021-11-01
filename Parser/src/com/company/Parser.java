package com.company;

import java.io.*;
import java.util.ArrayList;

public class Parser {

    public ArrayList<String> parse(File file) throws IOException {

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> text = new ArrayList<>();
        String s = "";

        if (bufferedReader != null) {

            s = bufferedReader.readLine();
            while (s != null) {

                text.add(s);
                s = bufferedReader.readLine();
            }
        }

        return text;
    }

    public int findCountOfWord(ArrayList<String> text, String word) {

        int count = 0;

        for (String line : text) {

            if (line.contains(word)){

                count++;
            }
        }

        return count;
    }
}
