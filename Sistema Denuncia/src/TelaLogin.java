// PARA UM CLASSE UTILIZAR A ESTRUTURA DE UMA TELA DE SISTEMA 
// � NECESSARIO IMPORTAR OS ELEMENTOS DA CLASSE JFrame
import javax.swing.JFrame;

// PARA IMPORTAR UMA IMAGEM
import javax.swing.ImageIcon;

import java.awt.Color;
// IMPORTA��O DA CLASSE CONTAINER QUE PERMITE 
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// IMPORTA��O DA CLASSE JLabel ESSA CLASSE PERMITE ADICIONAR OS TEXTOS NA TELA DE UM SISTEMA
import javax.swing.JLabel;

// IMPORTANDO A CLASSE JTexteField ESSA CLASSE PERMITE CRIAR AS CAIXAS DE DIGITA��O DE UM SISTEMA.
import javax.swing.JTextField;

// IMPORTO A CLASSE JBUTTON ESTA CLASSE PERMITE ADICIONAR BOTO�ES DE A��O NA TELA DO SISTEMA.
import javax.swing.JButton;

// IRMPORTA��O AS CAIXAS DE INFORMA��ES DE AVISO AO USUARIO DO SISTEMA
import javax.swing.JOptionPane;

public class TelaLogin {

	// CRIANDO UM OBJETO DA CLASSE JFrame e ImageIcon
	private JFrame tela;
	private ImageIcon logomarca;
	private Container areaTrabalho;
	
	private JLabel jlLogin;
	private JLabel jlSenha;

	private JTextField jtfLogin;
	private JTextField jtfSenha;
	
	private JButton jbEntrar;
	private JButton jbCancelar;
	
	public TelaLogin() {
		// INSTANCIAR O OBJETO
		this.tela = new JFrame("AUTENTICA��O");
		
		// DEFINIR O TAMANHO DA TELA LARGURA X ALTURA
		this.tela.setSize(280, 200);
		
		// DEFININDO A TELA PARA O SEU TAMANHO NORMAL
		this.tela.setExtendedState(JFrame.NORMAL);
		
		// PARA IMPEDIR QUE O USUARIO ALTERE O TAMANHO 
		this.tela.setResizable(false);
		
		// ABRINDO A TELA NO CENTRO DO MONITOR
		this.tela.setLocationRelativeTo(null);
		
		// FECHANDO A TELA E DEIXANDO O SISTEMA EXECUTANDO
		this.tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// ADICIONANDO A LOGOMARCA NO SISTEMA
		this.logomarca = new ImageIcon("src\\logoDenuncia.png");
		this.tela.setIconImage(this.logomarca.getImage());
		
		this.componenteTela();
		
		// TORNANDO A TELA VISIVEL
		this.tela.setVisible(true);
	}
	
	public void componenteTela() {
		
		// CONECTANDO O OBJETO areaTrabalho COM A TELA DO SISTEMA.
		this.areaTrabalho = this.tela.getContentPane();
		
		// MUDANDO A COR DO FUNDO DA TELA
		this.tela.getContentPane().setBackground(Color.DARK_GRAY);
		
		// DEFININDO COMO OS ELEMENTOS IR�O SER POSICIONADOS NA TELA
		this.areaTrabalho.setLayout(null);
		
		// CRIANDO OS TEXTOS E POSICIONANDO CADA TEXTO NA TELA DE SEU SISTEMA
		this.jlLogin		= new JLabel("Email");
		this.jlSenha		= new JLabel("Senha");
		
		// MUDANDO A FONTE DOS TEXTOS
		this.jlLogin.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlSenha.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		// MUDANDO AS CORES DOS TEXTOS
		this.jlLogin.setForeground(Color.WHITE);
		this.jlSenha.setForeground(Color.WHITE);
		
		// POSICIONANDO OS ELEMENTOS NA TELA  (X,  Y, ALTURA, LARGURA)
		this.areaTrabalho.add(this.jlLogin).setBounds(10, 28, 100, 20);
		this.areaTrabalho.add(this.jlSenha).setBounds(10, 58, 100, 20);
		
		// CRIANDO AS CAIXAS DE DIGITA��O E POSICIONANDO CADA CAIXA NA TELA DE SEU SISTEMA
		this.jtfLogin			= new JTextField(200);
		this.jtfSenha			= new JTextField(200);
		
		// POSICIONANDO AS CAIXAS DE DIGITA��O NA TELA (X,  Y, ALTURA, LARGURA)
		this.areaTrabalho.add(this.jtfLogin).setBounds(50, 30, 130, 20);
		this.areaTrabalho.add(this.jtfSenha).setBounds(50, 60, 100, 20);
		
		// CRIANDO OS BOT�ES E POSICIONANDO CADA BOT�O NA TELA DE SEU SISTEMA
		this.jbEntrar		= new JButton("Entrar");
		this.jbCancelar		= new JButton("Cancelar");
		
		// MUDANDO A FONTE DOS TEXTOS NOS BOT�ES
		this.jbEntrar.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbCancelar.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		// MUDANDO AS CORES DOS BOT�ES
		this.jbEntrar.setBackground(Color.BLACK);
		this.jbCancelar.setBackground(Color.BLACK);
		
		// MUDANDO A COR DOS TEXTOS NOS BOT�ES
		this.jbEntrar.setForeground(Color.WHITE);
		this.jbCancelar.setForeground(Color.WHITE);
		
		// POSICIONANDO OS BOT�ES NA TELA (X,  Y, ALTURA, LARGURA)
		this.areaTrabalho.add(this.jbEntrar).setBounds(10, 100, 100, 20);
		this.areaTrabalho.add(this.jbCancelar).setBounds(120, 100, 100, 20);
		
		// ADICIONANDO O SENSOR NO BOT�O ENTRAR
		this.jbEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				botaoEntrar();
				
			}
			
		});
		
		// ADICIONANDO O SENSOR NO BOT�O CANCELAR
		this.jbCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoCancelar();
				
			}
			
		});
		
	}
	
	// DEFININDO AS A��ES QUE OCORRER�O AO CLICAR NO BOT�O ENTRAR
	public void botaoEntrar() {
		
		
		
		String email 			= this.jtfLogin.getText();
		String senha 			= this.jtfSenha.getText();
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		RepositorioUsuario ru = new RepositorioUsuario();
		boolean resposta = ru.loginUsuario(usuario);
		
		if( resposta == false) {
			JOptionPane.showMessageDialog(null, "Usuario N�o Cadastrado");
		}else {
			JOptionPane.showMessageDialog(null, "Usuario Logado Com Sucesso");
			TelaDenuncia td = new TelaDenuncia();
		}
		
		
		if(email.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Login");
			
		}else if (senha.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Senha");
			
		}else {
			
		}
		

	}
	
	// DEFININDO AS A��ES QUE OCORRER�O AO CLICAR NO BOT�O CANCELAR
	public void botaoCancelar() {
		
		this.jtfLogin.setText("");
		this.jtfSenha.setText("");
		
		
	}
	
	
	
}
