package apiResources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification addPetBaseReq;

	public RequestSpecification requestSpecification() throws IOException {

		if (addPetBaseReq == null) {
			PrintStream log = new PrintStream(new FileOutputStream("target/logs/logging.txt"));
			addPetBaseReq = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
			return addPetBaseReq;
		}
		return addPetBaseReq;
	}

	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream("global.properties");
		prop.load(input);

		return prop.getProperty(key);
	}

	public String getJsonPath(Response response, String key) {
		JsonPath jsonPath = new JsonPath(response.asString());
		return jsonPath.get(key).toString();
	}

}
