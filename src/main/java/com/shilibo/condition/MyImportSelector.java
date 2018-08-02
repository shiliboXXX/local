package com.shilibo.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值，就是到导入到容器中的组件全类名
    //annotationMetadata:当前标注@Import注解的类的所有注解信息
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //annotationMetadata
        //方法不能返回null，否则会报空指针异常
        return new String[]{"com.shilibo.bean.Blue","com.shilibo.bean.Yellow"};
    }
}
