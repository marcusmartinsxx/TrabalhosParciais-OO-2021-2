import java.util.Scanner;

	public class Plano {
		// Atributos
		private String tipo;
		private String descricao;
		private Aluguel aluguel;
		private int qtdBicicletas;
		private Scanner ler = new Scanner(System.in);// Para os metodos
		private int n;
		// Metodo Construtor de Plano
		public Plano(String tipo, String descricao, Aluguel aluguel, int qtdBicicletas) {
			this.tipo = tipo;
			this.descricao = descricao;
			this.aluguel = aluguel;
			this.qtdBicicletas = qtdBicicletas;
		}
		// Getters e Setters
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Aluguel getAluguel() {
			return aluguel;
		}
		public void setAluguel(Aluguel aluguel) {
			this.aluguel = aluguel;
		}
		public int getQtdBicicletas() {
			return qtdBicicletas;
		}
		public void setQtdBicicletas(int qtdBicicletas) {
			this.qtdBicicletas = qtdBicicletas;
		}
		// Metodos
		public void cadastraPlano() {
			System.out.println("\nQual sera o nome desse plano?");
			setTipo(ler.nextLine());
			System.out.println("E o que ele oferece? Digite a descricao dele.");
			setDescricao(ler.nextLine());
			System.out.println("E qual sera o valor da hora desse plano?");
			this.aluguel.setValorHora(ler.nextFloat());
			System.out.println("E quantas bicicletas por mes estarao disponiveis?");
			setQtdBicicletas(ler.nextInt());
			System.out.println("Plano cadastrado com sucesso!");
		}
		public void visualizaPlano() {
			System.out.println("\nNome do plano: " + getTipo() + "\nDescricao: " + getDescricao() +
								"\nValor hora: " + this.aluguel.getValorHora() + "\nQuantidade de Bicicletas: " + 
								getQtdBicicletas());

			System.out.println("\nPressione Enter para continuar...");
			ler.nextLine();
		}
		public void editaPlano() {
			System.out.println("\nO que deseja editar?");
			System.out.println("\n1 - Nome\n2 - Descricao\n3 - Valor hora\n4 - Quantidade de Bicicletas");
			n = ler.nextInt();
			if(n < 1 || n > 4) {// Menu de escolha para o que editar dentro das infos editáveis
				System.out.println("\nNumero invalido.");
			}else {
				if(n == 1) {
					System.out.println("\nDigite o novo nome do plano: ");
					setTipo(ler.nextLine());
					System.out.println("\nNome alterado com sucesso.");
				}else if(n == 2) {
					System.out.println("\nDigite a nova descricao: ");
					setDescricao(ler.nextLine());
					System.out.println("\nDescricao alterada com sucesso.");
				}else if(n == 3) {
					System.out.println("\nDigite o novo valor da hora: ");
					this.aluguel.setValorHora(ler.nextFloat());
					System.out.println("\nValor alterado com sucesso.");
				}else if(n == 4) {
					System.out.println("\nDigite a nova quantidade de bicicletas: ");
					setQtdBicicletas(ler.nextInt());
					System.out.println("\nQuantidade alterada com sucesso.");
				}
			}
			System.out.println("\nPressione Enter para continuar...");
			ler.nextLine();
		}
		public void deletaPlano() {
			setAluguel(null);
			setDescricao(null);
			setQtdBicicletas(0);
			setTipo(null);
			System.out.println("\nPlano deletado com sucesso.");
			System.out.println("\nPressione Enter para continuar...");
			ler.nextLine();
		}
}