package hashTable;

public class Aluno {
    private int matricula;
    private String nome;
    private String email;

    public Aluno(int matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Aluno {" +
                "matricula = " + matricula +
                ", nome = '" + nome + '\'' +
                ", email = '" + email + '\'' +
                '}';
    }
}
