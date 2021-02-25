package com.strzelczyk.Springbootapp;

import com.strzelczyk.Springbootapp.DAO.Item;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.match.ContentRequestMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "/application.properties")
class SpringBootAppApplicationTests{


	@Test
	public void checkAllOrders() {

		RestAssured.get("http://localhost:7070/order/all")
				.then().statusCode(200).
				log().all();
	}

	@Test
	public void saveActualOrder() {

		RestAssured.get("http://localhost:7070/item/saveOrder")
				.then().statusCode(200).
				log().all();
	}


	@Test
	public void checkActualOrder() {

		RestAssured.get("http://localhost:7070/item/checkActualOrder")
				.then().statusCode(200).
				log().all();
	}



	@Test
	public void actualOrderCost() {

		RestAssured.get("http://localhost:7070/item/actualOrderCost")
				.then().statusCode(200).
				log().all();
	}

	@Test
	public void addToOrder() {

		RestAssured.get("http://localhost:7070/item/addToOrder/?index=1")
				.then().statusCode(200).
				log().all();;
	}





@Test
public void PUT_test1() {


	JSONObject request = new JSONObject();
	request.put("id",1);
	request.put("name", "PlayStation5");
	request.put("price", 3000);

	RestAssured.given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
			when().
			put("http://localhost:7070/item").
			then().statusCode(200).
			log().all();
}



	@Test
	public void addItem(){
		Item item = new Item();
		item.setName("PlayStation5");
		item.setPrice((double) 2000);


		RestAssured
				.given()
				.contentType("application/json")
				.body(item)
				.when().post("http://localhost:7070/item").then()
				.statusCode(200)
				.log().all();
	}

@Test
public void aaConnectionTest() {

	Response response = RestAssured.get("http://localhost:7070/item/all");

	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode,200);
}

}
