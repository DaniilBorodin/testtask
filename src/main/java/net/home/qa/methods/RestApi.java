package net.home.qa.methods;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import net.home.qa.models.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestApi {


    public static Response GetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    @SneakyThrows
    public static void getRequests(int numberOfObjects) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Person> recivedPersons = new ArrayList<>();
        for (int i = 0; i < numberOfObjects; i++){
            Response response = GetRequest("https://randus.org/api.php");
            String jsonBody = response.getBody().asString();
            List<Person> persons = null;
            try {
                persons = mapper.readValue(jsonBody, mapper.getTypeFactory()
                        .constructCollectionType(List.class, Person.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
            recivedPersons.addAll(persons);
        }
        dropBodyByNameToFile(recivedPersons);
        dropBodyByDateToFile(recivedPersons);
        }

    public static void dropBodyByNameToFile(List<Person> recivedPersons ) throws IOException {

        Collections.sort(recivedPersons, new ComparatorByName());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        FileWriter file = new FileWriter("sortedByName.json");
        String json = ow.writeValueAsString(recivedPersons);
        try {
             file.write(json);
             file.close();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    public static void dropBodyByDateToFile(List<Person> recivedPersons ) throws IOException {

        Collections.sort(recivedPersons, new ComparatorByDate());
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        FileWriter file = new FileWriter("sortedByDate.json");
        String json = ow.writeValueAsString(recivedPersons);
        try {
            file.write(json);
            file.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    }


