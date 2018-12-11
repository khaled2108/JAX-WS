package com.jax.ws;

import org.jvnet.jax_ws_commons.spring.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jax.ws.web.methods.CustomerWebMethods;
import com.sun.xml.ws.transport.http.servlet.SpringBinding;
import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;

@EnableAutoConfiguration
@ComponentScan("com.jax.ws")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public ServletRegistrationBean<WSSpringServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<WSSpringServlet>(new WSSpringServlet(), "/customer");
    }
    
    @Autowired
    private CustomerWebMethods customerEndpoint;
    
    @Bean    
    public SpringBinding fooEndpoint() throws Exception {
        return bind(customerEndpoint, "/customer");
    }

    private SpringBinding bind(CustomerWebMethods endpoint, String url) throws Exception {
        SpringService springService = new SpringService();
        springService.setBean(endpoint);
        SpringBinding binding = new SpringBinding();
        binding.setService(springService.getObject());
        binding.setUrl(url);
        return binding;
    }
}
