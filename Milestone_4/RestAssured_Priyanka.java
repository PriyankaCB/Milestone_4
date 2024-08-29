package Milestone_4;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssured_Priyanka {
 
  @BeforeClass
  public void setup() {
      baseURI = "https://reqres.in/";
  }
  

  @Test
  public void createPerson() {
  	System.out.println("***Create Post Request****");
  	String reqBody = "{\r\n"
  			+"			   \"id\": \"10\", \r\n"
  			+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
  			+ "            \"first_name\": \"Akhilash\",\r\n"
  			+ "            \"last_name\": \"Bonu\",\r\n"
  			+ "        }";
      given()
          .body(reqBody)
      .when()
          .post("/api/users")
      .then()
          .statusCode(201);
  }
  
  @Test
  public void getAllPersons() {
  	System.out.println("***Get All Persons Request****");
      given()
      .when()
          .get("/api/users?page")
      .then()
          .statusCode(200);
  }

  @Test
  public void getPersonWithId() {
  	System.out.println("***Get one Person details with ID Request****");
      given()
      .when()
          .get("/api/users/10")
      .then()
          .statusCode(200);
  }

  @Test
  public void updatePersonDetails() {
  	System.out.println("***Update Person details Request****");
  	
  	String reqBody = "{\r\n"
  			
  			+ "            \"email\": \"michael1.lawson@reqres.in\",\r\n"
  			+ "            \"first_name\": \"Michael1\",\r\n"
  			+ "            \"last_name\": \"Lawson1\",\r\n"
  			+ "        }";
  	
      given()
          .body(reqBody)
      .when()
          .put("/api/users/10")
      .then()
          .statusCode(200);
  }
  
  @Test
  public void patchPartialUpdatePersonDetails() {
  	System.out.println("***Patch -- Partial Update Person details Request****");
  	
  	String reqBody = "{\r\n"
  			
  			+ "            \"email\": \"michael1.lawson@reqres.in\",\r\n"
  			+ "            \"first_name\": \"Kumar\",\r\n"
  			+ "            \"last_name\": \"Lawson1\",\r\n"
  			+ "        }";
  	
      given()
          .body(reqBody)
      .when()
          .patch("/api/users/10")
      .then()
          .statusCode(200);
  }

  @Test
  public void deletePerson() {
  	System.out.println("***Delete Person details Request****");
      given()
      .when()
          .delete("/api/users/10")
      .then()
          .statusCode(204);
  }
}
