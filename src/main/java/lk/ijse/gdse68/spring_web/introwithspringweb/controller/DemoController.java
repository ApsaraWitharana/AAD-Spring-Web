package lk.ijse.gdse68.spring_web.introwithspringweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo") //
@RestController //meta annotation has controller annotation as this annotation has component annotation so this annotation as the managing to spring
//@Controller- return model SSP/SSR frontend manage krnn ui define krgnn  use we //set frontend to using this

//Rest API - ui note return,
public class DemoController {
    //servlet project ek controller ekk krnwa req,resp handle krnn spring mgin
    @RequestMapping(value = "/health")
    public String healthCheck(){
        return "DemoController run perfectly !!!";
    }
}


//Spring MVC Framework:

//The class is annotated with @RestController, which is a Spring MVC annotation that indicates this class will handle HTTP requests and return data directly as the response body (usually JSON).
//The @RequestMapping("/demo") annotation at the class level specifies that this controller will handle all requests that start with /demo.
//The method healthCheck() is mapped to the /demo/health endpoint via @RequestMapping(value = "/health"). When a request is made to /demo/health, this method is invoked.