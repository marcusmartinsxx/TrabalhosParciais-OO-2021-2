import java.util.Scanner;

public class Pessoa {
	// Atributos
	private String nome;
	private String cpf;
	private String telefone;
	private Endereco endereco;// Para armazenar infos especificas do endereco
	private String rg;
	private Scanner ler = new Scanner(System.in);// Para realizar os metodos
	private Usuario usuario;// Para armazenar infos especificas do usuario
	private int n;// Para escolha do menu
	private String temp;// Armazenamento temporario de senha
	// Metodo Construtor de Pessoa
	public Pessoa(String nome, String cpf, String telefone, Endereco endereco, String rg) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rg = rg;
	}
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		endereco.cadastraEndereco();
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		usuario.cadastraUsuario();
	}
	// Metodos
	public void cadastraPessoa() {
		System.out.print("Digite seu nome:");
		setNome(ler.nextLine());
		System.out.print("Digite seu CPF:");
		setCpf(ler.nextLine());
		System.out.print("Digite seu telefone:");
		setTelefone(ler.nextLine());
		setEndereco(endereco);// Chama funcao que edita o endereco
		System.out.println("Digite seu RG:");
		setRg(ler.nextLine());
		setUsuario(usuario);// Chama funcao que edita o usuario
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
	public void visualizaPessoa() {
		System.out.println("Nome: " + getUsuario() + "\nCPF: " + getCpf() + "\nTelefone: " + getTelefone() + "\nEndereco - \nCEP: " + this.endereco.getCEP() + 
							"\nCidade: " + this.endereco.getCidade() + "\nComplemento: " + this.endereco.getComplemento() + "\nEstado: " + this.endereco.getEstado() +
							"\nRua: " + this.endereco.getLogradouro() + "\nNumero: " + this.endereco.getNumero()+ "\nRG: " + getRg() + "\nEmail: " + this.usuario.getEmail()
							+ "\nID: " + this.usuario.getId() + "\nPlano atual: " + this.usuario.getPlano());// Printa todas as infos da Pessoa
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
	public void editaPessoa() {
		System.out.println("O que deseja editar?");
		System.out.println("\n1 - Nome\n2 - Telefone\n3 - Endereco\n4 - Email\n5 - Senha");
		n = ler.nextInt();
		if(n < 1 || n > 5) {// Menu de escolha para o que editar dentro das infos editáveis
			System.out.println("Numero invalido.");
		}else {
			if(n == 1) {
				System.out.print("Digite seu nome:");
				setNome(ler.nextLine());
				System.out.println("Nome alterado com sucesso.");
			}else if(n == 2) {
				System.out.print("Digite seu novo telefone:");
				setTelefone(ler.nextLine());
				System.out.println("Telefone alterado com sucesso.");
			}else if(n == 3) {
				setEndereco(endereco);
				System.out.println("Endereco alterado com sucesso.");
			}else if(n == 4) {
				System.out.println("Digite seu novo e-mail:");
				usuario.setEmail(ler.nextLine());
				System.out.println("E-mail alterado com sucesso.");
			}else if(n == 5) {
				do {// Verifica senha
					System.out.print("Digite a nova senha: ");
					usuario.setSenha(ler.nextLine());
					System.out.print("Confirme a senha: ");
					temp = ler.nextLine();
					if(temp != usuario.getSenha()) {
						System.out.println("Senhas nao coincidem. Tente novamente\n");
					}
				}while(temp != usuario.getSenha());
				System.out.println("Senha alterada com sucesso.");
			}
		}
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
		}
	public void deletaPessoa() {// Reseta tudo do usuario
		setCpf(null);
		setNome(null);
		setEndereco(null);
		setRg(null);
		setTelefone(null);
		setUsuario(null);
		System.out.println("Usuario deletado com sucesso.");
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
}