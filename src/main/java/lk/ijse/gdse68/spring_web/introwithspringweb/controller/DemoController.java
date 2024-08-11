package lk.ijse.gdse68.spring_web.introwithspringweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo") //
@RestController
public class DemoController {
    //servlet project ek controller ekk krnwa req,resp handle krnn spring mgin
    @RequestMapping(value = "/health")
    public String healthCheck(){
        return "DemoController run perfectly ";
    }
}
