package org.mycompany.route;

import org.apache.camel.builder.RouteBuilder;

public class PatientRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:depart").to("jms:queue:JT_ReponseMedecin").log("On a bien envoyé le message au médecin");

	}

}
