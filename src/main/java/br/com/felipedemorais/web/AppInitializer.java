package br.com.felipedemorais.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    private  static final String CONFIG_LOCATION = "br.com.felipedemorais.config";

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println(String.format("Initializing Application for %s", servletContext.getServerInfo()));

        // Create application Context
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation(CONFIG_LOCATION);


        // Add the servlet mapping manually and make it initialize automatically
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic servelet = servletContext.addServlet("mvc-dispatcher",  dispatcherServlet);

        servelet.addMapping("/");
        servelet.setAsyncSupported(true);
        servelet.setLoadOnStartup(1);
    }

}
