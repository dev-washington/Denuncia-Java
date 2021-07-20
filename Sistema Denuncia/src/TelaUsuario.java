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
import javax.swing.JComboBox;
// IRMPORTAÇÃO AS CAIXAS DE INFORMAÇÕES DE AVISO AO USUARIO DO SISTEMA
import javax.swing.JOptionPane;

public class TelaUsuario {

	// CRIANDO UM OBJETO DA CLASSE JFrame e ImageIcon
	private JFrame tela;
	private ImageIcon logomarca;
	private Container areaTrabalho;
	
	private JLabel jlID;
	private JLabel jlNome;
	private JLabel jlDataNascimento;
	private JLabel jlCpf;
	private JLabel jlRg;
	private JLabel jlSexo;
	private JLabel jlCep;
	private JLabel jlRua;
	private JLabel jlBairro;
	private JLabel jlCidade;
	private JLabel jlEstado;
	private JLabel jlEstadoCivil;
	private JLabel jlEmail;
	private JLabel jlSenha;
	private JLabel jlStatus;
	private JLabel jlNivel;
	
	private JTextField jtfID;
	private JTextField jtfNome;
	private JTextField jtfDataNascimento;
	private JTextField jtfCpf;
	private JTextField jtfRg;
	private JTextField jtfSexo;
	private JTextField jtfCep;
	private JTextField jtfRua;
	private JTextField jtfBairro;
	private JTextField jtfCidade;
	private JTextField jtfEstado;
	private JTextField jtfEstadoCivil;
	private JTextField jtfEmail;
	private JTextField jtfSenha;
	private JTextField jtfStatus;
	private JTextField jtfNivel;
	
	private JButton jbNovo;
	private JButton jbCadastrar;
	private JButton jbCancelar;
	private JButton jbConsultar;
	private JButton jbAlterar;
	private JButton jbExcluir;
	
	public TelaUsuario() {
		
		// INSTANCIAR O OBJETO
		this.tela = new JFrame("CADASTRO DO USUARIO");
		
		// DEFINIR O TAMANHO DA TELA LARGURA X ALTURA
		this.tela.setSize(600, 750);
		
		// DEFININDO A TELA PARA O SEU TAMANHO NORMAL
		this.tela.setExtendedState(JFrame.NORMAL);
		
		// PARA IMPEDIR QUE O USUARIO ALTERE O TAMANHO 
		this.tela.setResizable(false);
		
		// ABRINDO A TELA NO CENTRO DO MONITOR
		this.tela.setLocationRelativeTo(null);
		
		// CONFIGURANDO O BOTÃO FECHAR FECHANDO O SISTEMA
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
		this.jlID				= new JLabel ("Código");
		this.jlNome 			= new JLabel ("Nome Completo");
		this.jlDataNascimento 	= new JLabel ("Data de Nascimento");
		this.jlCpf				= new JLabel ("CPF");
		this.jlRg				= new JLabel ("RG");
		this.jlSexo 			= new JLabel ("Sexo");
		this.jlCep 				= new JLabel ("CEP");
		this.jlRua 				= new JLabel ("Rua");
		this.jlBairro 			= new JLabel ("Bairro");
		this.jlCidade			= new JLabel ("Cidade");
		this.jlEstado			= new JLabel ("Estado");
		this.jlEstadoCivil 		= new JLabel ("Estado Civil");
		this.jlEmail 			= new JLabel ("Email");
		this.jlSenha 			= new JLabel ("Senha");
		this.jlStatus			= new JLabel ("Status");
		this.jlNivel			= new JLabel ("Nivel");
		
		// MUDANDO A FONTE DOS TEXTOS
		this.jlID.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlNome.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlDataNascimento.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlCpf.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlRg.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlSexo.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlCep.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlRua.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlBairro.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlCidade.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlEstado.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlEstadoCivil.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlEmail.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlSenha.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlStatus.setFont(new Font ("Serif", Font.PLAIN, 15));
		this.jlNivel.setFont(new Font ("Serif", Font.PLAIN, 15));
		
		// MUDANDO AS CORES DOS TEXTOS
		this.jlID.setForeground(Color.WHITE);
		this.jlNome.setForeground(Color.WHITE);
		this.jlDataNascimento.setForeground(Color.WHITE);
		this.jlCpf.setForeground(Color.WHITE);
		this.jlRg.setForeground(Color.WHITE);
		this.jlSexo.setForeground(Color.WHITE);
		this.jlCep.setForeground(Color.WHITE);
		this.jlRua.setForeground(Color.WHITE);
		this.jlBairro.setForeground(Color.WHITE);
		this.jlCidade.setForeground(Color.WHITE);
		this.jlEstado.setForeground(Color.WHITE);
		this.jlEstadoCivil.setForeground(Color.WHITE);
		this.jlEmail.setForeground(Color.WHITE);
		this.jlSenha.setForeground(Color.WHITE);
		this.jlStatus.setForeground(Color.WHITE);
		this.jlNivel.setForeground(Color.WHITE);
		
		
		// POSICIONANDO OS ELEMENTOS NA TELA  (X,  Y, LARGURA, ALTURA) 
		this.areaTrabalho.add(this.jlID).setBounds(10, 10, 100, 20);
		this.areaTrabalho.add(this.jlNome).setBounds(10, 60, 100, 20);
		this.areaTrabalho.add(this.jlDataNascimento).setBounds(10, 110, 130, 20);
		this.areaTrabalho.add(this.jlCpf).setBounds(10, 160, 100, 20);
		this.areaTrabalho.add(this.jlRg).setBounds(10, 210, 100, 20);
		this.areaTrabalho.add(this.jlSexo).setBounds(10, 260, 100, 20);
		this.areaTrabalho.add(this.jlCep).setBounds(10, 310, 100, 20);
		this.areaTrabalho.add(this.jlRua).setBounds(10, 360, 100, 20);
		this.areaTrabalho.add(this.jlBairro).setBounds(260, 10, 100, 20);
		this.areaTrabalho.add(this.jlCidade).setBounds(260, 60, 100, 20);
		this.areaTrabalho.add(this.jlEstado).setBounds(260, 110, 100, 20);
		this.areaTrabalho.add(this.jlEstadoCivil).setBounds(260, 160, 100, 20);
		this.areaTrabalho.add(this.jlEmail).setBounds(260, 210, 100, 20);
		this.areaTrabalho.add(this.jlSenha).setBounds(260, 260, 100, 20);
		this.areaTrabalho.add(this.jlStatus).setBounds(260, 310, 100, 20);
		this.areaTrabalho.add(this.jlNivel).setBounds(260, 360, 100, 20);
		
		
		
		// CRIANDO AS CAIXAS DE DIGITAÇÃO E POSICIONANDO CADA CAIXA NA TELA DE SEU SISTEMA
		this.jtfID					= new JTextField(200);
		this.jtfNome 				= new JTextField(200);
		this.jtfDataNascimento 		= new JTextField(200);
		this.jtfCpf 				= new JTextField(200);
		this.jtfRg 					= new JTextField(200);
		this.jtfSexo 				= new JTextField(200);
		this.jtfCep 				= new JTextField(200);
		this.jtfRua 				= new JTextField(200);
		this.jtfBairro 				= new JTextField(200);
		this.jtfCidade 				= new JTextField(200);
		this.jtfEstado 				= new JTextField(200);
		this.jtfEstadoCivil 		= new JTextField(200);
		this.jtfEmail 				= new JTextField(200);
		this.jtfSenha 				= new JTextField(200);
		this.jtfStatus 				= new JTextField(200);
		this.jtfNivel				= new JTextField(200);
		
		
		// POSICIONANDO AS CAIXAS DE DIGITAÇÃO NA TELA (X,  Y, LARGURA, ALTURA)
		this.areaTrabalho.add(this.jtfID).setBounds(10, 30, 40, 20);
		this.areaTrabalho.add(this.jtfNome).setBounds(10, 80, 160, 20);
		this.areaTrabalho.add(this.jtfDataNascimento).setBounds(10, 130, 120, 20);
		this.areaTrabalho.add(this.jtfCpf).setBounds(10, 180, 100, 20);
		this.areaTrabalho.add(this.jtfRg).setBounds(10, 230, 100, 20);
		this.areaTrabalho.add(this.jtfSexo).setBounds(10, 280, 100, 20);
		this.areaTrabalho.add(this.jtfCep).setBounds(10, 330, 100, 20);
		this.areaTrabalho.add(this.jtfRua).setBounds(10, 380, 160, 20);
		this.areaTrabalho.add(this.jtfBairro).setBounds(260, 30, 160, 20);
		this.areaTrabalho.add(this.jtfCidade).setBounds(260, 80, 160, 20);
		this.areaTrabalho.add(this.jtfEstado).setBounds(260, 130, 100, 20);
		this.areaTrabalho.add(this.jtfEstadoCivil).setBounds(260, 180, 100, 20);
		this.areaTrabalho.add(this.jtfEmail).setBounds(260, 230, 130, 20);
		this.areaTrabalho.add(this.jtfSenha).setBounds(260, 280, 100, 20);
		this.areaTrabalho.add(this.jtfStatus).setBounds(260, 330, 40, 20);
		this.areaTrabalho.add(this.jtfNivel).setBounds(260, 380, 40, 20);
		
		
		// CRIANDO OS BOTÕES E POSICIONANDO CADA BOTÃO NA TELA DE SEU SISTEMA
		this.jbNovo		 	= new JButton("Novo");
		this.jbCadastrar 	= new JButton("Cadastrar");
		this.jbCancelar  	= new JButton("Cancelar");
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
		this.areaTrabalho.add(this.jbNovo).setBounds(60, 450, 100, 20);
		this.areaTrabalho.add(this.jbCadastrar).setBounds(10, 500, 100, 20);
		this.areaTrabalho.add(this.jbCancelar).setBounds(120, 500, 100, 20);
		this.areaTrabalho.add(this.jbConsultar).setBounds(60, 580, 100, 20);
		this.areaTrabalho.add(this.jbAlterar).setBounds(10, 630, 100, 20);
		this.areaTrabalho.add(this.jbExcluir).setBounds(120, 630, 100, 20);
		
	
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
		this.jbNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoNovo();
				
			}
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
		this.jbCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoCadastrar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
		this.jbCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				botaoCancelar();
				
			}
			
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
		this.jbConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoConsultar();
				
			}
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
		this.jbAlterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoAlterar();
				
			}
		});
		
		// ADICIONANDO OS SENSORES NOS BOTÕES DA TELA
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
		this.jtfNome.setText("");
		this.jtfDataNascimento.setText("");
		this.jtfCpf.setText("");
		this.jtfRg.setText("");
		this.jtfSexo.setText("");
		this.jtfCep.setText("");
		this.jtfRua.setText("");
		this.jtfBairro.setText("");
		this.jtfCidade.setText("");
		this.jtfEstado.setText("");
		this.jtfEstadoCivil.setText("");
		this.jtfEmail.setText("");
		this.jtfSenha.setText("");
		this.jtfStatus.setText("");
		this.jtfNivel.setText("");
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CADASTRAR
	private void botaoCadastrar() {
		
		String nome 			= this.jtfNome.getText();
		String dataNascimento 	= this.jtfDataNascimento.getText();
		String cpf 				= this.jtfCpf.getText();
		String rg 				= this.jtfRg.getText();
		String sexo 			= this.jtfSexo.getText();
		String cep 				= this.jtfCep.getText();
		String rua 				= this.jtfRua.getText();
		String bairro 			= this.jtfBairro.getText();
		String cidade 			= this.jtfCidade.getText();
		String estado 			= this.jtfEstado.getText();
		String estadoCivil 		= this.jtfEstadoCivil.getText();
		String email 			= this.jtfEmail.getText();
		String senha 			= this.jtfSenha.getText();
		int status 				= Integer.parseInt(this.jtfStatus.getText());
		int nivel 				= Integer.parseInt(this.jtfNivel.getText());
		
		
		if(nome.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Nome");
			
		}else if (dataNascimento.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Data de Nascimento");
			
		}else if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Cpf");
			
		}else if (rg.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Rg");
		
		}else if (sexo.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Sexo");
			
		}else if (cep.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Cep");
			
		}else if (rua.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Rua");
			
		}else if (bairro.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Bairro");
			
		}else if (cidade.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Cidade");
			
		}else if (estado.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Estado");
			
		}else if (estadoCivil.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Estado Civil");
		
		}else if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Email");	
			
		}else if (senha.equals("")) {
			JOptionPane.showMessageDialog(null, "Informe a Senha");
			
		}else if (this.jtfStatus.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Status");
			
		}else if (this.jtfNivel.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Informe o Nivel");
			
		}else {
			Usuario usuario = new Usuario(nome, dataNascimento, cpf, rg, sexo, cep, rua, bairro, cidade, estado, estadoCivil, email, senha, status, nivel);
			RepositorioUsuario ru = new RepositorioUsuario();
			boolean resposta = ru.cadastroUsuario(usuario);
			
			if (resposta == true) {
				JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso.");
			}else {
				JOptionPane.showMessageDialog(null, "Falha no Cadastro do Usuario.");
			}
			
		}
			
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CANCELAR
	private void botaoCancelar() {
		
		this.jtfID.setText("");
		this.jtfNome.setText("");
		this.jtfDataNascimento.setText("");
		this.jtfCpf.setText("");
		this.jtfRg.setText("");
		this.jtfSexo.setText("");
		this.jtfCep.setText("");
		this.jtfRua.setText("");
		this.jtfBairro.setText("");
		this.jtfCidade.setText("");
		this.jtfEstado.setText("");
		this.jtfEstadoCivil.setText("");
		this.jtfEmail.setText("");
		this.jtfSenha.setText("");
		this.jtfStatus.setText("");
		this.jtfNivel.setText("");
		
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO CONSULTAR
	private void botaoConsultar() {
		
		// TRANSFORMANDO O STRING DO FORMULÁRIO PARA INT
		int id = Integer.parseInt(jtfID.getText());
		
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		
		RepositorioUsuario ru = new RepositorioUsuario();
		boolean resposta = ru.existeId(id);
		
		if(resposta == false) {
			JOptionPane.showMessageDialog(null, "Código Invalido.");
		}else {
			usuario = ru.consultarUsuario(usuario);
			this.jtfID.setText(usuario.getId() + "");
			this.jtfNome.setText(usuario.getNome());
			this.jtfDataNascimento.setText(usuario.getDataNascimento());
			this.jtfCpf.setText(usuario.getCpf());
			this.jtfRg.setText(usuario.getRg());
			this.jtfSexo.setText(usuario.getSexo());
			this.jtfCep.setText(usuario.getCep());
			this.jtfRua.setText(usuario.getRua());
			this.jtfBairro.setText(usuario.getBairro());
			this.jtfCidade.setText(usuario.getCidade());
			this.jtfEstado.setText(usuario.getEstado());
			this.jtfEstadoCivil.setText(usuario.getEstadoCivil());
			this.jtfEmail.setText(usuario.getEmail());
			this.jtfSenha.setText(usuario.getSenha());
			this.jtfStatus.setText(usuario.getStatus()+ "");
			this.jtfNivel.setText(usuario.getNivel()+ "");
			
		}
			
	}
	
	// DEFININDO AS AÇÕES QUE OCORRERÃO AO CLICAR NO BOTÃO ALTERAR
	private void botaoAlterar() {
		
		// TRANSFORMANDO O STRING DO FORMULÁRIO PARA INT
		int id = Integer.parseInt(jtfID.getText());
		
		String nome 			= this.jtfNome.getText();
		String dataNascimento 	= this.jtfDataNascimento.getText();
		String cpf 				= this.jtfCpf.getText();
		String rg 				= this.jtfRg.getText();
		String sexo 			= this.jtfSexo.getText();
		String cep 				= this.jtfCep.getText();
		String rua 				= this.jtfRua.getText();
		String bairro 			= this.jtfBairro.getText();
		String cidade 			= this.jtfCidade.getText();
		String estado 			= this.jtfEstado.getText();
		String estadoCivil 		= this.jtfEstadoCivil.getText();
		String email 			= this.jtfEmail.getText();
		String senha 			= this.jtfSenha.getText();
		int status 				= Integer.parseInt(this.jtfStatus.getText());
		int nivel 				= Integer.parseInt(this.jtfNivel.getText());
		
				
		Usuario usuario = new Usuario(id, nome, dataNascimento, cpf, rg, sexo, cep, rua, bairro, cidade, estado, estadoCivil, email, senha, status, nivel);
				
		RepositorioUsuario ru = new RepositorioUsuario();
		boolean resposta = ru.alterarUsuario(usuario);
				
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
		
		String nome 			= this.jtfNome.getText();
		String dataNascimento 	= this.jtfDataNascimento.getText();
		String cpf 				= this.jtfCpf.getText();
		String rg 				= this.jtfRg.getText();
		String sexo 			= this.jtfSexo.getText();
		String cep 				= this.jtfCep.getText();
		String rua 				= this.jtfRua.getText();
		String bairro 			= this.jtfBairro.getText();
		String cidade 			= this.jtfCidade.getText();
		String estado 			= this.jtfEstado.getText();
		String estadoCivil 		= this.jtfEstadoCivil.getText();
		String email 			= this.jtfEmail.getText();
		String senha 			= this.jtfSenha.getText();
		int status 				= Integer.parseInt(this.jtfStatus.getText());
		int nivel 				= Integer.parseInt(this.jtfNivel.getText());
		
		
		Usuario usuario = new Usuario(id, nome, dataNascimento, cpf, rg, sexo, cep, rua, bairro, cidade, estado, estadoCivil, email, senha, status, nivel);
		usuario.setId(id);
		
		RepositorioUsuario ru = new RepositorioUsuario();
		boolean resposta = ru.excluirUsuario(usuario);
		
		if(resposta == true) {
			JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso");
			
			this.jtfID.setText("");
			this.jtfNome.setText("");
			this.jtfDataNascimento.setText("");
			this.jtfCpf.setText("");
			this.jtfRg.setText("");
			this.jtfSexo.setText("");
			this.jtfCep.setText("");
			this.jtfRua.setText("");
			this.jtfBairro.setText("");
			this.jtfCidade.setText("");
			this.jtfEstado.setText("");
			this.jtfEstadoCivil.setText("");
			this.jtfEmail.setText("");
			this.jtfSenha.setText("");
			this.jtfStatus.setText("");
			this.jtfNivel.setText("");
			
		}else {
			JOptionPane.showMessageDialog(null, "Falha na Exclusão do Usuario");
		}
		
	}

	
}
