package lk.ijse.gdse68.spring_web.introwithspringweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="lk.ijse.gdse68.spring_web.introwithspringweb" )//root package and sub package object to manage spring
public class WebAppConfig {
}
