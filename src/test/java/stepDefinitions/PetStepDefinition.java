package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import apiResources.APIResources;
import apiResources.TestDataBuild;
import apiResources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPetPojo;
import pojo.PetCategoryPojo;
import pojo.PetTagsPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class PetStepDefinition extends Utils {

	AddPetPojo addPetPojo = new AddPetPojo();
	PetCategoryPojo categoryPojo = new PetCategoryPojo();
	PetTagsPojo petTagsPojo = new PetTagsPojo();

	RequestSpecification addPetRequest;
	RequestSpecification getPetReq;
	ResponseSpecification addPetResSpec;
	static Response addPetResponse;
	static Integer petid;
	TestDataBuild testData = new TestDataBuild();

	@Given("I have a add new pet payload with {string} {string} {string} {string} {string} {string} {string} {string}")
	public void i_have_a_add_new_pet_payload_with(String petId, String name, String status, String photoURL,
			String tagId, String tagName, String categoryId, String categoryName) throws IOException {
		addPetRequest = given().log().all().spec(requestSpecification()).body(
				testData.addNewPetPayload(petId, name, status, photoURL, tagId, tagName, categoryId, categoryName));
	}

	@Given("I have a update pet Payload with {string} {string} {string} {string} {string} {string} {string} {string}")
	public void i_have_a_update_pet_payload_with(String petId, String name, String status, String photoURL,
			String tagId, String tagName, String categoryId, String categoryName) throws IOException {
		addPetRequest = given().log().all().spec(requestSpecification()).body(
				testData.addNewPetPayload(petId, name, status, photoURL, tagId, tagName, categoryId, categoryName));
	}

	@When("I send {string} request to {string}")
	public void i_send_http_request_to(String method, String resource) {

		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println("The resource to the post requuest is : " + resourceAPI.getResource());

		addPetResSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("POST"))
			addPetResponse = addPetRequest.contentType(ContentType.JSON).when().post(resourceAPI.getResource());
		else if (method.equalsIgnoreCase("GET"))
			addPetResponse = getPetReq.when().get(resourceAPI.getResource() + "/{petId}");
		else if (method.equalsIgnoreCase("DELETE"))
			addPetResponse = getPetReq.header("api_key", "special-key").when()
					.delete(resourceAPI.getResource() + "/{petId}");
		else if (method.equalsIgnoreCase("PUT"))
			addPetResponse = addPetRequest.contentType(ContentType.JSON).when().put(resourceAPI.getResource());

		System.out.println(addPetResponse.asString());
	}

	// .then().log().all().spec(addPetResSpec).extract().response();

	@Then("the Pet is added successfully with response status code {int}")
	public void the_pet_is_added_successfully_with_response_status_code(Integer int1) {
		assertEquals(200, addPetResponse.getStatusCode());

	}

	@Then("the response should contain the {string} and {string}")
	public void the_response_should_contain_the_pet_name(String expectedkey, String expectedvalue) {
		String response = addPetResponse.asString();
		JsonPath jsonPath = new JsonPath(response);

		System.out.println("the Name of the pet added is : " + jsonPath.get(expectedkey).toString());
		assertEquals(expectedvalue, jsonPath.get(expectedkey).toString());
	}

	@Given("a pet exists with ID {string}")
	public void a_pet_exists_with_id(String petId) throws IOException {
		petid = Integer.parseInt(petId);
		getPetReq = given().log().all().spec(requestSpecification()).pathParam("petId", Integer.parseInt(petId));
	}

	@Then("fetch request is successful with response code {int}")
	public void fetch_request_is_successful_with_response_code(Integer int1) {
		assertEquals(200, addPetResponse.getStatusCode());
	}

	@Then("the update should be successful with response code {int}")
	public void the_update_should_be_successful_with_response_code(Integer int1) {
		assertEquals(200, addPetResponse.getStatusCode());
	}

	@When("I send {string} request to {string} with form information {string} {string}")
	public void i_send_request_to_with_form_information(String method, String resource, String additionalMetaData,
			String image) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println("The resource to the post requuest is : " + resourceAPI.getResource());

		File file;
		try {
			String path = getClass().getClassLoader().getResource("test image.png").getPath();
			String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
			file = new File(decodedPath);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load image from resources", e);
		}

		addPetResSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		addPetResponse = getPetReq.param("additionalMetadata", additionalMetaData).multiPart("file", file).when()
				.post(resourceAPI.getResource() + "/{petId}" + "/uploadImage");
		System.out.println(addPetResponse.asString());
	}

	@Then("the Image should be uploaded successful with response code {int}")
	public void the_image_should_be_uploaded_successful_with_response_code(Integer int1) {
		assertEquals(200, addPetResponse.getStatusCode());
	}

	@Then("the pet should be deleted with response code {int}")
	public void the_pet_should_be_deleted_with_response_code(Integer int1) {
		assertEquals(200, addPetResponse.getStatusCode());
	}

}
