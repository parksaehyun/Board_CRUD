package org.choongang.global.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public HiddenHttpMethodFilter httpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
}
