package se.atg.service.harrykart.java;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("java-test")
public class HarryKartAppTest {

    private final static URI harryKartApp = URI.create("http://localhost:8181/java/api/play");

    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Trying to GET instead of POST should return 405 Method not allowed")
    void useGetOnPostEndpointShouldNotBePossible() {
        when()
                .get(harryKartApp)
                .then()
                .assertThat()
                .statusCode(405);
    }


    @Test
    @DisplayName("get ranking where input is empty")
    void cantPlayYetEmpty() throws IOException {
        String FilePath = "./src/test/resources/empty.xml";
        String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
        given()
                .header("Content-Type", ContentType.XML)
                .body(XMLBodyToPost)
                .when()
                .post(harryKartApp)
                .then()
                .assertThat()
                .statusCode(describedAs("Bad Request", is(400)))
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("message", equalTo(""));
    }

    @Test
    @DisplayName("get ranking where harry kart is empty")
    void cantPlayYet() throws IOException {
        String FilePath = "./src/test/resources/input.xml";
        String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
        var response = given()
                .header("Content-Type", ContentType.XML)
                .body(XMLBodyToPost)
                .when()
                .post(harryKartApp)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .extract();
        Assertions.assertEquals(response.response().asString(), "{\n" +
                "  \"ranking\" : [ ]\n" +
                "}");
    }

    @Test
    @DisplayName("get ranking for the first example")
    void cantPlayYetFirstExample() throws IOException {
        String FilePath = "./src/test/resources/input_0.xml";
        String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
        var response = given()
                .header("Content-Type", ContentType.XML)
                .body(XMLBodyToPost)
                .when()
                .post(harryKartApp)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .extract();
        Assertions.assertEquals(response.response().asString(), "{\n" +
                "  \"ranking\" : [ {\n" +
                "    \"position\" : 1,\n" +
                "    \"horse\" : \"TIMETOBELUCKY\"\n" +
                "  }, {\n" +
                "    \"position\" : 2,\n" +
                "    \"horse\" : \"HERCULES BOKO\"\n" +
                "  }, {\n" +
                "    \"position\" : 3,\n" +
                "    \"horse\" : \"CARGO DOOR\"\n" +
                "  } ]\n" +
                "}");
    }

    @Test
    @DisplayName("get ranking for the second example")
    void cantPlayYetSecondExample() throws IOException {
        String FilePath = "./src/test/resources/input_1.xml";
        String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
        var response = given()
                .header("Content-Type", ContentType.XML)
                .body(XMLBodyToPost)
                .when()
                .post(harryKartApp)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .extract();
        Assertions.assertEquals(response.response().asString(), "{\n" +
                "  \"ranking\" : [ {\n" +
                "    \"position\" : 1,\n" +
                "    \"horse\" : \"WAIKIKI SILVIO\"\n" +
                "  }, {\n" +
                "    \"position\" : 2,\n" +
                "    \"horse\" : \"TIMETOBELUCKY\"\n" +
                "  }, {\n" +
                "    \"position\" : 3,\n" +
                "    \"horse\" : \"HERCULES BOKO\"\n" +
                "  } ]\n" +
                "}");
    }

    @Test
    @DisplayName("get ranking for the third example")
    void cantPlayYetThirdExample() throws IOException {
        String FilePath = "./src/test/resources/input_2.xml";
        String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));
        var response = given()
                .header("Content-Type", ContentType.XML)
                .body(XMLBodyToPost)
                .when()
                .post(harryKartApp)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .extract();
        Assertions.assertEquals(response.response().asString(), "{\n" +
                "  \"ranking\" : [ {\n" +
                "    \"position\" : 1,\n" +
                "    \"horse\" : \"HERCULES BOKO\"\n" +
                "  }, {\n" +
                "    \"position\" : 2,\n" +
                "    \"horse\" : \"TIMETOBELUCKY\"\n" +
                "  }, {\n" +
                "    \"position\" : 3,\n" +
                "    \"horse\" : \"WAIKIKI SILVIO\"\n" +
                "  } ]\n" +
                "}");
    }
}
