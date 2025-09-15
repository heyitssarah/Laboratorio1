package restaurante;

public class Item {
	
		private String nomeDoItem;
		private double precoDoItem;
				
		public Item(String nome, double preco) {
			this.nomeDoItem = nome;
			this.precoDoItem = preco;
		}

		public String getNome() {
			return nomeDoItem;
		}


		public double getPreco() {
			return precoDoItem;
		}

		public void exibeItem() {
			System.out.println(nomeDoItem + " - R$ " + precoDoItem);
		}
}
