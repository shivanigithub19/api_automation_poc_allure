package com.api.petstore.testservices;

import java.io.IOException;

import com.api.petstore.constants.Endpoints;
import com.api.petstore.model.CreateUserRequest;
import com.api.petstore.model.CreateUserResponse;
import com.api.petstore.utils.JsonFilesPath;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetUserDataService extends JsonFilesPath {
	
	ObjectMapper MAPPER = new ObjectMapper();
	CreateUserRequest createRequest = new CreateUserRequest();
	CreateUserResponse createResponse = new CreateUserResponse();
	
	public CreateUserResponse createUser() throws IOException {

		CreateUserRequest createData = MAPPER.readValue(createUserFile, CreateUserRequest.class);
		
		
		Response response = RestAssured.given()
				
				
				.contentType(ContentType.JSON)
				.body(createData)
				.filter(new AllureRestAssured())
				.log().all()
				.post(Endpoints.POST_DATA);


		String  postData =response.getBody().asString();

		createResponse = MAPPER.readValue(postData, CreateUserResponse.class);

		
		
		return  createResponse;

}
	
	public CreateUserRequest getUserData() throws IOException {

		createUser();
		
		JsonNode jsonNode = MAPPER.readTree(createUserFile);
		String userNameNode = jsonNode.get("username").asText();
		
		//System.out.println("UserName is :" +userNameNode);
		
		Response response = RestAssured.given()
				
				
				.contentType(ContentType.JSON)
				.pathParam("username", userNameNode)
				.filter(new AllureRestAssured())
				.log().all()
				.get(Endpoints.GET_DATA);


		String  getData =response.getBody().asString();

		createRequest = MAPPER.readValue(getData, CreateUserRequest.class);

		
		
		return  createRequest;

}

}
