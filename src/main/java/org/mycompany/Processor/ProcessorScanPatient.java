package org.mycompany.Processor;

import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessorScanPatient implements Processor{
	Scanner scan = new Scanner(System.in);
	
	@Autowired
	ProducerTemplate producerTemplate;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
	
	
	System.out.println("posez votre question");
	String message = scan.nextLine();
	exchange.getIn().setBody(message);
	
	producerTemplate.requestBody("direct:patient", null,String.class);
	
	}
	

}
