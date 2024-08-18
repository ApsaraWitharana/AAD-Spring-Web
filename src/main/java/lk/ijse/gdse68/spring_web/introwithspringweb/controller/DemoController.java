package lk.ijse.gdse68.spring_web.introwithspringweb.controller;

import lk.ijse.gdse68.spring_web.introwithspringweb.dto.Customer;
import lk.ijse.gdse68.spring_web.introwithspringweb.dto.Item;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    //headers===>> artisanal information ==client sending ==application json //mine types ==data eke wargaya send krana
    //origin header ==>> client kwd kiyl dom ek send krnwa url ekk
    //authorization ==user name password /authentication
    //addishanal information ekk send krnwa
    //custom header= user yawan ewa ==// headers = "X-number"///X = convention ekk danawa ek custom ekk kiyl bala gnn
    @GetMapping(value = "/regex/{id:C\\d{2}-\\d{3}}",headers = "X-number") //set
    public String healthCheckRegexAndHeader(@PathVariable ("id")String id,@RequestHeader("X-number") int num){ //get header
        return "Path variable is: "+id +" and Header: "+ num;
    }
    //req==http://localhost:8080/intro/demo/regex/C00-001
    //resp==Path variable is:C00-001and Header50
    //Headers wal thamiy X-number ek danne

   // @PostMapping(consumes = "application/json" ) //set and client gen enne consumes
   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //json builder krgnn ekk enw kiyl
    public String saveJSON(){
        return "Save JSON";
        //req -http://localhost:8080/intro/demo
       //resp==>Save JSON
       // Headers wal thamiy danne ==>>>>>>.Content-Type-->application/json

    }


    @PostMapping("/dynamic/{value:\\d{2}}")
    public ResponseEntity<String> returnDynamicData(@PathVariable("value") int incomingValue){
        if (incomingValue % 2 == 0){
            return ResponseEntity.ok("Dynamic Data Even"); //client ta resp ek widiyata data kihipayk ywnn one unam use krgnn ResponseEntity use krnwa
        }

        return ResponseEntity.ok("Dynamic Data Odd");
    }
    //req--http://localhost:8080/intro/demo/dynamic/20
    //resp== Dynamic Data Even

    //request
    // 01
    @PostMapping(value = "/mapparams" ,params = {"id","desc"})
    public String handleMaps(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam Map<String,String> params){ //set method level prameter
        System.out.println(params); //map eke utility funshion krgnn puluwa
        // ym kisi stretcher ekkt data ek gnn ek meke map ekk widiyt data gtte
        return "Handle Map With Param: "+ params;
    }
    // Map = data structure ekk widiyata --> Map<key,value>
    // req= http://localhost:8080/intro/demo/mapparams?id=C00-001&desc=dusvi
    //resp = Handle Map With Param: {id=C00-001, desc=dusvi} //map eke data ywann one me widiyt kiyl auto ynwa spring

   // 02
   @PostMapping(value = "/multimapparams" ,params = {"id","desc"})
   public String handleMultiMaps(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam MultiValueMap<String,String> params){ //set method level prameter
       System.out.println(params);
       return "Handle Multi Map With Param: "+ params;
   }

   //req==http://localhost:8080/intro/demo/multimapparams?id=C00-001&desc=dusvi
   //resp ==-Handle Multi Map With Param: {id=[C00-001], desc=[dusvi]} //multimap eke array ekk widiyta data ynne
  //Map<[key],[value]> == this multi value map is use to spring as note using java


 //03 -map value set dto
 @PostMapping(value = "/multimapparamstodto" ,params = {"id","desc"})
 public String handleMultiMapsWithDTO(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam MultiValueMap<String,String> params , Item item){ //set method level prameter
     System.out.println(params);
     return "Handle Multi Map With DTO Param: "+ params;

     //req =>http://localhost:8080/intro/demo/multimapparamstodto?id=C00-001&desc=dusvi
     //resp==>>Handle Multi Map With DTO Param: {id=[C00-001], desc=[dusvi]}
 }

 //04
 @PostMapping(value = "/customer",consumes = MediaType.APPLICATION_JSON_VALUE)
 public String JSONToDTO(@RequestBody Customer customer){ //set request body eke mona hri enwa kiyl
// public String JSONToDTO( Customer customer){
     System.out.println("Customer ID: " + customer.getId());
     System.out.println("Customer Name: " + customer.getName());
     System.out.println("Customer Email: " + customer.getEmail());
        return "convert Successfully!!";

        //req==>>http://localhost:8080/intro/demo/customer
     //resp==>> convert Successfully!!
     //but data as null
     // Customer ID: null
     //Customer Name: null
     //Customer Email: null
     //note bine

    }
}



//annotation== method ekk data gide krn ek

//Spring MVC Framework:

//The class is annotated with @RestController, which is a Spring MVC annotation that indicates this class will handle HTTP requests and return data directly as the response body (usually JSON).
//The @RequestMapping("/demo") annotation at the class level specifies that this controller will handle all requests that start with /demo.
//The method healthCheck() is mapped to the /demo/health endpoint via @RequestMapping(value = "/health"). When a request is made to /demo/health, this method is invoked.