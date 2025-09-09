package ec.com.giocompany.cajaahorro.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public FilterRegistrationBean<NoCacheFilter> noCacheFilter() {
        FilterRegistrationBean<NoCacheFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new NoCacheFilter());
        registrationBean.addUrlPatterns("/*"); // o lo que necesites
        return registrationBean;
    }
}
