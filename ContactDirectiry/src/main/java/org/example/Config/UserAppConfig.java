package org.example.Config;

import org.example.ContactDirectiry;
import org.example.ContactDirectiryUser;
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
        public ContactDirectiry contactDirectiry(){
                return new ContactDirectiryUser();
        }
}
