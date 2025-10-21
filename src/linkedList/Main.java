package linkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        TADList list = new TADList();

        System.out.println(list.isEmpty());

        System.out.println("Insere Inicio:");
        list.insertFirst(20);
        list.insertFirst(40);
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.println("Insere Final:");
        list.insertFinal(60);
        list.insertFinal(80);
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.println("Insere tal, posição tal:");
        list.insert(3,29);
        list.insert(1, 78);
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.println("Aqui é a de frente para trás:");
        list.printFirt2Last();

        System.out.println();

        System.out.println("Aqui é a de trás para frente:");
        list.printLast2First();

        System.out.println();

        System.out.print("Posição tal, item tal: ");
        System.out.println(list.access(2));

        System.out.println();

        System.out.print("Tem o valor tal? ");
        System.out.println(list.search(29));

        System.out.println();

        System.out.print("Tamanho: ");
        System.out.println(list.length());

        System.out.println();

        System.out.println("Deletar tal, posição tal:");
        list.delete(1);
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.println("Deletar Primeiro:");
        list.deleteFirst();
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.println("Deletar Ultimo:");
        list.deleteLast();
        System.out.println("Resultado: " + list.listToString());

        System.out.println();

        System.out.print("Lista Final: ");
        System.out.println(list.listToString());

        System.out.println();

        System.out.println("Limpar Lista:");
        list.clear();
        System.out.println("Lista Vazia: " + list.listToString());

    }
}
