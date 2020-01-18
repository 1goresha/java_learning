package com.company;

import java.util.Random;

public class Tv {
    private Channel[] channels;
    private int currentCountOfChannels;
    private final int MAX_COUNT_OF_CHANNELS = 3;

    public Tv(){
        channels = new Channel[MAX_COUNT_OF_CHANNELS];
        currentCountOfChannels = 0;
    }

    public void addNewChannel(Channel channel){
        if (currentCountOfChannels > MAX_COUNT_OF_CHANNELS){
            return;
        }
        this.channels[currentCountOfChannels] = channel;
        currentCountOfChannels++;
    }

    public void showRandomChannel(){
        Random random = new Random();
        int rand = random.nextInt(MAX_COUNT_OF_CHANNELS);
        if (channels[rand] == null){
            System.out.println("can not find this channel");
            return;
        }
        channels[rand].showRandomProgram();
    }
}
