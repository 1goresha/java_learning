package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Human h0 = new Human("Igor", 30, 174);
        Human h1 = new Human("Igor", 30, 174);
        Human h2 = new Human("NotIgor", 30, 174);
        Human h3 = h2;

        System.out.println(h1.equals(h2));// переопределен метод equals, который сравнивает сперва ссылки на объекты, затем принадлежат ли объекты к одному и тому же классу, затем сравнивает объекты по полям
        System.out.println(h2.equals(h3));//объектные переменные ссылаются на один и тот же объект, поэтому true
        System.out.println(h0.equals(h1));//созданы разные объекты, но их поля равны, поэтому true
        System.out.println(h0 == h1);//не смотря на одинаковые поля у объектов,они разные, потому что имеют разные ссылки на объект. знак == сравнивает ссылки объектов
    }
}
