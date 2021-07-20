// PARA UM CLASSE UTILIZAR A ESTRUTURA DE UMA TELA DE SISTEMA 
// É NECESSARIO IMPORTAR OS ELEMENTOS DA CLASSE JFrame
import javax.swing.JFrame;

// PARA IMPORTAR UMA IMAGEM
import javax.swing.ImageIcon;

import java.awt.Color;
// IMPORTAÇÃO DA CLASSE CONTAINER QUE PERMITE 
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// IMPORTAÇÃO DA CLASSE JLabel ESSA CLASSE PERMITE ADICIONAR OS TEXTOS NA TELA DE UM SISTEMA
import javax.swing.JLabel;

// IMPORTANDO A CLASSE JTexteField ESSA CLASSE PERMITE CRIAR AS CAIXAS DE DIGITAÇÃO DE UM SISTEMA.
import javax.swing.JTextField;

// IMPORTO A CLASSE JBUTTON ESTA CLASSE PERMITE ADICIONAR BOTOÕES DE AÇÃO NA TELA DO SISTEMA.
import javax.swing.JButton;

// IRMPORTAÇÃO AS CAIXAS DE INFORMAÇÕES DE AVISO AO USUARIO DO SISTEMA
import javax.swing.JOptionPane;

//IMPORTANDO AS CAIXAS DE SELEÇÃO DO FORMULÁRIO JComboBox
import javax.swing.JComboBox;

public class TelaDenuncia {
	
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
	
	
	
	private JButton jbNovo;
	private JButton jbCadastrar;
	private JButton jbCancelar;
	private JButton jbConsultar;
	private JButton jbAlterar;
	private JButton jbExcluir;
	
	private JComboBox jcbDenuncia;
	
	public TelaDenuncia() {
		
		// INSTANCIAR O OBJETO
		this.tela = new JFrame("CADASTRO DA DENÚNCIA");
		
		// DEFINIR O TAMANHO DA TELA LARGURA X ALTURA
		this.tela.setSize(800, 800);
		
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
		
		// DEFININDO COMO OS ELEMENTOS IRÃO SER POSICIONADOS NA TELA
		this.areaTrabalho.setLayout(null);
		
		// CRIANDO OS TEXTOS E POSICIONANDO CADA TEXTO NA TELA DE SEU SISTEMA
		this.jlID			= new JLabel ("Código");
		this.jlIDUsuario	= new JLabel ("Código do Usuario");
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
		
		
		
		// CRIANDO AS CAIXAS DE DIGITAÇÃO E POSICIONANDO CADA CAIXA NA TELA DE SEU SISTEMA
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
		
		
		// POSICIONANDO AS CAIXAS DE DIGITAÇÃO NA TELA (X,  Y, LARGURA, ALTURA)
		this.areaTrabalho.add(this.jtfID).setBounds(10, 30, 40, 20);
		this.areaTrabalho.add(this.jtfIDUsuario).setBounds(10, 80, 40, 20);
		this.areaTrabalho.add(this.jtfOcorrencia).setBounds(10, 130, 300, 120);
		this.areaTrabalho.add(this.jtfTipo).setBounds(10, 280, 100, 20);
		this.areaTrabalho.add(this.jtfRua).setBounds(10, 330, 160, 20);
		this.areaTrabalho.add(this.jtfBairro).setBounds(10, 380, 160, 20);
		this.areaTrabalho.add(this.jtfCidade).setBounds(10, 430, 160, 20);
		this.areaTrabalho.add(this.jtfdataHora).setBounds(10, 480, 200, 20);
		this.areaTrabalho.add(this.jcbDenuncia).setBounds(400, 30, 200, 20);
		
	//	this.preencherJCBDenuncia();
		
		// CRIANDO OS BOTÕES E POSICIONANDO CADA BOTÃO NA TELA DE SEU SISTEMA
		this.jbNovo			= new JButton("Novo");
		this.jbCadastrar	= new JButton("Cadastrar");
		this.jbCancelar		= new JButton("Cancelar");
		this.jbConsultar	= new JButton("Consultar");
		this.jbAlterar		= new JButton("Alterar");
		this.jbExcluir		= new JButton("Excluir");
		
		// MUDANDO A FONTE DOS TEXTOS NOS BOTÕES
		this.jbNovo.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbCadastrar.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbCancelar.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbConsultar.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbAlterar.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jbExcluir.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		// MUDANDO AS CORES DOS BOTÕES
		this.jbNovo.setBackground(Color.BLACK);
		this.jbCadastrar.setBackground(Color.BLACK);
		this.jbCancelar.setBackground(Color.BLACK);
		this.jbConsultar.setBackground(Color.BLACK);
		this.jbAlterar.setBackground(Color.BLACK);
		this.jbExcluir.setBackground(Color.BLACK);
		
		// MUDANDO A COR DO TEXTO DOS BOTÕES
		this.jbNovo.setForeground(Color.WHITE);
		this.jbCadastrar.setForeground(Color.WHITE);
		this.jbCancelar.setForeground(Color.WHITE);
		this.jbConsultar.setForeground(Color.WHITE);
		this.jbAlterar.setForeground(Color.WHITE);
		this.jbExcluir.setForeground(Color.WHITE);
		
		// POSICIONANDO OS BOTÕES NA TELA (X,  Y, LARGURA, ALTURA)
		this.areaTrabalho.add(this.jbNovo).setBounds(60, 550, 100, 20);
		this.areaTrabalho.add(this.jbCadastrar).setBounds(10, 600, 100, 20);
		this.areaTrabalho.add(this.jbCancelar).setBounds(120, 600, 100, 20);
		this.areaTrabalho.add(this.jbConsultar).setBounds(620, 30, 100, 20);
		this.areaTrabalho.add(this.jbAlterar).setBounds(10, 650, 100, 20);
		this.areaTrabalho.add(this.jbExcluir).setBounds(120, 650, 100, 20);
		
		// ADICIONANDO OS SENSORES NO BOTÃO NOVO
		this.jbNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoNovo();
				
			}
		});
		
		// ADICIONANDO OS SENSORES NO BOTÃO CADASTRAR
		this.jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoCadastrar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÃO CANCELAR
		this.jbCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoCancelar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NO BOTÃO CONSULTAR
		this.jbConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoConsultar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NO BOTÃO ALTERAR
		this.jbAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				botaoAlterar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NO BOTÃO EXCLUIR
		this.jbExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				botaoExcluir();
				
			}
			
		});
		
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO NOVO
	private void botaoNovo() {
		
		this.jtfID.setText("");
		this.jtfIDUsuario.setText("");
		this.jtfOcorrencia.setText("");
		this.jtfTipo.setText("");
		this.jtfRua.setText("");
		this.jtfBairro.setText("");
		this.jtfCidade.setText("");
		this.jtfdataHora.setText("");
	}
	
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CADASTRAR
	private void botaoCadastrar() {
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(this.jtfIDUsuario.getText()));
		
		String ocorrencia	= this.jtfOcorrencia.getText();
		String tipo			= this.jtfTipo.getText();
		String rua			= this.jtfRua.getText();
		String bairro		= this.jtfBairro.getText();
		String cidade		= this.jtfCidade.getText();
		String dataHora 	= this.jtfdataHora.getText();
		
		if(this.jtfIDUsuario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Código do Usuario");
		
		}else if(ocorrencia.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Ocorrência da Denúncia");
			
		}else if (tipo.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Tipo da Denúncia");
			
		}else if (rua.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Tipo de Denúncia");
			
		}else if (bairro.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Bairro de Denúncia");
			
		}else if (cidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Cidade de Denúncia");	
			
		}else if (dataHora.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Data e Hora da Denúncia");
			
		}else {
			Denuncia denuncia = new Denuncia(usuario, ocorrencia, tipo, rua, bairro, cidade, dataHora);
			RepositorioDenuncia rd = new RepositorioDenuncia();
			boolean resposta = rd.cadastroDenuncia(denuncia);
			
			if (resposta == true) {
				JOptionPane.showMessageDialog(null, "Denúncia Cadastrada Com Sucesso.");
			}else {
				JOptionPane.showMessageDialog(null, "Falha no Cadastro da Denúncia.");
			}
			
		}		
		
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CANCELAR
	private void botaoCancelar() {
		
		this.jtfID.setText("");
		this.jtfIDUsuario.setText("");
		this.jtfOcorrencia.setText("");
		this.jtfTipo.setText("");
		this.jtfRua.setText("");
		this.jtfBairro.setText("");
		this.jtfCidade.setText("");
		this.jtfdataHora.setText("");
		
		
		
	}

	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CONSULTAR
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
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO ALTERAR
	private void botaoAlterar() {
		
		// TRANSFORMANDO O STRING DO FORMULÁRIO PARA INT
		int id = Integer.parseInt(jtfID.getText());
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(this.jtfIDUsuario.getText()));
		
		String ocorrencia	= this.jtfOcorrencia.getText();
		String tipo			= this.jtfTipo.getText();
		String rua			= this.jtfRua.getText();
		String bairro		= this.jtfBairro.getText();
		String cidade		= this.jtfCidade.getText();
		String dataHora 	= this.jtfdataHora.getText();
		
		Denuncia denuncia = new Denuncia(id, usuario, ocorrencia, tipo, rua, bairro, cidade, dataHora);
		
		RepositorioDenuncia rd = new RepositorioDenuncia();
		boolean resposta = rd.alterarDenuncia(denuncia);
		
		if(resposta == true) {
			JOptionPane.showMessageDialog(null, "Informações Alteradas com Sucesso.");
		}else {
			JOptionPane.showMessageDialog(null, "Falha na Alteração das Informações");
		}
		
		
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO EXCLUIR
	private void botaoExcluir() {
		
		// TRANSFORMANDO O STRING DO FORMULÁRIO PARA INT
		int id = Integer.parseInt(jtfID.getText());
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(this.jtfIDUsuario.getText()));
		
		String ocorrencia	= this.jtfOcorrencia.getText();
		String tipo			= this.jtfTipo.getText();
		String rua			= this.jtfRua.getText();
		String bairro		= this.jtfBairro.getText();
		String cidade		= this.jtfCidade.getText();
		String dataHora 	= this.jtfdataHora.getText();
		
		Denuncia denuncia = new Denuncia(id, usuario, ocorrencia, tipo, rua, bairro, cidade, dataHora);
		denuncia.setId(id);
		
		RepositorioDenuncia rd = new RepositorioDenuncia();
		boolean resposta = rd.excluirDenuncia(denuncia);
		
		if(resposta == true) {
			JOptionPane.showMessageDialog(null, "Denuncia Excluida com Sucesso");
			
			this.jtfID.setText("");
			this.jtfIDUsuario.setText("");
			this.jtfOcorrencia.setText("");
			this.jtfTipo.setText("");
			this.jtfRua.setText("");
			this.jtfBairro.setText("");
			this.jtfCidade.setText("");
			this.jtfdataHora.setText("");
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Falha na Exclusão da Denuncia");
		}
		
		
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
