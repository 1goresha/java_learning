package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Parser parser = new Parser();
        ArrayList<String> warAndPeace = null;

        File file = new File("warAndPeace.txt");
        try {
            warAndPeace = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(warAndPeace != null){

            warAndPeace.forEach(System.out::println);
            System.out.println("количество найденных слов : " + parser.findCountOfWord(warAndPeace, "страдание"));
        }
    }
}
