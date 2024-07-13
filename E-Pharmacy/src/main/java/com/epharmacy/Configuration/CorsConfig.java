package com.epharmacy.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String DELETE = "DELETE";
	private static final String PUT = "PUT";

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")// Enables cors for the whole application.
						.allowedMethods(GET, PUT, POST, DELETE)
						.allowedHeaders("*")
						.allowedOriginPatterns("*")
						.allowCredentials(true);
			}
		};
	}

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://localhost:4200"); // Replace with your Angular app's URL
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsFilter filter = new CorsFilter(corsConfigurationSource());
//        return filter;
//    }

}
