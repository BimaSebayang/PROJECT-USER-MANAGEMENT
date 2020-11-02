package id.co.roxas.management.ui.web;

import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class WebUiManagementApplication {

	  @PostConstruct
	    void started() {
		  Locale.setDefault(Locale.US);
	    }

	
	public static void main(String[] args) {
		SpringApplication.run(WebUiManagementApplication.class, args);
	}
	
	 	@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowCredentials(true).allowedOrigins("*").allowedMethods("*");
	            }
	        };
	    }

}
