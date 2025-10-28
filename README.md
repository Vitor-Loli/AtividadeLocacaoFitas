# 🎬 Locadora RetroFlix — Do VHS ao Streaming

## 🧠 Sobre o Projeto
O **RetroFlix** é um sistema de gerenciamento de locadora desenvolvido em **Java**, que integra o modelo clássico de locação de mídias físicas (VHS e DVDs) com o aluguel digital via **streaming**.  
O objetivo é aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** como **abstração**, **herança**, **polimorfismo**, **encapsulamento** e **associação de classes**.

O sistema é totalmente interativo via **menu em modo texto**, permitindo ao usuário realizar operações como cadastro, locação e devolução de filmes.

---

## 🎯 Objetivo Geral
Desenvolver um sistema em Java capaz de:
- Cadastrar diferentes tipos de mídias (VHS, DVD e Streaming);
- Realizar locações e devoluções;
- Controlar o histórico de transações;
- Calcular automaticamente o preço dos aluguéis, aplicando regras específicas por tipo de mídia;
- Exibir o total arrecadado pela locadora.

---

## 🧩 Estrutura do Sistema

### 🪞 Classe Abstrata — `Midia`
Define o comportamento genérico de uma mídia que pode ser alugada.

**Atributos:**
- `titulo` — título do filme  
- `precoBase` — valor base da locação  
- `disponivel` — status de disponibilidade  

**Métodos:**
- Getters e Setters  
- `toString()`  
- `calcularPreco()` *(abstrato, sobrescrito nas subclasses)*

---

### 📼 Classe — `FitaVHS`
Especializa `Midia`, representando fitas de videocassete.

**Atributo adicional:**
- `rebobinada` — indica se a fita foi devolvida rebobinada.

**Regra especial:**  
Se o cliente devolver a fita **sem rebobinar**, é aplicada uma **taxa extra** no valor do aluguel.

---

### 💿 Classe — `DVD`
Herda de `Midia` e adiciona um comportamento próprio.

**Atributo adicional:**
- `possuiExtras` — indica se o DVD contém material bônus (bastidores, entrevistas etc.).

**Regra especial:**  
Se o DVD possuir extras, é aplicado um **acréscimo** no valor do aluguel.

---

### ☁️ Classe — `Streaming`
Representa mídias digitais alugadas por plataformas online.

**Atributo adicional:**
- `plataforma` — nome da plataforma (ex: Netflix, Prime Video).

**Regra especial:**  
Por ser digital, o custo é menor — aplica-se um **desconto** no valor final do aluguel.

---

### 👤 Classe — `Cliente`
Modela as informações do cliente da locadora.

**Atributos:**
- `nome`  
- `email`  
- `id` (identificador único)

**Associação:**  
Um cliente pode possuir **uma ou mais locações**.

---

### 🧾 Classe — `Locacao`
Representa a transação de aluguel entre cliente e mídia.

**Atributos:**
- `cliente` — objeto da classe `Cliente`  
- `midia` — objeto da classe `Midia`  
- `dias` — quantidade de dias de locação  
- `valorTotal` — calculado usando o método polimórfico `calcularPreco()`  
- `status` — ativa ou finalizada

---

### 🧮 Classe — `GerenciadorLocadora`
Responsável por armazenar e gerenciar as listas de mídias e locações.

**Principais métodos:**
- `cadastrarMidia()` — adiciona uma nova mídia  
- `listarMidias()` — exibe o acervo completo  
- `realizarLocacao()` — associa cliente e mídia  
- `devolverMidia()` — finaliza a locação  
- `listarLocacoes()` — mostra todas as locações realizadas  
- `calcularTotalArrecadado()` — soma o valor de todas as locações concluídas  

---

### 🎛️ Classe — `Main`
Controladora do sistema, contém o menu textual.

**Funções do menu:**
1. Cadastrar novas mídias  
2. Listar mídias cadastradas  
3. Realizar locação  
4. Devolver mídia  
5. Listar histórico de locações  
6. Exibir total arrecadado  
7. Encerrar o sistema  

---

## 🧠 Conceitos de POO Aplicados

| Conceito | Aplicação |
|-----------|------------|
| **Abstração** | Classe `Midia` define o comportamento genérico das mídias. |
| **Herança** | `FitaVHS`, `DVD` e `Streaming` herdam de `Midia`. |
| **Polimorfismo** | O método `calcularPreco()` é sobrescrito em cada tipo de mídia. |
| **Encapsulamento** | Todos os atributos são `private`, acessados via getters/setters. |
| **Associação** | A classe `Locacao` associa `Cliente` e `Midia`. |
| **Composição** | `GerenciadorLocadora` mantém listas de `Midia` e `Locacao`. |
| **Sobrescrita de métodos** | `calcularPreco()` e `toString()` são redefinidos nas subclasses. |
