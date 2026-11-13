# 🖨️ Sistema de Cotas de Impressão (Java - POO)

## 📌 Visão Geral
Aplicação desenvolvida em Java para controle de créditos e histórico de impressões escolares. O projeto aplica pilares fundamentais da **Programação Orientada a Objetos (POO)**, como encapsulamento de dados imutáveis (nome e matrícula), atributos estáticos compartilhados (preço da página e total geral da escola) e **sobrecarga de métodos** para gerenciar cópias múltiplas.

## 🚀 Funcionalidades e Regras de Negócio

- **Encapsulamento e Imutabilidade:** Atributos de identificação (`nome` e `matricula`) definidos no construtor e acessíveis apenas por leitura (`getters`), sem possibilidade de alteração posterior.
- **Sobrecarga de Métodos (`imprimir`):** 
  - Versão com 1 parâmetro para cópia única.
  - Versão com 2 parâmetros (`paginas` e `copias`) para cálculo multiplicativo de lotes.
- **Tratamento de Erros por Códigos:** Retorno de `-2` para quantidades inválidas e `-1` para saldo insuficiente.
- **Atributos Estáticos (`static`):** Preço unitário global passível de alteração imediata para todas as contas e contador acumulativo de páginas impressas por toda a escola.
- **Menu Interativo via Terminal:** Navegação contínua por laço de repetição (`while`) e múltipla escolha (`switch`).

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java
- **Conceitos Aplicados:** POO, Encapsulamento, Sobrecarga de Métodos, Atributos Estáticos (`static`), Estruturas de Condição e Repetição.
