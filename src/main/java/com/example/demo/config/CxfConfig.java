package com.example.demo.config;

import com.example.demo.ws.CompteSoapService;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.Service;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.xml.namespace.QName;
import java.util.Arrays;

/**
 * Classe de configuration pour Apache CXF.
 * Cette classe configure et expose le service web SOAP via JAX-WS.
 * 
 * L'annotation @Configuration indique à Spring que cette classe contient des définitions de beans.
 */
@Configuration
public class CxfConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    @Primary
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        ServletRegistrationBean<CXFServlet> servletRegistration = 
            new ServletRegistrationBean<>(new CXFServlet(), "/services/*");
        servletRegistration.setLoadOnStartup(1);
        return servletRegistration;
    }

    @Bean
    public Endpoint endpoint(CompteSoapService compteSoapService) {
        EndpointImpl endpoint = new EndpointImpl(springBus(), compteSoapService);
        endpoint.setServiceName(new QName("http://ws.demo.example.com/", "BanqueWSService"));
        endpoint.setEndpointName(new QName("http://ws.demo.example.com/", "BanqueWSPort"));
        endpoint.publish("/BanqueWS");
        return endpoint;
    }
}