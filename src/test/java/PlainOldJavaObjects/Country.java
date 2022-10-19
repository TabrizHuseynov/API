package PlainOldJavaObjects;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Country {

    // Custom method to return the capital name of country passed thru scanner


    public static String capitalCity(String country){
        RestAssured.baseURI = "https://restcountries.com/v3.1/name/";
        Response response=given().pathParam("name", country).
                when().get("{name}");
        int statusCode = response.thenReturn().statusCode();
        if(statusCode == 200){
            JsonPath jsonPath = response.jsonPath();
            String getCapital = jsonPath.getString("capital[0]");
            return getCapital.replace("[","").replaceAll("]","");
        }
        return "This country name or country code is not found on the system";
    }

    //returns country code of country

    public static String countryCode(String countryCode){
        RestAssured.baseURI = "https://restcountries.com/v3.1/alpha/";
        Response response=given().pathParam("alpha", countryCode).
                when().get("{alpha}");
        int statusCode = response.thenReturn().statusCode();
        if(statusCode == 200){
            JsonPath jsonPath = response.jsonPath();
            String country = jsonPath.getString("name.common");
            return country.replace("[","").replaceAll("]","");
        }
        return "This country name or country code is not found on the system";
    }




    public static String region(String countryCode){
        RestAssured.baseURI = "https://restcountries.com/v3.1/region/";
        Response response=given().pathParam("name", countryCode).
                when().get("{name}");
        response.then().
                assertThat().statusCode(200);

        JsonPath jsonPath = response.jsonPath();
        String capital = jsonPath.getString("ccn3");
        return capital;
    }
}