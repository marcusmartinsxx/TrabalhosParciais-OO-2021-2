import java.util.Random;
import java.util.Scanner;

public class Usuario extends Pessoa {
	// Atributos
	private long id;
	private Plano plano;
	private String email;
	private String senha;
	
	private Scanner ler = new Scanner(System.in);// Para os metodos
	private Random gerador = new Random();// Para gerar ID
	private int totalUsuarios = 50;//Valor base para testagem
	
	// Metodo Construtor de Usuario
	public Usuario(long id, Plano plano, String email, String senha, String nome, String cpf, String telefone, Endereco endereco, String rg) {
		super(nome, cpf, telefone, endereco, rg);
		this.id = id;
		this.plano = plano;
		this.email = email;
		this.senha = senha;
	}
	// Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long tempID, Usuario[] usuarios) {
		int i;
		boolean existe = false;
		
		if(tempID != 0) {
			for(i = 0; i < totalUsuarios ; i++) {
				if ( tempID == usuarios[i].id )
				{
					existe = true;
					break;
				}
			}
			if( existe ) {
				System.out.println("	Este ID de usuario ja esta em uso");
			}
			else
			{
				this.id = tempID;			
			}			
		}
		else
		{
			System.out.println("	Este nao eh um ID valido");
		}
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	// Metodos
	public void cadastraUsuario(Usuario[] usuarios) {
		String tempSenha1, tempSenha2, tempEmail;
		int i;
		long tempID;
		boolean  existe;
		
		do {
			existe = false;
			tempID = gerador.nextLong();
			for(i = 0; i < totalUsuarios ; i++) {
				if ( tempID == usuarios[i].id )
				{
					existe = true;
					break;
				}
			}			
		}while( existe || tempID == 0 );
		
		do {
			System.out.print("Digite seu e-mail: ");
			tempEmail = ler.nextLine();		
			if(tempEmail.length() == 0) {
				System.out.println("	O e-mail inserido eh nulo.\n");
			}
			else
			{
				if( !tempEmail.contains("@") ) {
					System.out.println("	Este e-mail nao possui um dominio.\n");
				}
			}
		} while( tempEmail.length() == 0 || !tempEmail.contains("@") );
		
		do {// Verifica senha
			System.out.print("Digite sua senha: ");
			tempSenha1 = ler.nextLine();
			System.out.print("Confirme a senha: ");
			tempSenha2 = ler.nextLine();
			if(tempSenha1 != tempSenha2) {
				System.out.println("Senhas nao coincidem. Tente novamente\n");
			}
			else
			{
				if( tempSenha1.length() == 0 )
				{
					System.out.println("Senhas nulas. Tente novamente\n");
				}				
			}
		}while( (tempSenha1 != tempSenha2) || (tempSenha1.length() == 0) );

		System.out.println("\nUsuario cadastrado com sucesso!");
		System.out.println("Seu ID e: " + tempID); 
		
		setId(tempID, usuarios);
		setSenha(tempSenha1);
		setEmail(tempEmail);
	}
	public void editarUsuario() {
		char opcao;
		String tempEmail, tempPlano, tempSenha;
		
		System.out.println("\nO que deseja editar?");
		System.out.println("\n1 - E-mail\n2 - Plano\n3 - Senha");
		opcao = ler.next().charAt(0);
		if( (int)opcao < 49 || (int)opcao > 51 ) {// Menu de escolha para o que editar dentro das infos editáveis
			System.out.println("\nNumero invalido.");
		}else {
			switch(opcao) {
				case '1':
					do {
						System.out.print("Digite o novo e-mail: ");
						tempEmail = ler.nextLine();		
						if(tempEmail.length() == 0) {
							System.out.println("	O e-mail inserido eh nulo.\n");
						}
						else
						{
							if( !tempEmail.contains("@") ) {
								System.out.println("	Este e-mail nao possui um dominio.\n");
							}
						}
					} while( tempEmail.length() == 0 || !tempEmail.contains("@") );
					this.setEmail(tempEmail);
					System.out.println("E-mail alterado com sucesso.");
					break;
				case '2':
					System.out.print("Digite o novo plano: ");
					tempPlano = ler.nextLine(); // Alterar setPlano		
					System.out.println("Plano alterado com sucesso.");
					break;
				case '3':
					do {// Verifica senha
						System.out.print("Digite a nova senha: ");
						this.setSenha(ler.nextLine());
						System.out.print("Confirme a senha: ");
						tempSenha = ler.nextLine();
						if(tempSenha != this.getSenha()) {
							System.out.println("Senhas nao coincidem. Tente novamente\n");
						}
					}while(tempSenha != this.getSenha());
					setSenha(tempSenha);
					System.out.println("Senha alterada com sucesso.");
					break;
			}
		}
		System.out.println("\nPressione Enter para continuar...");
		ler.nextLine();
	}
}
