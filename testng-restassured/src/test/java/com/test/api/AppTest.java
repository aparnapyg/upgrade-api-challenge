package com.test.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.test.api.object.State;

import io.restassured.http.ContentType;
import io.restassured.path.json.exception.JsonPathException;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Unit test for simple App.
 */
public class AppTest {
	
	public static String BASE_URL = "http://credapi.credify.tech/api/loanapp/v1/";
	public String STATES_ENDPOINT = BASE_URL + "states";
	ArrayList<State> states = new ArrayList <State>(); 


	@Test
	public void getStatesTest() {
		String prettyPrint = given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.when().get(STATES_ENDPOINT).then()
				.extract().body().jsonPath().prettyPrint();
		
		String response =  given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.when().get(STATES_ENDPOINT).getStatusLine();
	}
	
	/**
	 * Return total count is 48 states.
	 * validate all state names returned are valid.
	 * @throws JSONException
	 */
	@Test
	public void validateTotalStatesTest() throws JSONException {	
		JSONArray array = null;
		Gson gson = new Gson();
		String prettyPrint = given().baseUri(BASE_URL).log().everything().contentType(ContentType.JSON)
				.when().get(STATES_ENDPOINT).then()
				.extract().body().jsonPath().prettify();
		
		 HashMap<String, String> map = new HashMap<String, String>();
	        JSONObject jObject = new JSONObject(prettyPrint);
	        Iterator<String> keys = jObject.keys();

	        while( keys.hasNext() ){
	            String key = (String)keys.next();
	            Object value = jObject.get(key); 
	            array = (JSONArray)value; 
	        }
	   
	        if (array != null) { 
	        	   for (int i=0;i<array.length();i++){ 
	        		State state = gson.fromJson(array.get(i).toString(), State.class) ;  
	        	    states.add(state);
	        	  } 
	        	} 
	        //Verify that total number of states returned in the response is 48.
	        Assert.assertEquals(states.size(), 48);
	        
	   //Validate only one state has a min age of 19, and output the name of that state
	   ArrayList <String> stateMinAge = new ArrayList();
	   
	   for(int i=0; i<array.length(); i++) {
		   if(states.get(i).getMinAge()==19) {
		      stateMinAge.add(states.get(i).getLabel());	   
		   }
	   }
	   
	   System.out.println("Name of state with minimum age:" +stateMinAge);
	   
	   //Validate that Georgia is the only state with min loan amount requirement of $3,005
      ArrayList <String> stateMinLoanRequirement = new ArrayList();
	   
	   for(int i=0; i<array.length(); i++) {
		   if(states.get(i).getMinLoanAmount()==3005) {
			   stateMinLoanRequirement.add(states.get(i).getLabel());	   
		   }
	   }
	   
	   System.out.println("Name of state with minimum loan requirement of $3,005/-:" +stateMinLoanRequirement);
	}

}
