import java.util.Scanner;

public class Usuario {
	// Atributos
	private long id;
	private Plano plano;
	private String email;
	private String senha;
	private Scanner ler = new Scanner(System.in);// Para os metodos
	private String temp;// Para verificar a senha
	private int i;// Para criar os IDs
	// Metodo Construtor de Usuario
	public Usuario(long id, Plano plano, String email, String senha) {
		super();
		this.id = id;
		this.plano = plano;
		this.email = email;
		this.senha = senha;
	}
	// Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = i + 1;
		i++;
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
	public void cadastraUsuario() {
		System.out.print("Digite seu e-mail: ");
		setEmail(ler.nextLine());
		do {// Verifica senha
			System.out.print("Digite sua senha: ");
			setSenha(ler.nextLine());
			System.out.print("Confirme a senha: ");
			temp = ler.nextLine();
			if(temp != this.senha) {
				System.out.println("Senhas nao coincidem. Tente novamente\n");
			}
		}while(temp != this.senha);
		setId(id);
		System.out.println("\nUsuario cadastrado com sucesso!");
		System.out.println("Seu ID e: " + this.id);
	}
}
