package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		ArrayList<Pedido> listaDePedidos = new ArrayList<>();
		
		//Menu de opções
		String opcao;
		do {
			System.out.println("✦ MENU ✦");
			System.out.println("Qual operação deseja realizar?");
			System.out.println("1-Registrar pedido");
			System.out.println("2-Remover pedido");
			System.out.println("3-Listar pedidos");
			System.out.println("4-Sair");
			opcao= leitor.nextLine();
			
			switch(opcao) {
			case "1":
				registraPedido(listaDePedidos, leitor);
				break;
			case "2":
				removePedido(listaDePedidos, leitor);
				break;
			case "3":
				listarPedidos(listaDePedidos);
				break;
			case "4":
				System.out.println("Encerrando a execução do programa");
				break;
			default:
				System.out.println("Operação inválida. Digite um número de 1 a 4.");
			}
		}
			while(!opcao.equals("4"));
	}
		
		//Registrando o pedido
		private static void registraPedido(ArrayList<Pedido>lista,Scanner leitor) {
			System.out.println("》 REGISTRAR PEDIDO 《");
			System.out.println("Nome do cliente: ");
			String nomeDoCliente= leitor.nextLine();
			
			Pedido pedido= new Pedido(nomeDoCliente);
			
			String continuar;
			do {
				System.out.println("Qual o nome do item? ");
				String nomeDoItem= leitor.nextLine();
				System.out.println("Qual o preço do item? ");
				double precoDoItem= leitor.nextDouble();
				leitor.nextLine();
				
				pedido.adicionaItem(new Item(nomeDoItem, precoDoItem));
				
				System.out.println("Deseja adicionar um outro item ? (s/n)");
				continuar= leitor.nextLine();
				}while(continuar.equalsIgnoreCase("s"));
			
			lista.add(pedido);
			
			System.out.println("\n=== Resumo do Pedido ===");
			pedido.exibeResumo();
		}
		
		//Remvovendo o pedido
		private static void removePedido(ArrayList<Pedido> lista, Scanner leitor) {
			System.out.println("Qual o número do pedido quer você deseja remover ?");
			int num= leitor.nextInt();
			
			boolean removido=false;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNumeroDoPedido()==num) {
					lista.remove(i);
					System.out.println("O pedido " + num + " foi removido");
					removido=true;
					break;	
				}
			}
			if (!removido) {
				System.out.println("Não foi possível remover. Pedido " + num + " não foi encontrado ☹");
				
			}	
		}
		//Listando todos os pedidos
		private static void listarPedidos(ArrayList<Pedido> lista) {
			if (lista.isEmpty()) {
				System.out.println("Nnenhum pedido foi registrado");
			} else {
				for (Pedido p : lista) {
					p.exibeResumo();
				}
			}
		}
	}