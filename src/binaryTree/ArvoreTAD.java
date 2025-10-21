package binaryTree;

public class ArvoreTAD {
    private Nodo raiz;

    public ArvoreTAD() {
        this.raiz = null;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    /* TODO implementar
    public int tamanho() {

    }
    */

    /* TODO implementar
    private int tamanhoRec(Nodo n) {
    }
    */

    /* TODO implementar
    public void limpa() {
    }
    */

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

    /* TODO implementar
    public void imprimeEmOrdem() {
    }
    */

    /* TODO implementar
    private void imprimeEmOrdemRec(Nodo n) {
    }
    */

    /* TODO implementar
    public void imprimePosOrdem() {
    }
    */

    /* TODO implementar
    private void imprimePosOrdemRec(Nodo n) {
    }
    */

    /* TODO implementar
    public void imprimePreOrdem() {
    }
    */

    /* TODO implementar
    private void imprimePreOrdemRec(Nodo n) {
    }
    */

    /* TODO implementar
    public int acessaMaior() {
    }
    */

    /* TODO implementar
    private int acessaMaiorRec(Nodo n) {
    }
    */

    /* TODO implementar
    public int acessaMenor() {
    }
    */

    /* TODO implementar
    private int acessaMenorRec(Nodo n) {
    }
    */

    /* TODO implementar
    public ArrayList<Integer> criaVetorEmOrdem(  ) {
    }
    */

    /* TODO implementar
    private void criaVetorEmOrdem(Nodo n, ArrayList<Integer> vetor) {
    }
    */

    /* TODO implementar
    public void balanceamentoEstatico() {
    }
    */

    /* TODO implementar
    private void preencheArvoreBinaria(ArrayList<Integer> vetorEmOrdem, int i, int f) {
    }
    */

    /****************************/
    /* MÉTODOS JÁ IMPLEMENTADOS */
    /****************************/

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