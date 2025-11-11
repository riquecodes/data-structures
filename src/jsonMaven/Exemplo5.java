package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Exemplo5 {
    public static void main(String[] args) {
        String url = "https://ed-json-post-23762f735f6e.herokuapp.com/data";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", "Henrique Brum Riva");
        jsonObject.put("nasc", "11/05/2006");
        jsonObject.put("email", "henrique.riva@aluno.farroupilha.ifrs.edu.br");
        jsonObject.put("reside_farroupilha", true);
        jsonObject.put("altura", 1.79);

        JSONObject curso = new JSONObject();

        JSONArray disciplinas = new JSONArray();
        disciplinas.put("Engenharia de Software II");
        disciplinas.put("Redes de Computadores");
        disciplinas.put("Qualidade e Teste de Software");
        disciplinas.put("Probabilidade e Estatística");
        disciplinas.put("Estrutura de Dados");

        curso.put("disciplinas", disciplinas);
        curso.put("ano_ingresso", 2024);
        curso.put("inst", "IFRS Campus Farroupilha");
        curso.put("nome", "Análise e Desenvolvimento de Sistemas");

        jsonObject.put("curso", curso);

        System.out.println(jsonObject);

        try {
            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .body(jsonObject)
                    .asJson();

            System.out.println(response.getStatus());
        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
