package com.shilibo.config;

import com.shilibo.Service.BookService;
import com.shilibo.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScan(value = "com.shilibo",includeFilters  = {
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
//@ComponentScan   value:指定要扫描的包
//excludeFilters:指定扫描的时候按照什么规则排除那些组件     默认是使用包含过滤器
//如果想使用includeFilters 需要将默认使用过滤器改为false
public class MainConfig {

    //给容器中注册一个Bean；类型为返回值类型，id默认是用方法名作为id
    @Bean("person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
