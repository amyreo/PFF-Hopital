package org.mycompany.Processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ProcessorRoutePatientOuMed implements Processor {
	@Autowired
	ProducerTemplate producerTemplate;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("fin de la rourtes patient avant nouvelle route") ;
		producerTemplate.requestBody("direct:patient", null,String.class);
		System.out.println("fin de la rourtes patient") ;
	}
	
	 

}
