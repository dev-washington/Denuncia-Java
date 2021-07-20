// IMPORTA��O DA CLASSE PreparedStatement ESSA CLASSE PERMITE ENVIAR C�DIGO 
// PARA BANCO DE (MySQL Query Browser)
import java.sql.PreparedStatement;

// IMPORTA��O DA CLASSE SQLException PERMITE FAZER O TRATAMENTO DE ERROS QUE PODEM ACONTECER
// QUANDO UM C�DIGO � EXECUTADO NO BANCO DE DADOS.
import java.sql.SQLException;

// IMPORTA��O DA CLASSE ResultSet ESSA CLASSE � RESPONS�VEL EM COPIAR AS INFORMA��ES DO BANCO
// DE DADOS E TRAZER PARA O JAVA. (S�O AS CONSULTAS)
import java.sql.ResultSet;

public class RepositorioDenuncia {
	
	private PreparedStatement comandoSQL;
	private ResultSet resultadoConsulta;
	private ConexaoMySQL conexaoMySQL;
	
	
	public RepositorioDenuncia() {
		// ESTABELECENDO A CONEX�O COM O BANCO DE DADOS
		this.conexaoMySQL = new ConexaoMySQL();
		
		// DEFINIDO QUE NESSE MOMENTO N�O TEM NENHUMA INFORMA��O A SER ENVIADA AO BANCO DE DADOS.
		this.comandoSQL = null;
		
		// DEFININDO QUE NESSE MOMENTO N�O TEM NENHUMA IFORMA��O A SER COPIADA DO BANCO DE DADOS.
		this.resultadoConsulta = null;
	}
	
	// C�DIGO PARA CADASTRAR A DENUNCIA
	public boolean cadastroDenuncia(Denuncia denuncia) {
		boolean retorno = false;
		
		String cadastrar = " INSERT INTO DENUNCIA " + 
				" (IDUSUARIO, OCORRENCIA, TIPO, RUA, BAIRRO, CIDADE, DATA_HORA) " +
				" VALUES " +
				"("+denuncia.getUsuario().getId()+", '"+denuncia.getOcorrencia()+"', '"+denuncia.getTipo()+"', '"+denuncia.getRua()+"', '"+denuncia.getBairro()+"', '"+denuncia.getCidade()+"', '"+denuncia.getDataHora()+"')";

		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(cadastrar);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es." + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha no Cadastro da Den�ncia. " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// C�DIGO PARA CONSULTAR A DENUNCIA
	public Denuncia consultarDenuncia(Denuncia denuncia) {
		Denuncia denunciaRetorno = new Denuncia();
		
		String consulta = " SELECT * FROM DENUNCIA " + 
				" WHERE ID = " +denuncia.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es." + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			
			if(this.resultadoConsulta.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(this.resultadoConsulta.getInt("IDUSUARIO"));
				denunciaRetorno.setUsuario(usuario);
				denunciaRetorno.setId(this.resultadoConsulta.getInt("ID"));
				denunciaRetorno.setOcorrencia(this.resultadoConsulta.getString("OCORRENCIA"));
				denunciaRetorno.setTipo(this.resultadoConsulta.getString("TIPO"));
				denunciaRetorno.setRua(this.resultadoConsulta.getString("RUA"));
				denunciaRetorno.setBairro(this.resultadoConsulta.getString("BAIRRO"));
				denunciaRetorno.setCidade(this.resultadoConsulta.getString("CIDADE"));
				denunciaRetorno.setDataHora(this.resultadoConsulta.getString("DATAHORA"));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Falha na Execu��o da Consulta da Den�ncia." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return denunciaRetorno;
	}
	
	// C�DIGO PARA ALTERAR A DENUNCIA
	public boolean alterarDenuncia(Denuncia denuncia) {
		boolean retorno = false;
		
		String alterar = " UPDATE DENUNCIA SET " +
		" IDUSUARIO      =  "+denuncia.getUsuario().getId() +"  , "+
		" OCORRENCIA     = '"+denuncia.getOcorrencia()     	+"' , "+
		" TIPO 			 = '"+denuncia.getTipo() 		   	+"' , "+		
		" RUA  			 = '"+denuncia.getRua()  		   	+"' , "+
		" BAIRRO         = '"+denuncia.getBairro()         	+"' , "+
		" CIDADE         = '"+denuncia.getCidade()		   	+"' , "+
		" DATA_HORA  	 = '"+denuncia.getDataHora()       	+"'   "+
		" WHERE ID   	 = "+denuncia.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(alterar);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es" + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha na Altera��o da Den�ncia" + e.getMessage());
			
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;		
	}
	
	// C�DIGO PARA EXCLUIR A DENUNCIA
	public boolean excluirDenuncia(Denuncia denuncia) {
		boolean retorno = false;
		
		String excluir = " DELETE FROM DENUNCIA " +
		" WHERE ID  = "+denuncia.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(excluir);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es" + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha ao Excluir a Den�ncia." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// METODOS QUE CONTA QUANTOS TIPOS DE DENUNCIAS EST�O CADASTRADOS NO BANCO DE DADOS
	public int contarTipos() {
		int quantidade = 0;
			
		String consulta = "SELECT COUNT(TIPO) AS QUANTIDADE FROM DENUNCIA";
			
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
				
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es. "+ e.getMessage());
		}
			
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			if(this.resultadoConsulta.next()) {
				quantidade = this.resultadoConsulta.getInt("QUANTIDADE");
			}
				
		} catch (SQLException e) {
			System.out.print("Erro na Contagem" + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return quantidade;
	}
	
	// METODO QUE RETORNA UM VALOR DE DENUNCIAS
	public String[] listarDenuncias() {
		
		int tamanho = this.contarTipos();
		String vetor[] = new String[tamanho]; 
		
		String consulta = "SELECT TIPO FROM DENUNCIA";
		
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es. "+ e.getMessage());
		}
		
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			
			int contador = 0;
			
			while(this.resultadoConsulta.next()) {
				vetor[contador] = this.resultadoConsulta.getString("TIPO");
				
				contador++;
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na Listagem: " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return vetor;

	}
	
	// CONSULTAR A DEN�NCIA PELO TIPO
	public Denuncia consultarDenunciaPorTipo(Denuncia denuncia) {
		Denuncia denunciaRetorno = new Denuncia();
		
		String consulta = " SELECT * FROM DENUNCIA " +
		" WHERE TIPO = '"+denuncia.getTipo()+"'";
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transfer�ncia das Informa��es. " + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			
			if(this.resultadoConsulta.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(this.resultadoConsulta.getInt("IDUSUARIO"));
				denunciaRetorno.setUsuario(usuario);
				denunciaRetorno.setId(this.resultadoConsulta.getInt("ID"));
				denunciaRetorno.setOcorrencia(this.resultadoConsulta.getString("OCORRENCIA"));
				denunciaRetorno.setRua(this.resultadoConsulta.getString("RUA"));
				denunciaRetorno.setBairro(this.resultadoConsulta.getString("BAIRRO"));
				denunciaRetorno.setCidade(this.resultadoConsulta.getString("CIDADE"));
				denunciaRetorno.setTipo(this.resultadoConsulta.getString("TIPO"));
				denunciaRetorno.setDataHora(this.resultadoConsulta.getString("DATAHORA"));
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na Execu��o da Consulta da Den�ncia Por Tipo das Informa��es: " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return denunciaRetorno; 
	}
}
