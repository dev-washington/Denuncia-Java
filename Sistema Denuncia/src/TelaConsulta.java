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

//IMPORTANDO AS CAIXAS DE SELE��O DO FORMUL�RIO JComboBox
import javax.swing.JComboBox;

public class TelaConsulta {
	
	// CRIANDO UM OBJETO DA CLASSE JFrame e ImageIcon
	private JFrame tela;
	private ImageIcon logomarca;
	private Container areaTrabalho;
	
	private JLabel jlID;
	private JLabel jlIDUsuario;
	private JLabel jlOcorrencia;
	private JLabel jlTipo;
	private JLabel jlRua;
	private JLabel jlBairro;
	private JLabel jlCidade;
	private JLabel jldataHora;
	
	private JTextField jtfID;
	private JTextField jtfIDUsuario;
	private JTextField jtfOcorrencia;
	private JTextField jtfTipo;
	private JTextField jtfRua;
	private JTextField jtfBairro;
	private JTextField jtfCidade;
	private JTextField jtfdataHora;
	
	
	private JButton jbConsultar;
	
	private JComboBox jcbDenuncia;
	
	public TelaConsulta() {
		
		// INSTANCIAR O OBJETO
		this.tela = new JFrame("CONSULTAR DEN�NCIA");
		
		// DEFINIR O TAMANHO DA TELA LARGURA X ALTURA
		this.tela.setSize(730, 570);
		
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
		this.jlID			= new JLabel ("C�digo");
		this.jlIDUsuario	= new JLabel ("C�digo do Usuario");
		this.jlOcorrencia	= new JLabel ("Ocorrencia");
		this.jlTipo			= new JLabel ("Tipo");
		this.jlRua			= new JLabel ("Rua");
		this.jlBairro		= new JLabel ("Bairro");
		this.jlCidade		= new JLabel ("Cidade");
		this.jldataHora 	= new JLabel ("Data e Hora");
		
		// MUDANDO A FONTE DOS TEXTOS
		this.jlID.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlIDUsuario.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlOcorrencia.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlTipo.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlRua.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlBairro.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlCidade.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jldataHora.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		// MUDANDO AS CORES DOS TEXTOS
		this.jlID.setForeground(Color.WHITE);
		this.jlIDUsuario.setForeground(Color.WHITE);
		this.jlOcorrencia.setForeground(Color.WHITE);
		this.jlTipo.setForeground(Color.WHITE);
		this.jlRua.setForeground(Color.WHITE);
		this.jlBairro.setForeground(Color.WHITE);
		this.jlCidade.setForeground(Color.WHITE);
		this.jldataHora.setForeground(Color.WHITE);
		
		// POSICIONANDO OS ELEMENTOS NA TELA  (X,  Y, LARGURA , ALTURA)
		this.areaTrabalho.add(this.jlID).setBounds(10, 10, 100, 20);
		this.areaTrabalho.add(this.jlIDUsuario).setBounds(10, 60, 120, 20);
		this.areaTrabalho.add(this.jlOcorrencia).setBounds(10, 110, 100, 20);
		this.areaTrabalho.add(this.jlTipo).setBounds(10, 260, 100, 20);
		this.areaTrabalho.add(this.jlRua).setBounds(10, 310, 100, 20);
		this.areaTrabalho.add(this.jlBairro).setBounds(10, 360, 100, 20);
		this.areaTrabalho.add(this.jlCidade).setBounds(10, 410, 100, 20);
		this.areaTrabalho.add(this.jldataHora).setBounds(10, 460, 120, 20);
		
		
		
		// CRIANDO AS CAIXAS DE DIGITA��O E POSICIONANDO CADA CAIXA NA TELA DE SEU SISTEMA
		this.jtfID			= new JTextField(200);
		this.jtfIDUsuario	= new JTextField(200);
		this.jtfOcorrencia	= new JTextField(600);
		this.jtfTipo		= new JTextField(200);
		this.jtfRua			= new JTextField(200);
		this.jtfBairro		= new JTextField(200);
		this.jtfCidade		= new JTextField(200);
		this.jtfdataHora	= new JTextField(200);
		this.jcbDenuncia	= new JComboBox();
		
		// MUDANDO A COR DA CAIXA DE TEXTO
		this.jcbDenuncia.setBackground(Color.BLACK);
		
		
		// POSICIONANDO AS CAIXAS DE DIGITA��O NA TELA (X,  Y, LARGURA, ALTURA)
		this.areaTrabalho.add(this.jtfID).setBounds(10, 30, 40, 20);
		this.areaTrabalho.add(this.jtfIDUsuario).setBounds(10, 80, 40, 20);
		this.areaTrabalho.add(this.jtfOcorrencia).setBounds(10, 130, 300, 120);
		this.areaTrabalho.add(this.jtfTipo).setBounds(10, 280, 100, 20);
		this.areaTrabalho.add(this.jtfRua).setBounds(10, 330, 160, 20);
		this.areaTrabalho.add(this.jtfBairro).setBounds(10, 380, 160, 20);
		this.areaTrabalho.add(this.jtfCidade).setBounds(10, 430, 160, 20);
		this.areaTrabalho.add(this.jtfdataHora).setBounds(10, 480, 200, 20);
		this.areaTrabalho.add(this.jcbDenuncia).setBounds(370, 30, 200, 20);
		
	//	this.preencherJCBDenuncia();
		
		// CRIANDO OS BOT�ES E POSICIONANDO CADA BOT�O NA TELA DE SEU SISTEMA
		this.jbConsultar	= new JButton("Consultar");
		
		// MUDANDO A FONTE DOS TEXTOS NOS BOT�ES
		this.jbConsultar.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		
		// MUDANDO AS CORES DOS BOT�ES
		this.jbConsultar.setBackground(Color.BLACK);

		
		// MUDANDO A COR DO TEXTO DOS BOT�ES
		this.jbConsultar.setForeground(Color.WHITE);
		
		// POSICIONANDO OS BOT�ES NA TELA (X,  Y, LARGURA, ALTURA)
		this.areaTrabalho.add(this.jbConsultar).setBounds(580, 30, 100, 20);
		
		

		
		// ADICIONANDO OS SENSORES NO BOT�O CONSULTAR
		this.jbConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoConsultar();
				
			}
			
		});
		
	
		
	}


	// DEFININDO AS A��ES QUE OCORRER�O AO CLICAR NO BOT�O CONSULTAR
	private void botaoConsultar() {
		
		String tipo = this.jcbDenuncia.getSelectedItem() + "";
		
		Denuncia denuncia = new Denuncia();
		denuncia.setTipo(tipo);
		
		RepositorioDenuncia rd = new RepositorioDenuncia();
		denuncia = rd.consultarDenunciaPorTipo(denuncia);
		
		
			this.jtfID.setText(denuncia.getId()+ "");
			this.jtfOcorrencia.setText(denuncia.getOcorrencia());
			this.jtfTipo.setText(denuncia.getTipo());
			this.jtfRua.setText(denuncia.getRua());
			this.jtfBairro.setText(denuncia.getBairro());
			this.jtfCidade.setText(denuncia.getCidade());
			this.jtfdataHora.setText(denuncia.getDataHora());
			
			
		
	}
	
	
	
	// PREENCHENDO A CAIXA DE TEXTO COM DENUNCIAS
/*	private void preencherJCBDenuncia() {
		
		RepositorioDenuncia rd = new RepositorioDenuncia();
		String vetor[] = rd.listarDenuncias();
		
		int contador = 0;
		while(contador < vetor.length) {
			this.jcbDenuncia.addItem(vetor[contador]);
			
			contador++;
		}
		
	}*/
	
	
	

}
