package org.mycompany.Processor;

import java.util.Scanner;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessorScanmedecinReponse implements Processor {
	Scanner scan = new Scanner(System.in);
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		String reception = exchange.getIn().getBody(String.class);
		System.out.println("la question est : " + reception+ "\n mettez votre reponse");
		
		String message = scan.nextLine();
		exchange.getIn().setBody(message);

	}

}
