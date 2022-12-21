package org.mycompany.Processor;

import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorScanPatientNouveauMessage implements Processor{
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
	
	Scanner scan = new Scanner(System.in);
	System.out.println("voulez cous posez une autre question ? o pour oui autre pour non");
	String message = scan.next();
	exchange.getIn().setBody(message);
	
	}
	

}
