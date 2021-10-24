package ru.igoresha.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean testBean = classPathXmlApplicationContext.getBean("testBean", TestBean.class);
        System.out.println(testBean.getName());
    }
}
