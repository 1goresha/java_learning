package com.company;

public class Bicycle {
    String model;
    int weight;

    Bicycle(String model, int weight){
        this.model = model;
        this.weight = weight;
    }


    public void start(){
        System.out.println("Поехали!!!");
    }



    public class SteeringWheel{
        public String isOk = "руль в порядке";

        public void right(){
            System.out.println("вправо!!!");
        }

        public void left(){
            System.out.println("влево!!!");
        }

        //внутренний класс имеет доступ в полям и методам внешнего класса,
        public void sayAboutModel(){
            System.out.println(model);

        }

    }

    public class Seat{
        public void up(){
            System.out.println("сиденье приподнято");
        }

        public void down(){
            System.out.println("сиденье опущено");
        }
    }
}
