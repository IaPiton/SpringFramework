package org.example.Config;

import org.example.Profile.ContactDirectory;
import org.example.Profile.ContactDirectoryDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-def.properties")
@Profile("default")
public class DefAppConfig {


    @Bean
    public ContactDirectory contactDirectiry() {
        return new ContactDirectoryDefault();
    }
}
