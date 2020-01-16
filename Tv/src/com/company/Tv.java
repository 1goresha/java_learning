package com.company;

public class Tv {
    private Channel[] channels;
    private int currentCountOfChannels;
    private final int MAX_COUNT_OF_CHANNELS = 5;

    public Tv(){
        channels = new Channel[MAX_COUNT_OF_CHANNELS];
        currentCountOfChannels = 0;
    }

    public void addNewChannel(Channel channel){
        if (currentCountOfChannels > MAX_COUNT_OF_CHANNELS)
        this.channels[currentCountOfChannels] = channel;
        currentCountOfChannels++;
    }
}
