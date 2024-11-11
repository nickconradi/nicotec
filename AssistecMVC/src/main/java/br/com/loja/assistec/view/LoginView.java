package br.com.loja.assistec.view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtLog;
	private JPasswordField txtSenha;
	private JButton btnEntrar;
	private JLabel lblStatus;
	private JLabel lblLog;
	private JLabel lblSenha;

	public LoginView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ASSISTEC - LOGIN");

		lblLog = new JLabel("Login");
		lblLog.setBounds(102, 63, 53, 14);
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 102, 64, 14);
		txtLog = new JTextField();
		txtLog.setBounds(176, 60, 127, 20);
		txtSenha = new JPasswordField();
		txtSenha.setBounds(176, 98, 128, 22);
		btnEntrar = new JButton("Entrar");
		btnEntrar.setActionCommand("BotaoLoginAction");
		btnEntrar.setBounds(179, 155, 76, 23);

		lblStatus = new JLabel();
		lblStatus.setBounds(10, 213, 63, 37);

		getRootPane().setDefaultButton(btnEntrar);
		getContentPane().setLayout(null);
		getContentPane().add(lblStatus);
		getContentPane().add(btnEntrar);
		getContentPane().add(lblSenha);
		getContentPane().add(lblLog);
		getContentPane().add(txtSenha);
		getContentPane().add(txtLog);
	}

	public void addLoginListener(ActionListener listener) {
		btnEntrar.addActionListener(listener);
	}

	public void mostrarBancoOnline(Boolean online) {
		String iconPath = online ? "/br/com/loja/assistec/icones/dbok.png" : "/br/com/loja/assistec/icones/dberror.png";
		lblStatus.setIcon(new ImageIcon(getClass().getResource(iconPath)));
	}

	public String getLogin() {
		return txtLog.getText();
	}

	public String getSenha() {
		return new String(txtSenha.getPassword());
	}

	public void mostrarMensagem(String mensagem, String tipo) {
		int messageType = switch (tipo) {
		case "Atenção" -> JOptionPane.WARNING_MESSAGE;
		case "Informação" -> JOptionPane.INFORMATION_MESSAGE;
		case "Erro" -> JOptionPane.ERROR_MESSAGE;
		default -> JOptionPane.PLAIN_MESSAGE;
		};
		JOptionPane.showMessageDialog(this, mensagem, tipo, messageType);
	}
}
