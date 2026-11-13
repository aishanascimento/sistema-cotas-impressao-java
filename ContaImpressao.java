package impressao;

import java.util.Scanner;

public class ContaImpressao {
	
	private String nome;
	private int matricula;
	private double saldo = 0;
	public static double preco = 0.50;
	public static int totalPaginasEscola = 0;
	
	public ContaImpressao(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public void adicionar_creditos(double valor) {
		if (valor > 0) {
			saldo = saldo + valor;
		} else {
			System.out.println("O credito nao foi adicionado!");
		}
	}
	
	public int imprimir(int paginas) {
		if (paginas <= 0) {
			return -2;
		}
		
		double custo = paginas * preco;
		
		if (saldo < custo) {
			return -1;
		}
		
		saldo = saldo - custo;
		totalPaginasEscola = totalPaginasEscola + paginas;
		
		return paginas;
	}
	
	public int imprimir(int paginas, int copias) {
		if (paginas <= 0 || copias <= 0) {
			return -2;
		}
		
		int total_paginas = paginas * copias;
		double custo = total_paginas * preco;
		
		if (saldo < custo) {
			return -1;
		}
		
		saldo = saldo - custo;
		totalPaginasEscola = totalPaginasEscola + total_paginas;
		
		return total_paginas;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public static int getTotalPaginasEscola() {
		return totalPaginasEscola;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ContaImpressao ana = new ContaImpressao("Ana Silva", 12345);
		ContaImpressao bruno = new ContaImpressao("Bruno Lopes", 54321);
		
		int opcao = -1;
		
		while (opcao != 0) {
			System.out.println("-.-.-. SISTEMA DE IMPRESSAO .-.-.-");
			System.out.println("1 - Adicionar Creditos");
			System.out.println("2 - Solicitar Impressao");
			System.out.println("3 - Consultar uma Conta");
			System.out.println("4 - Alterar o Preco por Pagina");
			System.out.println("5 - Consultar o Preco por Pagina");
			System.out.println("6 - Consultar o Total de Paginas Impressas");
			System.out.println("0 - Sair");
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
			System.out.print("Escolha uma opcao: ");
			
			opcao = entrada.nextInt();
			
			switch (opcao) {
				case 1: {
					System.out.println("Quem vai adicionar creditos? (1- Ana | 2- Bruno)");
					int pessoaEscolhida = entrada.nextInt();
					System.out.print("Digite o valor dos creditos: ");
					double valor = entrada.nextDouble();
					
					if (pessoaEscolhida == 1) {
						ana.adicionar_creditos(valor);
						System.out.println("Credito adicionado! Saldo atual da Ana: R$ " + ana.getSaldo());
					} else if (pessoaEscolhida == 2) {
						bruno.adicionar_creditos(valor);
						System.out.println("Credito adicionado! Saldo atual do Bruno: R$ " + bruno.getSaldo());
					} else {
						System.out.println("Opcao de pessoa invalida!");
					}
					break;
				}
				
				case 2: {
					System.out.println("Quem deseja solicitar a impressao? (1- Ana | 2- Bruno)");
					int pessoaEscolhida = entrada.nextInt();
					
					System.out.print("Digite a quantidade de paginas: ");
					int paginas = entrada.nextInt();
					
					System.out.print("Digite a quantidade de copias (digite 1 se for apenas uma): ");
					int copias = entrada.nextInt();
					
					int resultado = 0;
					
					if (pessoaEscolhida == 1) {
						if (copias == 1) {
							resultado = ana.imprimir(paginas);
						} else {
							resultado = ana.imprimir(paginas, copias);
						}
					} else if (pessoaEscolhida == 2) {
						if (copias == 1) {
							resultado = bruno.imprimir(paginas);
						} else {
							resultado = bruno.imprimir(paginas, copias);
						}
					} else {
						System.out.println("Opcao de pessoa invalida!");
						break;
					}
					
					if (resultado == -2) {
						System.out.println("Erro: Quantidade de paginas ou copias invalida!");
					} else if (resultado == -1) {
						System.out.println("Erro: Saldo insuficiente na conta!");
					} else {
						System.out.println("Sucesso! Total de paginas impressas nesta operacao: " + resultado);
					}
					break;
				}
				
				case 3: {
					System.out.println("Qual conta deseja consultar? (1- Ana | 2- Bruno)");
					int pessoaEscolhida = entrada.nextInt();
					
					if (pessoaEscolhida == 1) {
						System.out.println("--- Dados da Conta ---");
						System.out.println("Nome: " + ana.getNome());
						System.out.println("Matricula: " + ana.getMatricula());
						System.out.println("Saldo: R$ " + ana.getSaldo());
					} else if (pessoaEscolhida == 2) {
						System.out.println("--- Dados da Conta ---");
						System.out.println("Nome: " + bruno.getNome());
						System.out.println("Matricula: " + bruno.getMatricula());
						System.out.println("Saldo: R$ " + bruno.getSaldo());
					} else {
						System.out.println("Opcao invalida!");
					}
					break;
				}
				
				case 4: {
					System.out.print("Digite o novo preco por pagina: R$ ");
					double novoPreco = entrada.nextDouble();
					if (novoPreco > 0) {
						ContaImpressao.preco = novoPreco;
						System.out.println("Preco atualizado com sucesso!");
					} else {
						System.out.println("Preco invalido!");
					}
					break;
				}
				
				case 5:
					System.out.println("O preco atual por pagina e: R$ " + ContaImpressao.preco);
					break;
					
				case 6:
					System.out.println("Total geral de paginas impressas na escola: " + ContaImpressao.getTotalPaginasEscola());
					break;
					
				case 0:
					System.out.println("Encerrando o sistema. Ate logo!");
					break;
					
				default:
					System.out.println("Opcao invalida! Escolha um numero de 0 a 6.");
			}
		}
		
		entrada.close();
	}
}