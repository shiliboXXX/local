package com.shilibo.config;

import com.shilibo.bean.Color;
import com.shilibo.bean.ColorFactoryBean;
import com.shilibo.bean.Person;
import com.shilibo.bean.Red;
import com.shilibo.condition.LinuxCondition;
import com.shilibo.condition.MyImportBeanDefinitionRegistrar;
import com.shilibo.condition.MyImportSelector;
import com.shilibo.condition.WindowsCondition;
import org.springframework.context.annotation.*;
//放在类上表示满足当前条件，类中bean进行加载
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})/*快速导入组件，id默认是组件的 全类名*/
public class MainConfig2 {

    //默认单实例
    /*  prototype:多实例：ioc容器启动不会创建对象放到容器中
                          每次获取的时候才会调用方法创建对象
        singleton：单实例（默认值）：ioc容器启动会调用方法创建对象放到容器中，以后获取直接从容器（map.get()）中拿
        request：同一次请求创建一个实例
        session：同一次session创建一个实例

        懒加载：（容器启动不创建对象，第一使用获取Bean创建对象，并初始化）
            单实例bean：默认在容器启动的时候创建对象
    * */
    /*@Scope("prototype")*/
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加person。。。。");
        return new Person("张三",25);
    }

    /*
    * @Conditional({})：按照一定条件进行判断，满足条件给容器中注册bean
    * 如果是windows，给容器中注册（“bill”）
    * 如果是linux系统，给容器中注册（“linus”）
    * */
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person01(){

        return new Person("Bill Gates",62);
    }
    /*
    * 在运行时可以设置参数 -Dos.name=linux 验证
    * */
    @Conditional(LinuxCondition.class)/*放在方法上就是判断当前bean进行条件判断*/
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }

    /*
    * 给容器中注册组件
    * 1)、包扫描+组件标注注解（@Controller、@service、@repository、@Component）[局限于自己写的类中]
    * 2）、@Bean[导入的第三方包里面的组件]
    * 3）、@Import[快速给容器中导入一个组件]
    *       1）、@Import(要导入到容器中的组件 )；容器中就会自动注册这个组件，id默认是全类名
    *     * 2）、ImportSelector：返回需要导入的组件的全类名数组    ---->springboot用的比较多
    *       3）、ImportBeanDefinitionRegistrar：手动注册Bean到容器中
    * 4)、使用Spring提供的FactoryBean（工厂Bean）
    *       1)、默认获取到的是工厂bean调用getObject创建的对象
    *       2）、要获取工厂Bean本身，我们需要给id前面加一个&前缀
    * */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
