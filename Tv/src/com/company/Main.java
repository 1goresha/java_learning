package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Tv tv = new Tv();

        RemoteController remoteController = new RemoteController(tv);

        Channel news24 = new Channel("news24", 2);
        Channel sport24 = new Channel("sport24", 4);
        Channel TNT = new Channel("comedy club", 10);

        tv.addNewChannel(news24);
        tv.addNewChannel(TNT);
        tv.addNewChannel(sport24);
//        Channel animalPlanet = new Channel("animal planet", 15);
//        Channel discoveryChannel = new Channel("discovery channel", 5);

        Program prognozPogodi = new Program("Prognoz pogodi", "Прогноиз погоды на сегдня: весь день солнечно, +25");
        Program teleDebati = new Program("tele debati", "Сегдня у нас в гостях депутат из единной России и он несет какую то херню!");
        Program vesti = new Program("vesti", "правительство России подало в отставку");

        Program russianFootball = new Program("russian football", "и так добрый вечер всем, сегодня на стадионе Казань Арена произойдет встреча Рубина и ЦСКА");
        Program KHL = new Program("КХЛ", "фанаты требуют шайбу, шайбу, шайбу!!!");
        Program biatlon = new Program("biatlon", "и так, наш биатлонист на огневой позиции, внимание, тишина... да, пять из пяти, браво, чисто!!!");

        Program comedyWomen = new Program("comedy women", "мужики ни как не смогут не признаться в том, что они тайные агенты, потому что это так круто, они на свидании не могут промалочать о своих достижениях, что уж там говорить о вребовке в шпионы");
        Program DOM2 = new Program("Дом 2", "я тебя люблю.... ты меня не любишь... ты сука... ты блядь.... давай выяснять отношения прям здесь и сейчас же, и еще я сейчас кому нибудь въебу, чтобы поднять свой рейтинг, за счет дегенирото, которые смотрят на нас, таких дегениратов и имбицилов");
        Program psychicsVersus = new Program("Битва экстрасенсов", "здравствуйте, с вами ведущий шоу битва экстасенсов, Марат Башаров");

        news24.addNewProgram(prognozPogodi);
        news24.addNewProgram(teleDebati);
        news24.addNewProgram(vesti);

        sport24.addNewProgram(russianFootball);
        sport24.addNewProgram(KHL);
        sport24.addNewProgram(biatlon);

        TNT.addNewProgram(comedyWomen);
        TNT.addNewProgram(DOM2);
        TNT.addNewProgram(psychicsVersus);


        remoteController.pressButton();

        int a = 0;

    }
}
