package hashMap;

import java.util.HashMap;
import java.util.Scanner;

public class MesesAno {
    public static void main(String[] args) {
        HashMap<String, Integer> tradutorMeses = new HashMap<>();

        tradutorMeses.put("janeiro", 1);
        tradutorMeses.put("fevereiro", 2);
        tradutorMeses.put("março", 3);
        tradutorMeses.put("abril", 4);
        tradutorMeses.put("maio", 5);
        tradutorMeses.put("junho", 6);
        tradutorMeses.put("julho", 7);
        tradutorMeses.put("agosto", 8);
        tradutorMeses.put("setembro", 9);
        tradutorMeses.put("outubro", 10);
        tradutorMeses.put("novembro", 11);
        tradutorMeses.put("dezembro", 12);

        Scanner scan = new Scanner(System.in);

        String chave = scan.next().trim().toLowerCase();

        if (tradutorMeses.containsKey(chave)) {
            int valor = tradutorMeses.get(chave);
            System.out.println(valor);
            return;
        }

        System.out.println("Mês inválido!");

    }
}
