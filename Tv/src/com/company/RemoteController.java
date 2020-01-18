package com.company;

public class RemoteController {
    private Tv tv;

    public RemoteController(Tv tv){
        this.tv = tv;
    }

    public void pressButton(){
        tv.showRandomChannel();
    }
}
