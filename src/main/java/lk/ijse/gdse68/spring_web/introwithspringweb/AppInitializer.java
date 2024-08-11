package lk.ijse.gdse68.spring_web.introwithspringweb;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lk.ijse.gdse68.spring_web.introwithspringweb.config.WebAppConfig;
import lk.ijse.gdse68.spring_web.introwithspringweb.config.WebAppRootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//class name has all working types

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //config class 2kt wadiy tiynn puluwan -root or not root
        return new Class[]{WebAppRootConfig.class};
        //hibernate,db ekkt bean ekk config krnn one nm //web app eke http req t adal nati ewa
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};//web app eke http req t adal class danne
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //what is the mapping default mapping set  =>dispatcher servlet kranwa
    }
}












//boll class appinit class //webapp-boll,/annotation ==>servlte ewa req.resp handling