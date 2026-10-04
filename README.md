# Sistema-de-locacao-Rota-Segura
**Trabalho de Técnicas de Programação I de DSM na Fatec**

# 🚗 Rota Segura - Sistema de Locação de Veículos

Sistema desenvolvido em **Java** como projeto prático de Orientação a Objetos (OOP). O software gerencia frotas de veículos divididas por categorias (Popular, Sedan e SUV), além de controlar clientes, marcas, contratos de locação e a persistência de dados em arquivos de texto.

---

## 👨‍💻 Autoria
* **Nome:** João Victor Felix Perfeito da Costa
* **Matrícula / RA:** 1301392611001
* **Instituição / Curso:** DSM / FATEC

---

## 🏗️ Arquitetura e Conceitos OOP Aplicados
O projeto foi estruturado utilizando pacotes para separar responsabilidades (`Model`, `Data`, `UI`):
* **Herança e Polimorfismo:** A classe abstrata `Carro` serve de base para as subclasses `Popular`, `Sedan` e `SUV`, implementando comportamentos polimórficos como o cálculo de diárias, seguros e manutenções.
* **Encapsulamento:** Atributos privados protegidos por modificadores de acesso, com validações rigorosas (ex: restrição de anos válidos para os veículos).
* **Associação e Agregação:** Relações bem definidas entre `Carro` e `Marca`, bem como a associação de `Cliente` e `Carro` na classe de `Locacao`.
* **Persistência de Dados:** Classe dedicada (`Persistencia`) utilizando `Scanner` e `PrintWriter` com caminhos relativos para garantir o salvamento e carregamento automático de carros e clientes em arquivos de texto (`carros.txt` e `clientes.txt`).

---

## 🚀 Como Executar no IntelliJ IDEA

Siga os passos abaixo para abrir e rodar o projeto no seu ambiente de desenvolvimento:

1. **Abrir o Projeto:**
   * Abra o **IntelliJ IDEA**.
   * Clique em **File > Open** (Arquivo > Abrir).
   * Selecione a pasta raiz do projeto `P1_Joao_Victor` (ou o diretório onde o código está salvo) e clique em *OK*.

2. **Configurar o Projeto (SDK/JDK):**
   * Certifique-se de que o JDK do Java está configurado corretamente no projeto (`File > Project Structure > Project SDK`).

3. **Executar a Aplicação:**
   * No painel esquerdo do projeto, navegue até o pacote `UI` e abra a classe **`Principal.java`**.
   * Clique no ícone de **Play verde (▶)** ao lado da linha da classe `main` ou na linha do método principal, e selecione **Run 'Principal.main()'**.
   * O menu interativo será exibido no console do IntelliJ (`Run Output`).

---

## 📋 Funcionalidades do Sistema
1. **Cadastrar Carro:** Registo de veículos informando categoria (Popular, Sedan, SUV), modelo, marca, ano (com validação contra anos inválidos) e cor.
2. **Listar Carros:** Exibição detalhada da frota, valores calculados e status de ocupação.
3. **Listar Marcas:** Visualização de todas as marcas registadas.
4. **Salvar Dados:** Gravação manual ou automática dos dados em ficheiros de texto locais.
5. **Cadastrar Cliente:** Registo de clientes com nome, CPF e e-mail.
6. **Alugar um Carro:** Fluxo interativo que vincula um cliente disponível a um carro livre, calculando o período e alterando o estado do veículo para ocupado (impedindo alugueres duplicados em simultâneo).

---
*Projeto desenvolvido para fins acadêmicos.*
