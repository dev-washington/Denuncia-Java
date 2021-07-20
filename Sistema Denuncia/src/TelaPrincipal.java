// PARA UM CLASSE UTILIZAR A ESTRUTURA DE UMA TELA DE SISTEMA 
// É NECESSARIO IMPORTAR OS ELEMENTOS DA CLASSE JFrame
import javax.swing.JFrame;

import javax.swing.JLabel;

// PARA IMPORTAR UMA IMAGEM
import javax.swing.ImageIcon;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;


public class TelaPrincipal {

	// CRIANDO UM OBJETO DA CLASSE JFrame e ImageIcon
	private JFrame tela;
	private ImageIcon logomarca;
	
	private ImageIcon imagem = new ImageIcon(getClass().getResource("fundo.png"));
	private JLabel label= new JLabel(imagem);
	
	private JMenuBar barraMenu;
	
	private JMenu menuCadastro;
	private JMenu menuLogin;
	private JMenu menuConsulta;
	
	private JMenuItem cadastroUsuario;
	private JMenuItem loginUsuario;
	private JMenuItem consultaDenuncia;
	
	
	public TelaPrincipal() {
				
		// INSTANCIAR O OBJETO
		this.tela = new JFrame("SISTEMA DENÚNCIA");
		
		// DEFINIR O TAMANHO DA TELA LARGURA X ALTURA
		this.tela.setSize(380, 500);
		
		// DEFININDO A TELA PARA O SEU TAMANHO NORMAL
		this.tela.setExtendedState(JFrame.NORMAL);
		
		// PARA IMPEDIR QUE O USUARIO ALTERE O TAMANHO 
		this.tela.setResizable(false);
		
		// ABRINDO A TELA NO CENTRO DO MONITOR
		this.tela.setLocationRelativeTo(null);
		
		// CONFIGURANDO O BOTÃO FECHAR FECHANDO O SISTEMA
		this.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ADICIONANDO A LOGOMARCA NO SISTEMA
		this.logomarca = new ImageIcon("src\\logoDenuncia.png");
		this.tela.setIconImage(this.logomarca.getImage());
		
		this.componenteTela();
		
		// TORNANDO A TELA VISIVEL
		this.tela.setVisible(true);
	}
	
	public void componenteTela() {
	
		// ADICIONANDO UMA IMAGEN AO FUNDO
		this.tela.add(label);
		
		// MUDANDO A COR DO FUNDO DA TELA
		this.tela.getContentPane().setBackground(Color.DARK_GRAY);
		
		// CRIANDO BARRA DE MENU 
		this.barraMenu = new JMenuBar();
							
		// POSICIONANDO	BARRA DE MENU
		this.tela.setJMenuBar(this.barraMenu);
		
		this.barraMenu.setBackground(Color.LIGHT_GRAY);
		
		// CONFIGURANDO AS INFORMAÇÕES DE BARRA DE MENU
		this.menuCadastro = new JMenu("CADASTRO");
		this.menuLogin = new JMenu("LOGIN");
		this.menuConsulta = new JMenu("CONSULTA");

		// MUDANDO A FONTE DOS MENUS
		this.menuCadastro.setFont(new Font ("Dialog", Font.PLAIN, 13));
		this.menuLogin.setFont(new Font ("Dialog", Font.PLAIN, 13));
		this.menuConsulta.setFont(new Font ("Dialog", Font.PLAIN, 13));
		
		// POSICIONANDO OS INTENS DO MENU NA BARRA DE MENU.
		this.barraMenu.add(this.menuCadastro);
		this.barraMenu.add(this.menuLogin);
		this.barraMenu.add(this.menuConsulta);
		
		// CONFIGURANDO E ADICIONANDO OS ITENS INTERNOS DE CADA MENU
		this.cadastroUsuario = new JMenuItem("Cadastrar-Se");
		this.loginUsuario = new JMenuItem("Fazer Login");
		this.consultaDenuncia = new JMenuItem("Consultar Denúncia");


		// MUDANDO A FONTE DOS SUBMENUS
		this.cadastroUsuario.setFont(new Font ("Dialog", Font.PLAIN, 12));
		this.loginUsuario.setFont(new Font ("Dialog", Font.PLAIN, 12));
		this.consultaDenuncia.setFont(new Font ("Dialog", Font.PLAIN, 12));


				   	 	
		// ADICIONANDO OS ITENS DENTRO DO MENU
		this.menuCadastro.add(this.cadastroUsuario);
		this.menuLogin.add(this.loginUsuario);
		this.menuConsulta.add(this.consultaDenuncia);


		
		// SENSORES DOS ITENS DO MENU CADASTRO	
		this.cadastroUsuario.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaUsuario tu = new TelaUsuario();
				
				
			}
			
		});	
				   	
				   		
		// SENSORES DOS ITENS DO MENU LOGIN				
		this.loginUsuario.addActionListener(new ActionListener() {
							
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLogin tl = new TelaLogin();
								
			}
			
		});
		
		// SENSORES DOS ITENS DO MENU CONSULTA		
		this.consultaDenuncia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaConsulta tc = new TelaConsulta();
				
			}
		});	
		
		
		
	}
	
	
	
}
