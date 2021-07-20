// IMPORTAR A CLASSE CONNECTION ESTA CLASSE PERMITE ESTABELECER UMA CONEXÃO COM UM SERVIDOR
// DE BANCO DE DADOS MySQL Query Browser
import java.sql.Connection;

// IMPORTAR DA CLASSE DriverManager ESTA CLASSE POSSIBILITA CONTROLAR UM BANCO DE DADOS 
// DE DENTRO DO JAVA
import java.sql.DriverManager;

// IMPORTAR DA CLASSE SQLException ESTA CLASSE FAZ O TRATAMENTO DE ERROS QUE PODEM ACONTECER DURANTE
// A EXECUÇÃO DE UM SCRIPT NO BANCO DE DADOS
import java.sql.SQLException;

public class ConexaoMySQL {
	
	public String banco;
	public String username;
	public String password;
	public String driver;
	public Connection queryBrowser;
	
	public ConexaoMySQL() {
		this.username = "root";
		this.password = "123456";
		this.driver = "com.mysql.jdbc.Driver";
		this.banco = "jdbc:mysql://localhost/sistema_denuncia";
		this.queryBrowser = null;
		
	}
	
	// METODO QUE ABRIR O MySQL Query Browser NA MEMORIA DO COMPUTADOR
	public Connection abrirBanco() {
		this.queryBrowser = null;
		
		// ATIVANDO O DRIVER QUE CONTROLA O BANCO
		try {
			Class.forName(this.driver);
			System.out.println("Driver carregado com sucesso");
		} catch (ClassNotFoundException e) {
			System.out.println("Falha ao carregar o driver");
		}
		
		try {
			this.queryBrowser = DriverManager.getConnection(this.banco, this.username, this.password);
			System.out.println("Banco está aberto.");
			
		}catch (SQLException e) {
			System.out.println("Falha ao abrir o banco " + e.getMessage());
			
		}
		
		return this.queryBrowser;
		
	}
	
	// METODO PARA ENCERRAR A CONEXÃO COM O BANCO DE DADOS
	public void fecharBanco() {
		
		try {
			this.queryBrowser.close();
			System.out.println("Conexão encerrada com sucesso.");
			
		} catch (SQLException e) {
			System.out.println("Falha ao encerrar a conexão. " + e.getMessage());
			
		}
		
	}
}
