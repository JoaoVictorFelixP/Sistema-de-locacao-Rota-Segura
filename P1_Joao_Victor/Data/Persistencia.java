package Data;

import Model.*;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Persistencia {

    // SALVA A LISTA DE CARROS E O SEU ESTADO DE OCUPAÇÃO NO ARQUIVO DE TEXTO
    public static void SalvarCarros(LinkedList<Carro> cars, String nomeArquivo) {
        // FECHA O ARQUIVO AUTOMATICAMENTE APÓS A ESCRITA
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Carro c : cars) {
                // GRAVA OS DADOS SEPARADOS POR PONTO E VÍRGULA, INCLUINDO SE ESTÁ OCUPADO (TRUE/FALSE)
                writer.println(c.getMarca() + ";" + c.getModelo() + ";" + c.getAno() + ";" + c.getCor() + ";" + c.isOcupado());
            }
            System.out.println("Frota salva com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo de carros: " + e.getMessage());
        }
    }

    // CARREGA A LISTA DE CARROS DO ARQUIVO DE TEXTO E RESTAURA O STATUS DE OCUPAÇÃO
    public static LinkedList<Carro> CarregarCarros(String nomeArquivo, LinkedList<Marca> marcas) {
        LinkedList<Carro> cars = new LinkedList<>();
        File arquivo = new File(nomeArquivo);

        // SE O ARQUIVO AINDA NÃO EXISTE, APENAS RETORNA A LISTA VAZIA SEM ERROS
        if (!arquivo.exists()) {
            return cars;
        }

        try (Scanner scannerArquivo = new Scanner(arquivo)) {
            while (scannerArquivo.hasNextLine()) {
                String linha = scannerArquivo.nextLine();

                // DIVIDE A LINHA USANDO O PONTO E VÍRGULA (;) COMO SEPARADOR
                String[] dados = linha.split(";");

                if (dados.length >= 4) {
                    String nomeMarca = dados[0];
                    String modelo = dados[1];
                    int ano = Integer.parseInt(dados[2]);
                    String cor = dados[3];

                    // LÊ O STATUS DE OCUPADO (SE TIVER O 5º CAMPO), CASO CONTRÁRIO PADRÃO É FALSE
                    boolean ocupado = dados.length >= 5 ? Boolean.parseBoolean(dados[4]) : false;

                    // VERIFICA SE A MARCA JÁ EXISTE NA LISTA, SENÃO CRIA UMA NOVA
                    Marca marcaEncontrada = null;
                    for (Marca m : marcas) {
                        if (m.getNome().equalsIgnoreCase(nomeMarca)) {
                            marcaEncontrada = m;
                            break;
                        }
                    }
                    if (marcaEncontrada == null) {
                        marcaEncontrada = new Marca(nomeMarca);
                        marcas.add(marcaEncontrada);
                    }

                    // INSTANCIA O CARRO E DEFINE O ESTADO DE OCUPAÇÃO CARREGADO DO ARQUIVO
                    Carro c = new Popular(marcaEncontrada, modelo, ano, cor);
                    c.setOcupado(ocupado);
                    cars.add(c);
                }
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao encontrar o arquivo: " + e.getMessage());
        }

        return cars;
    }

    // SALVA A LISTA DE CLIENTES NO ARQUIVO DE TEXTO
    public static void SalvarClientes(LinkedList<Cliente> clientes, String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Cliente cli : clientes) {
                // GRAVA O NOME, CPF E E-MAIL DO CLIENTE SEPARADOS POR PONTO E VÍRGULA
                writer.println(cli.getNome() + ";" + cli.getCpf() + ";" + cli.getEmail());
            }
            System.out.println("Clientes salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo de clientes: " + e.getMessage());
        }
    }

    // CARREGA A LISTA DE CLIENTES DO ARQUIVO DE TEXTO
    public static LinkedList<Cliente> CarregarClientes(String nomeArquivo) {
        LinkedList<Cliente> clientes = new LinkedList<>();
        File arquivo = new File(nomeArquivo);

        // SE O ARQUIVO AINDA NÃO EXISTE, RETORNA A LISTA VAZIA SEM ERROS
        if (!arquivo.exists()) {
            return clientes;
        }

        try (Scanner scannerArquivo = new Scanner(arquivo)) {
            while (scannerArquivo.hasNextLine()) {
                String linha = scannerArquivo.nextLine();
                String[] dados = linha.split(";");

                if (dados.length == 3) {
                    String nome = dados[0];
                    String cpf = dados[1];
                    String email = dados[2];

                    // INSTANCIA O CLIENTE E ADICIONA NA LISTA
                    Cliente cliente = new Cliente(nome, cpf, email);
                    clientes.add(cliente);
                }
            }
            System.out.println("Clientes carregados com sucesso!");
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao encontrar o arquivo de clientes: " + e.getMessage());
        }

        return clientes;
    }
}