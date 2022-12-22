package org.mycompany.Processor;

import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorScanPatientNouveauMessage implements Processor {
	Scanner scan = new Scanner(System.in);

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("voulez cous posez une autre question ? o pour oui autre pour non");
		String message = scan.nextLine();
		exchange.getIn().setBody(message);
		
	}

}
