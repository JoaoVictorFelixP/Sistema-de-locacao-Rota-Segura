package Model;

public class SUV extends Carro {

    // CONSTRUTOR QUE CHAMA O SUPER DA CLASSE PAI CARRO PARA INICIALIZAR OS ATRIBUTOS DO SUV
    public SUV (Marca marca, String modelo, int ano, String cor) {
        super(marca, modelo, ano, cor);
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA DIÁRIA PARA CARROS SUV
    @Override
    public double calcularDiaria() {
        return 120.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DO SEGURO PARA CARROS SUV
    @Override
    public double calcularSeguro() {
        return 160.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA MANUTENÇÃO PARA CARROS SUV
    @Override
    public double calcularManutencao() {
        return 400.0;
    }
}