package com.company;

public class Human {
    private String name;
    private int cardCount;
    private final int MAXSIZE = 5;
    private Card[] cards;
    private int cash;

    public Human(String name){
        this.name = name;
        this.cards = new Card[MAXSIZE];
        this.cardCount = 0;
        this.cash = 0;
    }

    public void addCard(Card card){
        if (cardCount >5){
            System.out.println("в кошелек больше нет мест для карт!");
            return;
        }
        cards[cardCount] = card;
        cardCount++;
    }

    public Card[] getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
