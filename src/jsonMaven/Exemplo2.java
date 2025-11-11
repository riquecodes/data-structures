package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo2 {
    public static void main(String[] args) throws UnirestException {
        String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-2.json";

        HttpResponse<JsonNode> response = Unirest.get(url)
                .header("Content-Type", "application/json")
                .asJson();

        int code = response.getStatus();
        JsonNode json = response.getBody();

        JSONObject obj = json.getObject();

        //String nome = obj.getJSONArray("employees").getString(0);
        JSONArray employees = obj.getJSONArray("employees");

        for (int i = 0; i < employees.length(); i++) {
            String employee = employees.getString(i);
            System.out.println("employees: " + employee);
        }

        System.out.println("json: " + json);
        System.out.println("status: " + code);
        System.out.println("array: " + employees);
    }
}
