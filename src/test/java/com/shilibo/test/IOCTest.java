package com.shilibo.test;

import com.shilibo.bean.Blue;
import com.shilibo.bean.Person;
import com.shilibo.config.MainConfig;
import com.shilibo.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;


public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test02(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("ioc容器创建完成。。。");
        Object bean1 = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean1==bean2);

    }

    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值：windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testImport(){
        printBeans(applicationContext);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean = applicationContext.getBean("colorFactoryBean");
        //获取工厂本身这个对象  加&前缀
        Object bean1 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型："+bean1.getClass());

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
