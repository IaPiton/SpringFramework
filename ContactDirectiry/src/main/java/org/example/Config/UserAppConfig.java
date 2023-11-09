package org.example.Config;

import org.example.Profile.ContactDirectory;
import org.example.Profile.ContactDirectoryUser;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources(
        value = {
                @PropertySource("classpath:application-user.properties")
        }
)
@Profile("user")
public class UserAppConfig  {
        @Bean
        public ContactDirectory contactDirectiry(){
                return new ContactDirectoryUser();
        }
}
