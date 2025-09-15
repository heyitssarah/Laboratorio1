package restaurante;

import java.util.ArrayList;

public class Pedido {

	private int cont = 1;
	private int numeroDoPedido;
	private String nomeDoCliente;
	private ArrayList<Item> itens;
	
	public Pedido(String cliente) {
		this.numeroDoPedido = cont++;
		this.nomeDoCliente = cliente;
		this.itens = new ArrayList<>(); //Lista de itens do pedido
	}
	
	public void adicionaItem(Item item) {
		itens.add(item);
	}
	
	public double valorTotal() {
		double total = 0;
		for (Item item : itens) {
			total += item.getPreco();
		}
		return total;
	}
	 public void exibeResumo() {
		 System.out.println("\n========================================");
		 System.out.println(" Restaurante Hello, food! ★");
		 System.out.println("Sua refeição perfeita começa aqui");
		 System.out.println("========================================");
		 System.out.println("Pedido N°: " + numeroDoPedido);
		 System.out.println("Cliente: " + nomeDoCliente);
		 System.out.println("----------------------------------------");
		 System.out.println("Itens:");
		 for (Item item : itens) {
			item.exibeItem();
		}
		 System.out.println("----------------------------------------");
		 System.out.println("Total: R$ " + valorTotal());
		 System.out.println("========================================");
		 System.out.println(" Obrigado pela preferência! ☺ ");
		 System.out.println("========================================\n");
	 }
}


