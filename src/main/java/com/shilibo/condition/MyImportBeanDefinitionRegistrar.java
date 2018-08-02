package com.shilibo.condition;

import com.shilibo.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /*
    annotationMetadata:当前类的注解信息
    beanDefinitionRegistry：beanDefinition注册类
            把所有需要添加到容器中的bean：调用beanDefinitionRegistry.registerBeanDefinition手工注册进来
    * */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.shilibo.bean.Red");
        boolean definition2= beanDefinitionRegistry.containsBeanDefinition("com.shilibo.bean.Red");
        if(definition&&definition2){
            //指定Bean定义信息（类型，scope）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定Bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
