package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo3 {
    public static void main(String[] args) throws UnirestException {
        String url = "https://fmsampaio.github.io/helper-sites/json-examples/exemplo-3.json";

        HttpResponse<JsonNode> response = Unirest.get(url)
                .header("Content-Type", "application/json")
                .asJson();

        int code = response.getStatus();
        JsonNode json = response.getBody();

        JSONObject obj = json.getObject();

        JSONArray infos = obj.getJSONArray("employees");
        JSONArray infosEmployees = obj.getJSONArray("employees");

        System.out.println("json: " + json);
        System.out.println("status: " + code);
        System.out.println("array: " + infosEmployees);

        for (int i = 0; i < infosEmployees.length(); i++) {
            JSONObject infosEmployee = infosEmployees.getJSONObject(i);
            System.out.println("json infos: " + infosEmployee);
        }

        System.out.println(infos);
    }
}
