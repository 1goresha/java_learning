package com.company;

public class Atm {
    private int totalSum;

    public Atm(int totalSum) {
        this.totalSum = totalSum;
    }

    private boolean checkCardPass(Card card, String pass) {
        return card.getPass().equals(pass);
    }

    public void getMoney(int money, Card card, String pass) {
        if (checkCardPass(card, pass)) {
            System.out.println("зравствуйте " + card.getHuman().getName());
            if (this.getTotalSum() >= money) {
                card.takeMoney(money);
                this.totalSum -= money;
//                System.out.println("выдача средств " + money + "р.");
//                System.out.println("остаток средств " + card.getSum() + "р.");
            } else {
                System.out.println("в банкомате не достаточно средств для вывода, капец ты мажор!!!");
            }
        } else {
            System.out.println("не верный пароль!");
        }
    }

    public int getTotalSum() {
        return totalSum;
    }
}
