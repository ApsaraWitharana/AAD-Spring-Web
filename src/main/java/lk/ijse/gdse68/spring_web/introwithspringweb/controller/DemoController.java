package lk.ijse.gdse68.spring_web.introwithspringweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo") //
@RestController //meta annotation has controller annotation as this annotation has component annotation so this annotation as the managing to spring
//@Controller- return model SSP/SSR frontend manage krnn ui define krgnn  use we //set frontend to using this

//Rest API - ui note return,
public class DemoController {
    //servlet project ek controller ekk krnwa req,resp handle krnn spring mgin
    //front end ek ekk direct connect wenne controller-req

    //=========while card mapping==============//

    //1.    @RequestMapping(value = "/healt?") one character dispatch ona ekk ethnt dann puluwan req ekk send krddi
    //postman texting -http://localhost:8080/intro/demo/healtt =>>>h onam na h wenuwat ek caracter ekk set krnn puluwan
    //2.    @RequestMapping(value = "/healt??") two character dispatch two ekk ethnt dann puluwan req ekk send krddi
    //postman texting -http://localhost:8080/intro/demo/healttx =>>>h and next character onam na h nuyi ita passe ektyi wenuwat ek caracters ekk set krnn puluwan
    //3.   @RequestMapping(value = "/health/*") path segment ekk set krnn puluwan
    //postman texting -http://localhost:8080/intro/demo/health/text =>>>/* tanat ona segment ekk set krnn puluwan
    //4.   @RequestMapping(value = "/health/**") path segment ekk set krnn puluwan
    //postman texting -http://localhost:8080/intro/demo/health/text/text =>>>/** tanat ona segment ekk set krnn puluwan
    @RequestMapping(value = "/healt?") //same name mapping tiyenn ba
    public String healthCheck(){
        return "DemoController run perfectly !!!";
    }

    @RequestMapping
    public String otherTest(){
        return "otherText!!";
    }
}


//Spring MVC Framework:

//The class is annotated with @RestController, which is a Spring MVC annotation that indicates this class will handle HTTP requests and return data directly as the response body (usually JSON).
//The @RequestMapping("/demo") annotation at the class level specifies that this controller will handle all requests that start with /demo.
//The method healthCheck() is mapped to the /demo/health endpoint via @RequestMapping(value = "/health"). When a request is made to /demo/health, this method is invoked.