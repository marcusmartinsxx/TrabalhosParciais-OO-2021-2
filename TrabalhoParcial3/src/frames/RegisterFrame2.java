package frames;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterFrame2 extends JFrame implements ActionListener {

	Container container = getContentPane(); // Janela de usuario
	JLabel nameLabel = new JLabel("Nome");  // estruturar
	JTextField nameText = new JTextField(); // mudar os nomes
	JLabel cpfLabel = new JLabel("CPF");
	JTextField cpfText = new JTextField();
	JLabel rgLabel = new JLabel("RG");
	JTextField rgText = new JTextField();
	JLabel telefoneLabel = new JLabel("Telefone");
	JTextField telefoneText = new JTextField();
	JLabel enderecoLabel = new JLabel("Endereco");
	JTextField enderecoText = new JTextField();
	
	JButton nextButton = new JButton("Proximo");
	JButton backButton = new JButton("Anterior");
	
	RegisterFrame2() {
		setLayoutManager();
		setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
	}
	
	public void setLayoutManager() {
        container.setLayout(null);
    }
	
	public void setLocationAndSize() {
		
	}
	
	public void addComponentsToContainer() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void addActionEvent() {
		
	}
	
	public static void main(String[] args) {
		RegisterFrame2 registerFrame2 = new RegisterFrame2(); 
		registerFrame2.setTitle("Cadastro"); 
		registerFrame2.setVisible(false); 
		registerFrame2.setSize(800, 350); 
		registerFrame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		registerFrame2.setResizable(false);
	}

}
