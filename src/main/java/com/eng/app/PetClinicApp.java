package com.eng.app;

import com.eng.app.props.PetClinicProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableConfigurationProperties(value = {PetClinicProperties.class} )
@SpringBootApplication
@ServletComponentScan
@EnableScheduling
public class PetClinicApp {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApp.class,args);
    }

}
