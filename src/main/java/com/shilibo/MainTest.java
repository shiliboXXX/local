package com.shilibo;

import com.shilibo.bean.Person;
import com.shilibo.config.MainConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args){
        /*ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Person bean= (Person) applicationContext.getBean("person");
        System.out.println(bean);*/

        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = annotationContext.getBean(Person.class);
        System.out.println(bean);


        String[] namesForType = annotationContext.getBeanNamesForType(Person.class);
        for(String name : namesForType){
            System.out.println(name);
        }
    }
}
