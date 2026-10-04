package Model;

public class Cliente {
    // ATRIBUTOS PRIVADOS DE INSTÂNCIA PARA OS DADOS DO CLIENTE
    private String nome;
    private String cpf;
    private String email;

    // CONTADOR ESTÁTICO PARA CONTROLAR O TOTAL DE CLIENTES CRIADOS NA CLASSE
    private static int qtd = 0;

    // RETORNA A QUANTIDADE TOTAL DE CLIENTES INSTANCIADOS
    public static int getQuantidade() {
        return qtd;
    }

    // CONSTRUTOR DA CLASSE QUE INICIALIZA OS DADOS E INCREMENTA O CONTADOR
    public Cliente(String n, String c, String e) {
        qtd += 1;
        this.setNome(n);
        this.setCpf(c);
        this.setEmail(e);
    }

    // RETORNA O NOME DO CLIENTE
    public String getNome() {
        return nome;
    }

    // RETORNA O CPF DO CLIENTE
    public String getCpf() {
        return cpf;
    }

    // RETORNA O E-MAIL DO CLIENTE
    public String getEmail() {
        return email;
    }

    // DEFINE OU ALTERA O NOME DO CLIENTE
    public void setNome(String n) {
        this.nome = n;
    }

    // DEFINE OU ALTERA O CPF DO CLIENTE
    public void setCpf(String c) {
        this.cpf = c;
    }

    // DEFINE OU ALTERA O E-MAIL DO CLIENTE
    public void setEmail(String e) {
        this.email = e;
    }

    // TOSTRING PARA EXIBIÇÃO FORMATADA DOS DADOS DO CLIENTE
    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | E-mail: " + email;
    }
}