package Model;

public class Marca {

    private String nome;

    public Marca(String n) {
        this.setNome(n);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}

