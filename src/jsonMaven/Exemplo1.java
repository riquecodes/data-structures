package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo1 {
    public static void main(String[] args) throws UnirestException {
        String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-1.json";

        HttpResponse<JsonNode> response = Unirest.get(url)
                .header("Content-Type", "application/json")
                .asJson();

        int code = response.getStatus();
        JsonNode json = response.getBody();

        JSONObject obj = json.getObject();
        JSONArray array = json.getArray();

        System.out.println("json: " + json);
        System.out.println("status: " + code);
        System.out.println("obj: " + obj);
        System.out.println("array: " + array);
    }
}