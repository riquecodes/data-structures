public class Main {
    public static void main(String[] args) {
        TabelaHashTAD hash = new TabelaHashTAD(5);

        Aluno a1 = new Aluno(12345, "Henrique", "henrique@gmail.com");
        Aluno a2 = new Aluno(23456, "Pix", "pix@gmail.com");
        Aluno a3 = new Aluno(34567, "Mateco", "mateco@gmail.com");
        Aluno a4 = new Aluno(45678, "Mikael", "mikael@gmail.com");
        Aluno a5 = new Aluno(56788, "Samuel", "samuel@gmail.com");

        hash.insere(a1);
        hash.insere(a2);
        hash.insere(a3);
        hash.insere(a4);
        hash.insere(a5);

        System.out.println("Aluno encontrado: " + hash.pesquisa(99999));
        //hash.imprime();

    }
}