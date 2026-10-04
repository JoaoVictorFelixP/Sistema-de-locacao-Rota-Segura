package Model;
import Model.*;
import UI.GeradorRelatorio;

public abstract class Carro implements GeradorRelatorio {
    private Marca marca;
    private String modelo;
    private int ano;
    private String cor;
    private boolean ocupado;
    private static int qtd=0;

    // RETORNA A QUANTIDADE TOTAL DE CARROS INSTANCIADOS NA CLASSE
    public static int getQuantidade() {
        return Model.Carro.qtd;
    }

    // CONSTRUTOR COM 4 ITENS PARA SER UTILIZADO PELAS SUB-CLASSES
    public Carro(Marca marca, String modelo, int ano, String cor) {
        Model.Carro.qtd += 1;
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAno(ano);
        this.setCor(cor);
        this.ocupado = false; // Carro novo começa desocupado
    }

    // CONSTRUTOR COM 5 ITENS RECEBENDO STRING PARA A MARCA E BOOLEAN DE OCUPAÇÃO
    public Carro(String m, String mo, int a, String c, boolean o) {
        Model.Carro.qtd += 1;
        this.setAno(a);
        this.setCor(c);
        this.setOcupado(o);
        this.setMarca(m);
        this.setModelo(mo);
    }

    // CONSTRUTOR COM 5 ITENS RECEBENDO OBJETO MARCA E BOOLEAN DE OCUPAÇÃO
    public Carro(Marca m, String mo, int a, String c, boolean o) {
        Model.Carro.qtd += 1;
        this.setAno(a);
        this.setCor(c);
        this.setOcupado(o);
        this.setMarca(m);
        this.setModelo(mo);
    }

    // RETORNA O STATUS BOOLEANO DO CARRO (SE ESTÁ OCUPADO OU NÃO)
    public boolean isOcupado() {
        return ocupado;
    }

    // ALTERA O STATUS DE OCUPAÇÃO DO CARRO
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    // RETORNA O NOME DA MARCA DO CARRO
    public String getMarca() {
        return marca.getNome();
    }

    // DEFINE A MARCA PASSANDO UM OBJETO MARCA
    public void setMarca(Marca m) {
        this.marca = m;
    }

    // DEFINE A MARCA CRIANDO UM NOVO OBJETO ATRAVÉS DE UMA STRING
    public void setMarca(String marca) {
        Marca mc = new Marca(marca);
        this.marca = mc;
    }

    // RETORNA O ANO DO CARRO
    public int getAno() {
        return ano;
    }

    // DEFINE E VALIDA O ANO DO CARRO COM EXCEÇÃO PARA ANOS INVÁLIDOS
    public void setAno(int ano) {
        if (ano < 1900 || ano > 2077) {
            throw new IllegalArgumentException("Erro, o carro é muito antigo, só aceitamos carros do ano 1900 para cima");
        }
        this.ano = ano;
    }

    // RETORNA A COR DO CARRO
    public String getCor() {
        return cor;
    }

    // DEFINE A COR DO CARRO
    public void setCor(String cor) {
        this.cor = cor;
    }

    // RETORNA O MODELO DO CARRO
    public String getModelo() {
        return modelo;
    }

    // DEFINE O MODELO DO CARRO
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // TOSTRING PARA EXIBIÇÃO FORMATADA DOS DADOS BÁSICOS DO CARRO
    @Override
    public String toString() {
        String desc = "";
        desc += "Marca: " + this.getMarca() + "\n";
        desc += "Modelo: " + this.getModelo() + "\n";
        desc += "Ano: " + Integer.toString(this.getAno());
        return desc;
    }

    // EQUALS PARA COMPARAR SE DOIS CARROS SÃO IGUAIS PELA MARCA, MODELO E ANO
    @Override
    public boolean equals(Object obj) {
        Model.Carro cmp = Model.Carro.class.cast(obj);
        if (
                this.getMarca().equals(cmp.getMarca()) &&
                        this.getModelo().equals(cmp.getModelo()) &&
                        (this.getAno() == cmp.getAno())
        ) {
            return true;
        } else {
            return false;
        }
    }

    // CÁLCULO PADRÃO DA DIÁRIA (SOBRESCRITO NAS SUBCLASSES)
    public double calcularDiaria() {
        return 100.0;
    }

    // CÁLCULO PADRÃO DO SEGURO (SOBRESCRITO NAS SUBCLASSES)
    public double calcularSeguro() {
        return 150.0;
    }

    // CÁLCULO PADRÃO DA MANUTENÇÃO (SOBRESCRITO NAS SUBCLASSES)
    public double calcularManutencao() {
        return 500.0;
    }

    // GERA O CONTRATO PADRÃO DO VEÍCULO IMPLEMENTANDO A INTERFACE
    @Override
    public void gerarContrato() {
        System.out.println("Gerando contrato padrão para o veículo: " + getModelo());
    }

    // GERA O RELATÓRIO DE FECHAMENTO IMPLEMENTANDO A INTERFACE
    @Override
    public String gerarRelatorioFechamento() {
        return "Relatório do Veículo: " + getModelo() + " | Ano: " + getAno();
    }

}