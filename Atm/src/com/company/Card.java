package com.company;

public class Card {
    private String name;
    private Human human;
    private String pass;
    private int sum;

    public Card(String name, Human human, String pass, int sum) {
        this.name = name;
        this.human = human;
        this.pass = pass;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public Human getHuman() {
        return human;
    }

    public String getPass() {
        return pass;
    }

    public int getSum() {
        return sum;
    }

    public int takeMoney(int money){
        if (money > this.sum){
            System.out.println("не достаточно средств!");
            return -1;
        }
        this.sum = sum - money;
        System.out.println("выдача средств " + money + "р.");
        System.out.println("остаток средств " + this.getSum() + "р.");
        return money;
    }
}
