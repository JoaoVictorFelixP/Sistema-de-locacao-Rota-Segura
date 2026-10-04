package Model;

public class Popular extends Carro {

    // CONSTRUTOR QUE CHAMA O SUPER DA CLASSE PAI CARRO PARA INICIALIZAR OS ATRIBUTOS
    public Popular (Marca marca, String modelo, int ano, String cor) {
        super(marca, modelo, ano, cor);
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA DIÁRIA PARA CARROS POPULARES
    @Override
    public double calcularDiaria() {
        return 150.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DO SEGURO PARA CARROS POPULARES
    @Override
    public double calcularSeguro() {
        return 200.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA MANUTENÇÃO PARA CARROS POPULARES
    @Override
    public double calcularManutencao() {
        return 600.0;
    }
}