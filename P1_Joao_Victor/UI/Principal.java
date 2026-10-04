package UI;

import Model.*;
import Data.Persistencia;

import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Listas Linkadas
        LinkedList<Marca> marcas = new LinkedList<>();
        LinkedList<Locacao> locacoes = new LinkedList<>();

        //Listas Linkadas que vão ser salvas nos arquivos
        LinkedList<Carro> cars = Persistencia.CarregarCarros("carros.txt", marcas);
        LinkedList<Cliente> clientes = Persistencia.CarregarClientes("clientes.txt");

        int posAtualCarros = 0;
        int optAtual = -1;

        // Menu do Usuário
        while (optAtual != 0) {
            System.out.println("==== Bem vindo ao Sistema de Rota Segura! ====");
            System.out.println("| Digite a opção desejada:                 |");
            System.out.println("| 1 - Cadastrar Carro                      |");
            System.out.println("| 2 - Listar Carros                        |");
            System.out.println("| 3 - Listar Marcas                        |");
            System.out.println("| 4 - Salvar Dados                         |");
            System.out.println("| 5 - Cadastrar Cliente                    |");
            System.out.println("| 6 - Alugar um Carro                      |");
            System.out.println("| 0 - Sair                                 |");
            System.out.println("============================================");
            try {
                optAtual = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException ne) {
                System.err.println("Erro, opção inválida.");
            }

            // CADASTRAR CARRO
            if (optAtual == 1) {
                try {
                    System.out.println("Escolha a categoria do veículo:");
                    System.out.println("1 - Popular");
                    System.out.println("2 - Sedan");
                    System.out.println("3 - SUV");
                    System.out.print("Digite a opção: ");
                    int tipoCategoria = Integer.parseInt(sc.nextLine());

                    System.out.print("Digite o modelo do carro: ");
                    String modelo = sc.nextLine();

                    System.out.print("Digite o nome da Marca: ");
                    String nomeMarcaBuscada = sc.nextLine();

                    Marca marcaEncontrada = null;
                    for (Marca m : marcas) {
                        if (m.getNome().equalsIgnoreCase(nomeMarcaBuscada)) {
                            marcaEncontrada = m;
                            break;
                        }
                    }
                    if (marcaEncontrada == null) {
                        System.out.println("Marca não encontrada! Criando uma nova marca automaticamente...");
                        marcaEncontrada = new Marca(nomeMarcaBuscada);
                        marcas.add(marcaEncontrada);
                    }

                    System.out.print("Digite o ano do carro: ");
                    int ano = Integer.parseInt(sc.nextLine());

                    System.out.print("Digite a cor do carro: ");
                    String cor = sc.nextLine();

                    Carro novoCarro = null;
                    if (tipoCategoria == 1) {
                        novoCarro = new Popular(marcaEncontrada, modelo, ano, cor);
                    } else if (tipoCategoria == 2) {
                        novoCarro = new Sedan(marcaEncontrada, modelo, ano, cor);
                    } else if (tipoCategoria == 3) {
                        novoCarro = new SUV(marcaEncontrada, modelo, ano, cor);
                    } else {
                        System.out.println("Categoria inválida! Cadastro cancelado.");
                        continue;
                    }

                    cars.add(novoCarro);
                    System.out.println("Carro cadastrado com sucesso!\n");

                } catch (IllegalArgumentException e) {
                    System.err.println("Erro ao cadastrar o veículo: " + e.getMessage());
                    System.out.println("Por favor, tente novamente.\n");
                }

            // LISTAR CARROS
            } else if (optAtual == 2) {
                System.out.println("Carros cadastrados:");
                int pNaLista=0;
                for (Carro c : cars) {
                    System.out.println("Código -> " + Integer.toString(pNaLista));
                    System.out.println(c);
                    System.out.println("===============\n");
                    double diaria = c.calcularDiaria();
                    c.gerarContrato();
                    System.out.println("Valor da Diária: R$ " + c.calcularDiaria());
                    System.out.println("Valor do Seguro: R$ " + c.calcularSeguro());
                    System.out.println("Valor da Manutenção: R$ " + c.calcularManutencao());

                    System.out.println("===============\n");
                    pNaLista += 1;
                }

            // LISTAR MARCAS
            } else if (optAtual == 3) {
                System.out.println("Marcas cadastradas!!!");
                int pNaLista=0;
                for (Marca m : marcas) {
                    System.out.println("Código -> " + Integer.toString(pNaLista));
                    System.out.println(m);
                    System.out.println("===============\n");
                    pNaLista += 1;
                }

            // SALVAR DADOS DOS CARROS E CLIENTES EM ARQUIVOS TXT
            } else if (optAtual == 4) {
                Persistencia.SalvarCarros(cars, "carros.txt");
                Persistencia.SalvarClientes(clientes, "clientes.txt");

            // CADASTRAR CLIENTE
            } else if (optAtual == 5) {
                System.out.println("Cadastro do Cliente\n");
                System.out.println("===================\n");
                System.out.println("Digite o nome do Cliente: ");
                String nome = sc.nextLine();
                System.out.println("Digite o CPF do CLiente: ");
                String cpf = sc.nextLine();
                System.out.print("Digite o e-mail do cliente: ");
                String email = sc.nextLine();
                System.out.println("===================");

                Cliente novoCliente = new Cliente(nome, cpf, email);
                clientes.add(novoCliente);
                System.out.println("Cliente cadastrado com sucesso!!");
                System.out.println("===================\n");

            // REALIZAR LOCAÇÃO
            } else if (optAtual == 6) {
                if (cars.isEmpty() || clientes.isEmpty()) {
                    System.out.println("Erro! É preciso ter pelo menos um carro e um cliente cadastrados.\n");
                    continue;
                }

                System.out.println("=== Realizar Locação ===");

                // MOSTRAR OS CLIENTES DISPONÍVEIS
                System.out.println("Clientes disponíveis:");
                for (int i = 0; i < clientes.size(); i++) {
                    System.out.println(i + " - " + clientes.get(i));
                }
                // SELECIONAR O CLIENTE PELO ID
                System.out.print("Digite o código do cliente: ");
                int indexCliente = Integer.parseInt(sc.nextLine());

                if (indexCliente < 0 || indexCliente >= clientes.size()) {
                    System.out.println("Erro: Código de cliente inválido!\n");
                    continue;
                }
                Cliente clienteEscolhido = clientes.get(indexCliente);

                // ESCOLHER O CARRO E VERIFICAR SE TEM CARRO DISPONÍVEL
                System.out.println("\nCarros disponíveis para locação:");
                boolean temCarroDisponivel = false;
                for (int i = 0; i < cars.size(); i++) {
                    Carro c = cars.get(i);
                    if (!c.isOcupado()) {
                        System.out.println(i + " - " + c.getMarca() + " " + c.getModelo() + " (Ano: " + c.getAno() + ")");
                        temCarroDisponivel = true;
                    }
                }

                if (!temCarroDisponivel) {
                    System.out.println("Não há carros disponíveis no momento!\n");
                    continue;
                }

                System.out.print("Digite o código do carro desejado: ");
                int indexCarro = Integer.parseInt(sc.nextLine());

                if (indexCarro < 0 || indexCarro >= cars.size()) {
                    System.out.println("Erro: Código de carro inválido!\n");
                    continue;
                }

                Carro carroEscolhido = cars.get(indexCarro);

                // VALIDAÇÃO DE SEGURANÇA EXTRA
                if (carroEscolhido.isOcupado()) {
                    System.out.println("Erro: Este carro já está ocupado e não pode ser alugado!\n");
                    continue;
                }

                // INFORMAR OS DIAS
                System.out.print("Digite a quantidade de dias de locação: ");
                int dias = Integer.parseInt(sc.nextLine());

                // EFETIVAR A LOCAÇÃO
                Locacao novaLocacao = new Locacao(clienteEscolhido, carroEscolhido, dias);
                locacoes.add(novaLocacao);

                carroEscolhido.setOcupado(true); // MARCA O CARRO COMO OCUPADO APÓS SELECIONADO

                System.out.println("\nLocação realizada com sucesso!");
                System.out.println(novaLocacao);
            }
        }
    }

}

