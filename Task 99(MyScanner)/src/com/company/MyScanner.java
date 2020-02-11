package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyScanner {
    private String fileName;

    public MyScanner(String fileName) {
        this.fileName = fileName;
    }

    public int nextInt(){
        int result = -1;
        try {
            int i = 0;
            InputStream inputStream = new FileInputStream(this.fileName);
            byte[] bytes = inputStream.readAllBytes();
            char[] chars = new char[bytes.length];
            for (byte b :
                    bytes) {
                chars[i] = (char) b;
                i++;
            }
            result = Integer.parseInt(String.valueOf(chars));
        } catch (FileNotFoundException e) {
            System.out.println("не найден файл " + this.fileName);
        } catch (IOException e) {
            System.out.println("ошибка ввода/вывода");
        }catch(NumberFormatException e){
            System.out.println("нерпавильный формать числа");
        }
        return result;
    }
}
