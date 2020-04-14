package net.nalpari.monitoring.config.web;

import net.nalpari.monitoring.config.shutdown.EosShutdown;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public EosShutdown eosShutdown() {
        return new EosShutdown();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(final EosShutdown eosShutdown) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(eosShutdown);
        return factory;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8090");
    }
}
