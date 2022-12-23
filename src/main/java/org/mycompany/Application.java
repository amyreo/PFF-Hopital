/**
 *  Copyright 2005-2021 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.mycompany;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;



import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * A spring-boot application that includes a Camel route builder to setup the Camel routes
 */

//@ComponentScan({ "org.mycompany.repo.*","org.mycompany.model.*", "org.mycompany.model.*","org.mycompany.controller.*"})
@SpringBootApplication
@EnableSwagger2
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application {
//	private static String url = "tcp://194.206.91.85:61616";
    // must have a main method spring-boot can run
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
//        CamelContext context = new DefaultCamelContext();
//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//		connectionFactory.createConnection("admin", "adaming2022");
//		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
//		System.out.println("On est bien connectés au broker activeMQ");
		
    }

}
