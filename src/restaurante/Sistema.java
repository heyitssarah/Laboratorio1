package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		ArrayList<Pedido> listaPedidos = new ArrayList<>();
		
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
		
		listaPedidos.add(pedido);
		
		System.out.println("\n=== Resumo do Pedido ===");
		pedido.exibeResumo();
		

	}
}
