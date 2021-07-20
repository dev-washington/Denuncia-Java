// IMPORTAÇÃO DA CLASSE PreparedStatement ESSA CLASSE PERMITE ENVIAR CÓDIGO 
// PARA BANCO DE (MySQL Query Browser)
import java.sql.PreparedStatement;

// IMPORTAÇÃO DA CLASSE SQLException PERMITE FAZER O TRATAMENTO DE ERROS QUE PODEM ACONTECER
// QUANDO UM CÓDIGO É EXECUTADO NO BANCO DE DADOS.
import java.sql.SQLException;

// IMPORTAÇÃO DA CLASSE ResultSet ESSA CLASSE É RESPONSÁVEL EM COPIAR AS INFORMAÇÕES DO BANCO
// DE DADOS E TRAZER PARA O JAVA. (SÃO AS CONSULTAS)
import java.sql.ResultSet;

public class RepositorioDenuncia {
	
	private PreparedStatement comandoSQL;
	private ResultSet resultadoConsulta;
	private ConexaoMySQL conexaoMySQL;
	
	
	public RepositorioDenuncia() {
		// ESTABELECENDO A CONEXÃO COM O BANCO DE DADOS
		this.conexaoMySQL = new ConexaoMySQL();
		
		// DEFINIDO QUE NESSE MOMENTO NÃO TEM NENHUMA INFORMAÇÃO A SER ENVIADA AO BANCO DE DADOS.
		this.comandoSQL = null;
		
		// DEFININDO QUE NESSE MOMENTO NÃO TEM NENHUMA IFORMAÇÃO A SER COPIADA DO BANCO DE DADOS.
		this.resultadoConsulta = null;
	}
	
	// CÓDIGO PARA CADASTRAR A DENUNCIA
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
			System.out.println("Falha na Transferência das Informações." + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha no Cadastro da Denúncia. " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// CÓDIGO PARA CONSULTAR A DENUNCIA
	public Denuncia consultarDenuncia(Denuncia denuncia) {
		Denuncia denunciaRetorno = new Denuncia();
		
		String consulta = " SELECT * FROM DENUNCIA " + 
				" WHERE ID = " +denuncia.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações." + e.getMessage());
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
			System.out.println("Falha na Execução da Consulta da Denúncia." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return denunciaRetorno;
	}
	
	// CÓDIGO PARA ALTERAR A DENUNCIA
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
			System.out.println("Falha na Transferência das Informações" + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha na Alteração da Denúncia" + e.getMessage());
			
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;		
	}
	
	// CÓDIGO PARA EXCLUIR A DENUNCIA
	public boolean excluirDenuncia(Denuncia denuncia) {
		boolean retorno = false;
		
		String excluir = " DELETE FROM DENUNCIA " +
		" WHERE ID  = "+denuncia.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(excluir);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações" + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.comandoSQL.execute();
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Falha ao Excluir a Denúncia." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// METODOS QUE CONTA QUANTOS TIPOS DE DENUNCIAS ESTÃO CADASTRADOS NO BANCO DE DADOS
	public int contarTipos() {
		int quantidade = 0;
			
		String consulta = "SELECT COUNT(TIPO) AS QUANTIDADE FROM DENUNCIA";
			
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
				
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações. "+ e.getMessage());
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
			System.out.println("Falha na Transferência das Informações. "+ e.getMessage());
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
	
	// CONSULTAR A DENÚNCIA PELO TIPO
	public Denuncia consultarDenunciaPorTipo(Denuncia denuncia) {
		Denuncia denunciaRetorno = new Denuncia();
		
		String consulta = " SELECT * FROM DENUNCIA " +
		" WHERE TIPO = '"+denuncia.getTipo()+"'";
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações. " + e.getMessage());
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
			System.out.println("Falha na Execução da Consulta da Denúncia Por Tipo das Informações: " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return denunciaRetorno; 
	}
}
