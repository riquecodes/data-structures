package hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class CaracterFrases {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String frase = bf.readLine();

        String[] caracteres = frase.split("");

        HashMap<String, Integer> mapa = new HashMap<>();

        for (String caracter : caracteres) {
            String chave = caracter.equals(" ") ? "espaço" : caracter.toLowerCase();
            mapa.put(chave, mapa.getOrDefault(chave, 0) + 1);
        }
        System.out.println(Arrays.toString(caracteres));
        System.out.println(mapa);
    }
}
