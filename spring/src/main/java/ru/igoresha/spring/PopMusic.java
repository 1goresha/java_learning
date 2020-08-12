package ru.igoresha.spring;

import org.springframework.stereotype.Component;

public class PopMusic implements Music{

    @Override
    public String getSong() {
        return "i believe i can fly";
    }
}
