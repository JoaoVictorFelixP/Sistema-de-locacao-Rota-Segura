package Model;

public class Sedan extends Carro {

    // CONSTRUTOR QUE CHAMA O SUPER DA CLASSE PAI CARRO PARA INICIALIZAR OS ATRIBUTOS DO SEDAN
    public Sedan (Marca marca, String modelo, int ano, String cor) {
        super(marca, modelo, ano, cor);
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA DIÁRIA PARA CARROS SEDAN
    @Override
    public double calcularDiaria() {
        return 180.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DO SEGURO PARA CARROS SEDAN
    @Override
    public double calcularSeguro() {
        return 250.0;
    }

    // SOBRESCREVE O METODO PARA RETORNAR O VALOR ESPECÍFICO DA MANUTENÇÃO PARA CARROS SEDAN
    @Override
    public double calcularManutencao() {
        return 700.0;
    }
}