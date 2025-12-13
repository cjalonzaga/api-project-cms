package com.project.api.config;

import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public TomcatContextCustomizer sameSiteCookieConfig(){
//        return context -> {
//            Rfc6265CookieProcessor processor = new Rfc6265CookieProcessor();
//            processor.setSameSiteCookies("Strict");
//            context.setCookieProcessor(processor);
//        };
//    }

}
