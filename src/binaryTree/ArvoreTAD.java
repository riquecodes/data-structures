package binaryTree;

import java.util.ArrayList;

public class ArvoreTAD {
    private Nodo raiz;

    public ArvoreTAD() {
        this.raiz = null;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int tamanho() {
        if (estaVazia()) {
            return 0;
        }
        return tamanhoRec(raiz);
    }
    
    private int tamanhoRec(Nodo n) {
        if (n == null) {
            return 0;
        }
        return 1 + tamanhoRec(n.esq) + tamanhoRec(n.dir);
    }

    public void limpa() {
        this.raiz = null;
    }
    
    public void insere(int elem) {
        if (estaVazia()) {
            this.raiz = new Nodo(elem);
        }

        insereRec(elem, raiz);
    }

    private void insereRec(int elem, Nodo n) {
        //verifica se é a base
        if (elem == n.elem) {
            return;
        }

        //inserir à esquerda
        if (elem < n.elem) {
            if (n.esq == null) {
                n.esq = new Nodo(elem);
                return;
            }

            insereRec(elem, n.esq);
            return;
        }

        //inserir à esquerda
        if (n.dir == null) {
            n.dir = new Nodo(elem);
            return;
        }

        insereRec(elem, n.dir);
    }

    public boolean pesquisa(int elem) {
        return pesquisaRec(elem, this.raiz);
    }

    private boolean pesquisaRec(int elem, Nodo n) {
        //ve se n é nulo
        if (n == null) {
            return false;
        }

        //ve se é o que eu quero
        if (n.elem == elem) {
            return true;
        }

        //vai para a esquerda
        if (elem < n.elem) {
            return pesquisaRec(elem, n.esq);
        }

        //vai para a direita
        return pesquisaRec(elem, n.dir);
    }

    public void imprimeEmOrdem() {
        this.imprimeEmOrdemRec(this.raiz);
    }

    private void imprimeEmOrdemRec(Nodo n) {
        if (n == null) {
            return;
        }

        this.imprimeEmOrdemRec(n.esq);
        System.out.println(n.elem);
        this.imprimeEmOrdemRec(n.dir);
    }

    public void imprimePosOrdem() {
        this.imprimePosOrdemRec(this.raiz);
    }

    private void imprimePosOrdemRec(Nodo n) {
        if (n == null) {
            return;
        }

        this.imprimePosOrdemRec(n.esq);
        this.imprimePosOrdemRec(n.dir);
        System.out.println(n.elem);
    }

    public void imprimePreOrdem() {
        this.imprimePreOrdemRec(this.raiz);        
    }

    private void imprimePreOrdemRec(Nodo n) {
        if (n == null) {
            return;
        }

        System.out.println(n.elem);
        this.imprimePreOrdemRec(n.esq);
        this.imprimePreOrdemRec(n.dir);
    }

    public int acessaMaior() {
        return acessaMaiorRec(this.raiz);
    }

    private int acessaMaiorRec(Nodo n) {
        if (n.dir == null) {
            return n.elem;
        }

        return acessaMaiorRec(n.dir);
    }

    public int acessaMenor() {
        return acessaMenorRec(this.raiz);
    }

    private int acessaMenorRec(Nodo n) {
        if (n.esq == null) {
            return n.elem;
        }

        return acessaMenorRec(n.esq);
    }

    public ArrayList<Integer> criaVetorEmOrdem() {
        ArrayList<Integer> vetor = new ArrayList<>();
        this.criaVetorEmOrdem(this.raiz, vetor);
        return vetor;
    }

    private void criaVetorEmOrdem(Nodo n, ArrayList<Integer> vetor) {
        if (n == null) {
            return;
        }

        this.criaVetorEmOrdem(n.esq, vetor);
        vetor.add(n.elem);
        this.criaVetorEmOrdem(n.dir, vetor);
    }

    public void balanceamentoEstatico() {
        this.preencheArvoreBinaria(this.criaVetorEmOrdem(), 0, this.tamanho() - 1);
    }

    private void preencheArvoreBinaria(ArrayList<Integer> vetorEmOrdem, int i, int f) {
        if (i > f) {
            return;
        }

        int meio = (i + f) / 2;
        this.insere(vetorEmOrdem.get(meio));
        preencheArvoreBinaria(vetorEmOrdem, i, meio - 1);
        preencheArvoreBinaria(vetorEmOrdem, meio + 1, f);
    }

    public void imprimeArvore() {
        this.imprimeArvoreRec(this.raiz, 0);
    }

    private void imprimeArvoreRec(Nodo n, int depth) {
        if (n == null) {
            return;
        }
        this.imprimeArvoreRec(n.dir, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(n.elem);
        this.imprimeArvoreRec(n.esq, depth + 1);
    }

    public void remove(int elem) {
        this.raiz = this.removeRec(elem, this.raiz);
    }

    private Nodo removeRec(int elem, Nodo n) {
        if (n == null) {
            return null;
        } else if (elem == n.elem) {
            if (n.esq == null && n.dir == null) {
                return null;
            } else if (n.esq == null) {
                return n.dir;
            } else if (n.dir == null) {
                return n.esq;
            } else {
                Nodo aux = n.dir;
                while (aux.esq != null) {
                    aux = aux.esq;
                }
                n.elem = aux.elem;
                n.dir = this.removeRec(aux.elem, n.dir);
            }
        } else if (elem < n.elem) {
            n.esq = removeRec(elem, n.esq);
        } else {
            n.dir = removeRec(elem, n.dir);
        }
        return n;
    }
}