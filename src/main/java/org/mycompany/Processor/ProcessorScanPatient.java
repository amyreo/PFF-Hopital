package org.mycompany.Processor;

import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorScanPatient implements Processor{
	Scanner scan = new Scanner(System.in);
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
	
	
	System.out.println("posez votre question");
	String message = scan.nextLine();
	exchange.getIn().setBody(message);
	
	}
	

}
