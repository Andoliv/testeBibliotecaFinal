package br.com.biblioteca;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MainServer extends SpringBootServletInitializer {

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory sessionFactory(HibernateEntityManagerFactory factory) {
		return factory.getSessionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(MainServer.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainServer.class);
	}

}
