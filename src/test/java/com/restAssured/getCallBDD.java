package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class getCallBDD {

	//@Test
	public void testNumberOfCircuits_2017_Season() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
			then().
				assertThat().				
					statusCode(200).				
				and().				
					body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
				and().
					header("content-length", equalTo("4551"));			
	
		Response body = (Response) given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").getBody();
	
		
	}
	
	//@Test
	public void getAllSimulations() {
		when().
		    get("https://fakerestapi.azurewebsites.net/api/v1/Activities").
		then().
		    assertThat().
			    statusCode(200).and().
			    body("[0].title", equalTo("Activity 1")).
			    body("[0].completed", equalTo(false)).
			    body("[1].title", equalTo("Activity 2")).
			    body("[1].completed", equalTo(true));
		
	}
	
	//@Test
	public void printResponse() {
			
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/";
		RestAssured.basePath = "v1/Authors/";
		Response res = given().contentType(ContentType.JSON).log().all().get("authors/books/1");
		res.prettyPrint();
		
		String valueToVerify = given().contentType(ContentType.JSON).log().all().get("authors/books/1").then().extract().path("[1].firstName");
		System.out.println(valueToVerify);
		System.out.println(res.header("content-type"));
		
	}
}
