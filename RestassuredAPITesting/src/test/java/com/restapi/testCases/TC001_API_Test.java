/*
 * Author: Rajesh
 * summary: Test Case 1
 * Date: 08/Apr/20
 */

/******************************************************
Test API
URI:   https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false"
Request Type: GET

********* Validations **********
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : application/json
Name = "Carbon credits";
canRelist = "true";
Promotion Name = "Gallery";
Promotion Description = "Good position in category";

**********************************************************/

package com.restapi.testCases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.restapi.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_API_Test extends TestBase {

	RequestSpecification httpRequest;
	Response response;

	String nameCarbon = "Carbon credits";
	String canRelistValue = "true";
	String promoName = "Gallery";
	String promDescrip = "Good position in category";

	@BeforeClass
	public void createEmployee() throws InterruptedException {
		logger.info("********* Started TC001**********");
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "");
	}

	@Test(priority=0)
	public void checkStatusCode() {
		logger.info("*********Check Status Code**********");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test(priority=1)
	public void checkstatusLine() {
		logger.info("*********Check Status Line**********");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test(priority=2)
	public void checkContentType() {
		logger.info("*********Check Content Type**********");
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json");
	}

	@Test(priority=3)
	public void checkResposeBody() {
		logger.info("*********Print Response Body**********");
		String responseBody = response.getBody().prettyPrint();
		logger.info(responseBody);
	}

	@Test(priority=4)
	public void checkName() {
		logger.info("*********Verify the Name**********");
		String name = response.path("Name").toString();
		Assert.assertEquals(name, nameCarbon);
		logger.info(name);

	}

	@Test(priority=5)
	public void checkCanRelist() {
		logger.info("*********Verify CanRelist Status**********");
		String canrelist = response.path("CanRelist").toString();
		Assert.assertEquals(canrelist, canRelistValue);
		logger.info(canrelist);
	}

	@Test(priority=6)
	public void checkNameDescrp() {
		logger.info("*********Verify Promotion Description with respet promotion name - Gallery**********");
		List<String> promtionNames = response.jsonPath().getList("Promotions.Name");
		for (int i = 0; i < promtionNames.size(); i++) {
			if (promtionNames.get(i).equals(promoName)) {
				String description = response.jsonPath().getList("Promotions.Description").get(i).toString();
				Assert.assertTrue(promDescrip.contains(description));
			}
		}

	}

	@AfterClass
	public void tearDown() {
		logger.info("*********  Finished TC001 **********");
	}

}
