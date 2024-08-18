package lk.ijse.gdse68.spring_web.introwithspringweb.controller;

import org.springframework.web.bind.annotation.*;

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

//    @RequestMapping(value = "/health") //same name mapping tiyenn ba
//    public String healthCheck(){
//        return "DemoController run perfectly ;
//    }

    //set mapping parameter path variable ==req-http://localhost:8080/intro/demo/health/sachini ==>.resp->>DemoController run perfectly whith:sachini
//    @GetMapping(value = "/health/{name}")
//    public String healthCheck(@PathVariable ("name")String name){
//        return "DemoController run perfectly whith:"+name;
//    }

    //validating -regex
    //req--http://localhost:8080/intro/demo/regex/C400
    //resp-->DemoController run perfectly whith:C400
//    @GetMapping(value = "/regex/{id:C\\d{3}}")
    //req-http://localhost:8080/intro/demo/regex/C00-001
    @GetMapping(value = "/regex/{id:C\\d{2}-\\d{3}}")
    public String healthCheckRegex(@PathVariable ("id")String id){
        return "DemoController run perfectly whith:"+id;
    }
    //text-mapping--
    //req-->http://localhost:8080/intro/demo?test=all
    //resp-->>Text all Mapping !!
    @GetMapping(params = "test=all")
    public String healthCheckParam(){
        return "Text all Mapping !!";
    }

    @RequestMapping
    public String otherTest(){
        return "otherText!!";
    }

    //request param
    @PostMapping(params = {"name","qty"}) //set param
    public String paramData(@RequestParam ("name") String param01,@RequestParam ("qty") String param02){ //get param
        return "Param data is:" +param01 + " and "+param02;

        //req postman-->http://localhost:8080/intro/demo?name=apple&qty=100
        //resp -->> Param data is:apple and 100
        //body parameter change  krl apit one widiyt hadagnn puluwan
        //problem (req) resole wen ekk
        //query string resolving
    }
}

//annotation== method ekk data gide krn ek

//Spring MVC Framework:

//The class is annotated with @RestController, which is a Spring MVC annotation that indicates this class will handle HTTP requests and return data directly as the response body (usually JSON).
//The @RequestMapping("/demo") annotation at the class level specifies that this controller will handle all requests that start with /demo.
//The method healthCheck() is mapped to the /demo/health endpoint via @RequestMapping(value = "/health"). When a request is made to /demo/health, this method is invoked.