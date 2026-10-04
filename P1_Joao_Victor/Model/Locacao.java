package Model;

public class Locacao {
    // ATRIBUTOS PRIVADOS QUE ARMAZENAM O CLIENTE E O CARRO DA LOCAÇÃO
    private Cliente cliente;
    private Carro carro;
    private int dias;
    public double valorTotal;

    // CONSTRUTOR DA LOCAÇÃO QUE INICIALIZA OS DADOS E JÁ CALCULA O VALOR TOTAL
    public Locacao(Cliente cliente, Carro carro, int dias) {
        this.cliente = cliente;
        this.carro = carro;
        this.dias = dias;
        this.calcularValorTotal();
    }

    // PRIVADO QUE UTILIZA POLIMORFISMO PARA CALCULAR O CUSTO TOTAL DA LOCAÇÃO
    private void calcularValorTotal() {
        // Calcula a diária, seguro e manutenção específicos da categoria do carro
        double custoDiario = carro.calcularDiaria() + carro.calcularSeguro() + carro.calcularManutencao();
        this.valorTotal = custoDiario * this.dias;
    }

    // RETORNA O VEÍCULO ASSOCIADO À LOCAÇÃO
    public Carro getCarro() {
        return carro;
    }

    // RETORNA O VALOR TOTAL CALCULADO DA LOCAÇÃO
    public double getValorTotal() {
        return valorTotal;
    }

    // TOSTRING PARA EXIBIÇÃO FORMATADA DO CONTRATO DE LOCAÇÃO
    @Override
    public String toString() {
        return "========= CONTRATO DE LOCAÇÃO =========\n" +
                "Cliente: " + cliente.getNome() + "\n" +
                "Veículo: " + carro.getMarca() + " " + carro.getModelo() + "\n" +
                "Dias: " + dias + "\n" +
                "Valor Total: R$ " + valorTotal + "\n" +
                "======================================\n";
    }
}