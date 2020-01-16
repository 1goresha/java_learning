package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Human igor = new Human("Игорь");
        Human andrew = new Human("Андрей");

        Card sber = new Card("СберБанк", igor, "2626882", 530);
        Card tinkoff = new Card("Тинькофф", andrew, "111", 120);

        Atm atm = new Atm(530);

        atm.getMoney(30, sber, "2626882");
        atm.getMoney(500, sber, "2626882");
    }
}
