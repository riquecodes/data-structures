package hashTable;
import java.util.LinkedList;

public class TabelaHashTAD {
    private int M, N;
    private LinkedList<Aluno>[] tabela;

    public TabelaHashTAD(int m) {
        this.M = m;
        this.N = 0;

        tabela = new LinkedList[M];

        for (int i = 0; i < M; i++) {
            tabela[i] = new LinkedList<>();
        }
    }
//Calcular chave int
    private int hash (int chave) {
        return chave%M;
    }

//Calcular chave String
//    private int hash (String chave) {
//        return Math.abs(chave.hashCode()%M);
//    }

    public void insere (Aluno valor) {
        int pos = hash(valor.getMatricula()); //getEmail);
        tabela[pos].add(valor);
    }

    public void imprime() {
        for (int i = 0; i < M; i++) {
            System.out.println(i + " : " + tabela[i]);
        }
    }

    public Aluno pesquisa(int chave) {
        int pos = hash(chave);
        LinkedList<Aluno> lista = tabela[pos];

        for (Aluno aluno : lista) {
            if (chave == aluno.getMatricula()) { //aluno.getEmail().equals(chave);
                return aluno;
            }
        }
        return null;
    }
}
