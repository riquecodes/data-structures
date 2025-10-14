package fila.complex;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> filaPrioridades = new PriorityQueue<>();
        ArrayList<Integer> vetorOrdenado = new ArrayList<>();
        ArrayList<Integer> vetorDesord = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.print("N = ");
        int N = scan.nextInt();

        int N_INSERCOES = N;
        int NUM_REMOVES = N / 2;
        int NUM_ACESSOS = N;

        int[] valores = geraValoresParaInsercao(N);

        // EXPERIMENTOS COM VETOR ORDENADO
        Cronometro cronVetOrdInsere = new Cronometro();
        cronVetOrdInsere.inicia();
        insereVetorOrdenado(vetorOrdenado, N_INSERCOES, valores);
        cronVetOrdInsere.finaliza();

        Cronometro cronVetOrdAcessa = new Cronometro();
        cronVetOrdAcessa.inicia();
        acessaVetorOrdenado(vetorOrdenado, NUM_ACESSOS);
        cronVetOrdAcessa.finaliza();

        Cronometro cronVetOrdRemove = new Cronometro();
        cronVetOrdRemove.inicia();
        removeVetorOrdenado(vetorOrdenado, NUM_REMOVES);
        cronVetOrdRemove.finaliza();

        System.out.println("\nSolução-1: Vetor ordenado");
        System.out.println("Inserção: " + cronVetOrdInsere.getTempoEmMilissegundos() + " ms");
        System.out.println("Remoção: " + cronVetOrdRemove.getTempoEmMilissegundos() + " ms");
        System.out.println("Acesso: " +  cronVetOrdAcessa.getTempoEmMilissegundos() + " ms");

        // EXPERIMENTOS COM VETOR DESORDENADO
        Cronometro cronVetDesordInsere = new Cronometro();
        cronVetDesordInsere.inicia();
        insereVetorDesord(vetorDesord, N_INSERCOES, valores);
        cronVetDesordInsere.finaliza();

        Cronometro cronVetDesordAcessa = new Cronometro();
        cronVetDesordAcessa.inicia();
        acessaVetorDesord(vetorDesord, NUM_ACESSOS);
        cronVetDesordAcessa.finaliza();

        Cronometro cronVetDesordRemove = new Cronometro();
        cronVetDesordRemove.inicia();
        removeVetorDesord(vetorDesord, NUM_REMOVES);
        cronVetDesordRemove.finaliza();

        System.out.println("\nSolução-2: Vetor desordenado");
        System.out.println("Inserção: " + cronVetDesordInsere.getTempoEmMilissegundos() + " ms");
        System.out.println("Remoção: " + cronVetDesordRemove.getTempoEmMilissegundos() + " ms");
        System.out.println("Acesso: " +  cronVetDesordAcessa.getTempoEmMilissegundos() + " ms");

        // EXPERIMENTOS COM FILA DE PRIORIDADES
        Cronometro cronFilaInsere = new Cronometro();
        cronFilaInsere.inicia();
        insereFilaPrioridades(filaPrioridades, N_INSERCOES, valores);
        cronFilaInsere.finaliza();

        Cronometro cronFilaAcessa = new Cronometro();
        cronFilaAcessa.inicia();
        acessaFilaPrioridades(filaPrioridades, NUM_ACESSOS);
        cronFilaAcessa.finaliza();

        Cronometro cronFilaRemove = new Cronometro();
        cronFilaRemove.inicia();
        removeFilaPrioridades(filaPrioridades, NUM_REMOVES);
        cronFilaRemove.finaliza();

        System.out.println("\nSolução-3: Fila de Prioridades");
        System.out.println("Inserção: " + cronFilaInsere.getTempoEmMilissegundos() + " ms");
        System.out.println("Remoção: " + cronFilaRemove.getTempoEmMilissegundos() + " ms");
        System.out.println("Acesso: " +  cronFilaAcessa.getTempoEmMilissegundos() + " ms");

    }

    private static int[] geraValoresParaInsercao(int N) {
        int[] vetorValores = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int elem = rand.nextInt(N*2);
            vetorValores[i] = elem;
        }
        return vetorValores;
    }

    /******************************************************************************************
     * SOLUÇÃO 1: VETOR ORDENADO
     *****************************************************************************************/
    public static void insereVetorOrdenado(ArrayList<Integer> vetorOrdenado, int N, int[] valores) {
        for (int rep = 0; rep < N; rep++) {
            int elem = valores[rep];
            int i = 0;

            while (i < vetorOrdenado.size() && vetorOrdenado.get(i) < elem) {
                i++;
            }
            vetorOrdenado.add(i, elem);
        }

    }

    public static void acessaVetorOrdenado(ArrayList<Integer> vetorOrdenado, int N) {
        for (int rep = 0; rep < N; rep++) {
            int elem = vetorOrdenado.get(vetorOrdenado.size() - 1);
        }
    }

    public static void removeVetorOrdenado(ArrayList<Integer> vetorOrdenado, int N) {
        for (int rep = 0; rep < N; rep++) {
            int elem = vetorOrdenado.remove(vetorOrdenado.size() - 1);
        }
    }

    /******************************************************************************************
     * SOLUÇÃO 2: VETOR DESORDENADO
     *****************************************************************************************/
    public static void insereVetorDesord(ArrayList<Integer> vetorDesord, int N, int[] valores) {
        for (int rep = 0; rep < N; rep++) {
            int elem = valores[rep];
            vetorDesord.add(elem);
        }
    }

    public static void acessaVetorDesord(ArrayList<Integer> vetorDesord, int N) {
        for (int rep = 0; rep < N; rep++) {
            int posMaior = 0;
            int maior = 0;
            for (int i = 0; i < vetorDesord.size(); i++) {
                if (vetorDesord.get(i) > maior) {
                    maior = vetorDesord.get(i);
                    posMaior = i;
                }
            }
            vetorDesord.remove(posMaior);
        }
    }

    public static void removeVetorDesord(ArrayList<Integer> vetorDesord, int N) {
        for (int rep = 0; rep < N; rep++) {
            int maior = 0;
            for (int i = 0; i < vetorDesord.size(); i++) {
                if (vetorDesord.get(i) > maior) {
                    maior = vetorDesord.remove(i);
                }
            }
        }
    }

    /******************************************************************************************
     * SOLUÇÃO 3: HEAP (PRIORITY QUEUE)
     *****************************************************************************************/
    public static void insereFilaPrioridades(PriorityQueue<Integer> filaPrioridades, int N, int[] valores) {
        for (int rep = 0; rep < N; rep++) {
            int elem = valores[rep];
            filaPrioridades.add(elem);
        }
    }

    public static void acessaFilaPrioridades(PriorityQueue<Integer> filaPrioridades, int N) {
        for (int rep = 0; rep < N; rep++) {
            int elem = filaPrioridades.peek();
        }
    }

    public static void removeFilaPrioridades(PriorityQueue<Integer> filaPrioridades, int N) {
        for (int rep = 0; rep < N; rep++) {
            int elem = filaPrioridades.poll();
        }
    }
}