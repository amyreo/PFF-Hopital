package org.mycompany;

import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class Test {

	public static String appel(String filename) {
		Object input = JsonUtils.classpathToObject(filename);
		System.out.println("Point 1");
		List<Object> chainrSpecJSON = JsonUtils.classpathToList("spec.json");
		System.out.println("Point 2");
		Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
		Object output = chainr.transform(input);
		String finalOutput = JsonUtils.toPrettyJsonString(output);
		return finalOutput;
	}

}
