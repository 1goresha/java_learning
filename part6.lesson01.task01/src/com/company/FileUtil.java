package com.company;

import java.io.*;
import java.util.*;
import java.util.List;


public class FileUtil {
    private Set<String> listSet;
    private List<String> list;
    private String fileForSorting;
    private String sortedFile;

    public FileUtil(String fileForSorting, String sortedFile) {
        this.fileForSorting = fileForSorting;
        this.sortedFile = sortedFile;
        this.listSet = new HashSet<>();
        this.list = new ArrayList<>();
    }

    public void readFileAndSortWordsByAlphabet() {
        int i;
        String word = "";
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileForSorting))){
            while ((i = bufferedInputStream.read()) != -1) {
                if ((char) i != ' '
                        && (char) i != ','
                        && (char) i != '.'
                        && (char) i != ':'
                        && (char) i != ';'
                        && (char) i != '?'
                        && (char) i != '!'
                        && (char) i != '-'
                        && (char) i != '='
                        && (char) i != '_'
                        && (char) i != '\r'
                        && (char) i != '\n'
                        && (char) i != '('
                        && (char) i != ')'
                        && (char) i != '/'
                        && (char) i != '\\'
                        && (char) i != '"'
                        && (char) i != '\'') {
                    word += (char) i;
                } else if (word != "") {
                    listSet.add(word);
                    word = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("problems with BufferedInputStream");
        }
        list.addAll(0, listSet);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });
    }

    public void showSortWords(){
        for (String s :
                list) {
            System.out.println(s);
        }
    }

    public void writeToFile(){
        byte[] bytes;
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.sortedFile))){
            for (String s :
                    list) {
                bytes = s.getBytes();
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.write('\n');
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("problems with BufferedOutputStream");
        }
    }
}
