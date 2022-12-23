package org.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan({ "org.mycompany.repo.*","org.mycompany.model.*", "org.mycompany.model.*","org.mycompany.controller.*"})
@SpringBootApplication
@EnableSwagger2
@ImportResource({ "classpath:spring/camel-context.xml" })
public class Application {
//	private static String url = "tcp://194.206.91.85:61616";
	public static void main(String[] args) throws Exception {

//		
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
//		builder.headless(false);
//		ConfigurableApplicationContext context = builder.run(args);

		SpringApplication.run(Application.class, args);
//      CamelContext context = new DefaultCamelContext();
//      ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//		connectionFactory.createConnection("admin", "adaming2022");
//		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
//		System.out.println("On est bien connectés au broker activeMQ");

	}

}
