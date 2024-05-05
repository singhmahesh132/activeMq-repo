package com.FileReadWriter;

import jakarta.jms.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class Sample {

	public static final Logger logger = LoggerFactory.getLogger(Sample.class);

	public static void main(String[] args) {
		SpringApplication.run(Sample.class,args);
	}

	@Bean
	public DefaultJmsListenerContainerFactory myfactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer){
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setSessionTransacted(true);
		configurer.configure(factory, connectionFactory);
		factory.setErrorHandler(err -> logger.error("Error in Queue Transaction :: {}", err.getMessage()));
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
		return new JmsTemplate(connectionFactory);
	}
}
