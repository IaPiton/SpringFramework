package org.example.Config;

import org.example.ContactDirectiry;
import org.example.ContactDirectiryDefault;
import org.example.ContactDirectiryUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-def.properties")
@Profile("def")
public class DefAppConfig {


    @Bean
    public ContactDirectiry contactDirectiry() {
        return new ContactDirectiryDefault();
    }
}
