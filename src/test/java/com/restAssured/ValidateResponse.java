package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;





public class ValidateResponse {
	
	//@Test
	public void validateResCode() {
		Response res = given(). 
			when().
	          get("http://jsonplaceholder.typeicode.com/posts/3");
	 System.out.println(res.statusCode());
	 Assert.assertEquals(res.statusCode(), 200);
	}
	
	//@Test
	public void validateValueInRes() {
	    given().
		   get("https://fakerestapi.azurewebsites.net/api/v1/Authors").then().
		          statusCode(200).and().
		              body("[0].firstName", equalTo("First Name 1"));
		   	 
	}
	
	// verify single content using org.hamcrest.Matchers library's equalTo method
	//@Test
	public void testEqualToFunction() {
		given().
			get("https://fakerestapi.azurewebsites.net/api/v1/Activities"). 
				then(). 
					statusCode(200).body("[0].title", equalTo("Activity 1"));
	}
	
	// verify multiple contents using org.hamcrest.Matchers library's hasItems method 
	@Test
	public void testHasItemsFunction() {
		given(). 
			get("https://fakerestapi.azurewebsites.net/api/v1/Activities").
				then(). 
					body("title",hasItems("Activity 1","Activity 2","Activity 3"));
		
	}
    
	// Setting up headers and parameters
	@Test
	public void setHeadersAndParams() {
		given().
			param("Key_1","Value_1"). 
			header("key_1","value_1"). 
				when(). 
					get("https://fakerestapi.azurewebsites.net/api/v1/Activities"). 
					then(). 
						statusCode(200).log().all();
			 
	}

	// Handel xml response data 
	@Test
	public void handleXmlData() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10"). 
			then(). 
				statusCode(200).body("FIRSTNAME", equalTo("Sue"));
		System.out.println("Response validated");
		System.out.println("Add this file t staging area without commiting it and view it");
	}

}

