package binaryTree;

public class Main {
    public static void main(String[] args) {
        ArvoreTAD a = new ArvoreTAD();

        System.out.println(a.estaVazia());
        a.insere(50);
        a.insere(20);
        a.insere(70);
        a.insere(10);
        a.insere(100);
        a.insere(80);
        a.insere(25);

        a.balanceamentoEstatico();

        a.imprimeArvore();

        a.imprimeEmOrdem();
        a.imprimePosOrdem();

        System.out.println("tamanho: " + a.tamanho());

        System.out.println(a.pesquisa(100));
        System.out.println(a.pesquisa(900));
    }
}
