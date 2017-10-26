package com.woniu;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
 * file路径： locations ={"file:d:/test/application-bean1.xml"};
 * @ImportResource({"classpath*:applicationContext*.xml"})
 */
@Configuration
@ImportResource(locations={"classpath:spring-redis.xml"})
//@ImportResource(locations={"file:d:/test/application-bean1.xml"})
//@ImportResource({"classpath*:applicationContext*.xml"})
public class  ConfigClass {

}
