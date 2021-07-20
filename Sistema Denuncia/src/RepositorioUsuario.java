// IMPORTAÇÃO DA CLASSE PreparedStatement ESSA CLASSE PERMITE ENVIAR CÓDIGO 
// PARA BANCO DE (MySQL Query Browser)
import java.sql.PreparedStatement;

// IMPORTAÇÃO DA CLASSE SQLException PERMITE FAZER O TRATAMENTO DE ERROS QUE PODEM ACONTECER
// QUANDO UM CÓDIGO É EXECUTADO NO BANCO DE DADOS.
import java.sql.SQLException;

// IMPORTAÇÃO DA CLASSE ResultSet ESSA CLASSE É RESPONSÁVEL EM COPIAR AS INFORMAÇÕES DO BANCO
// DE DADOS E TRAZER PARA O JAVA. (SÃO AS CONSULTAS)
import java.sql.ResultSet;

public class RepositorioUsuario {

	private PreparedStatement comandoSQL;
	private ResultSet resultadoConsulta;
	private ConexaoMySQL conexaoMySQL;
	
	public RepositorioUsuario() {
		// ESTABELECENDO A CONEXÃO COM O BANCO DE DADOS
		this.conexaoMySQL = new ConexaoMySQL();
		
		// DEFINIDO QUE NESSE MOMENTO NÃO TEM NENHUMA INFORMAÇÃO A SER ENVIADA AO BANCO DE DADOS.
		this.comandoSQL = null;
		
		// DEFININDO QUE NESSE MOMENTO NÃO TEM NENHUMA IFORMAÇÃO A SER COPIADA DO BANCO DE DADOS.
		this.resultadoConsulta = null;
	}
	
	// CÓDIGO PARA CADASTRAR O USUARIO
	public boolean cadastroUsuario (Usuario usuario) {
		boolean retorno = false;
		
		String cadastrar = " INSERT INTO USUARIO " +
				" (NOME , DATA_NASCIMENTO, CPF, RG, SEXO, CEP, RUA, BAIRRO, CIDADE, ESTADO, ESTADO_CIVIL, EMAIL, SENHA, STATUS, NIVEL) " +
				" VALUES " +
				"('"+usuario.getNome()+"', '"+usuario.getDataNascimento()+"', '"+usuario.getCpf()+"', '"+usuario.getRg()+"', '"+usuario.getSexo()+"', '"+usuario.getCep()+"', '"+usuario.getRua()+"', '"+usuario.getBairro()+"', '"+usuario.getCidade()+"', '"+usuario.getEstado()+"', '"+usuario.getEstadoCivil()+"','"+usuario.getEmail()+"','"+usuario.getSenha()+"', "+usuario.getStatus()+", "+usuario.getNivel()+")";
		
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
			System.out.println("Falha no Cadastro do Usuario. " + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// CÓDIGO PARA CONSULTAR O USUARIO
	public Usuario consultarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = new Usuario();
		
		String consulta = " SELECT * FROM USUARIO " +
		"WHERE ID = "+usuario.getId();
		
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(consulta);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações" + e.getMessage());
		}
		
		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			
			if(this.resultadoConsulta.next()) {
				usuarioRetorno.setId(this.resultadoConsulta.getInt("ID"));
				usuarioRetorno.setNome(this.resultadoConsulta.getString("NOME"));
				usuarioRetorno.setDataNascimento(this.resultadoConsulta.getString("DATA_NASCIMENTO"));
				usuarioRetorno.setCpf(this.resultadoConsulta.getString("CPF"));
				usuarioRetorno.setRg(this.resultadoConsulta.getString("RG"));
				usuarioRetorno.setSexo(this.resultadoConsulta.getString("SEXO"));
				usuarioRetorno.setCep(this.resultadoConsulta.getString("CEP"));
				usuarioRetorno.setRua(this.resultadoConsulta.getString("RUA"));
				usuarioRetorno.setBairro(this.resultadoConsulta.getString("BAIRRO"));
				usuarioRetorno.setCidade(this.resultadoConsulta.getString("CIDADE"));
				usuarioRetorno.setEstado(this.resultadoConsulta.getString("ESTADO"));
				usuarioRetorno.setEstadoCivil(this.resultadoConsulta.getString("ESTADO_CIVIL"));
				usuarioRetorno.setEmail(this.resultadoConsulta.getString("EMAIL"));
				usuarioRetorno.setSenha(this.resultadoConsulta.getString("SENHA"));
				usuarioRetorno.setStatus(this.resultadoConsulta.getInt("STATUS"));
				usuarioRetorno.setNivel(this.resultadoConsulta.getInt("NIVEL"));
				
			}
			
		} catch (SQLException e) {
			System.out.println("Falha na Execução da Consulta do Usuario" + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return usuarioRetorno;
	}
	
	// CÓDIGO PARA ALTERAR O USUARIO
	public boolean alterarUsuario(Usuario usuario) {
		boolean retorno = false;
		
		String alterar = " UPDATE USUARIO SET " +
		" NOME     			= '"+usuario.getNome()     			+"' , "+
		" DATA_NASCIMENTO 	= '"+usuario.getDataNascimento() 	+"' , "+
		" CPF               = '"+usuario.getCpf()            	+"' , "+
		" RG 				= '"+usuario.getRg() 				+"' , "+
		" SEXO  	 		= '"+usuario.getSexo()       		+"' , "+
		" CEP  			 	= '"+usuario.getCep()  		  		+"' , "+
		" RUA  	 			= '"+usuario.getRua()       		+"' , "+
		" BAIRRO  	 		= '"+usuario.getBairro()       		+"' , "+
		" CIDADE  	 		= '"+usuario.getCidade()       		+"' , "+
		" ESTADO  	 		= '"+usuario.getEstado()       		+"' , "+
		" ESTADO_CIVIL  	= '"+usuario.getEstadoCivil()       +"' , "+
		" EMAIL  	 		= '"+usuario.getEmail()       		+"' , "+
		" SENHA  	 		= '"+usuario.getSenha()       		+"' , "+
		" STATUS  	 		= "+usuario.getStatus()      		+"  , "+
		" NIVEL  	 		= "+usuario.getNivel()       		+"  , "+
		" WHERE ID   	 	= "+usuario.getId();
		
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
			System.out.println("Falha na Alteração do Usuario" + e.getMessage());
			
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;		
	}

	// CÓDIGO PARA EXCLUIR O USUARIO
	public boolean excluirUsuario(Usuario usuario) {
		boolean retorno = false;
		
		String excluir = " DELETE FROM USUARIO " +
		" WHERE ID  = "+usuario.getId();
		
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
			System.out.println("Falha ao Excluir o Usuario." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// CÓDIGO PARA VERIFICAR SE O ID EXISTE
	public boolean existeId(int id) {
		boolean retorno = false;
		
		String consulta = "SELECT * FROM USUARIO "+
		"WHERE ID =" + id;
		
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
				retorno = true;
			}
			
			
		} catch (SQLException e) {
			System.out.println("Falha na Execução da Consulta das Informações." + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
	// CÓDIGO PARA O USUARIO FAZER LOGIN
	public boolean loginUsuario(Usuario usuario) {
		boolean retorno = false;
		
		String autenticar = " SELECT EMAIL, SENHA FROM USUARIO " +
				" WHERE EMAIL = '"+usuario.getEmail()+"'  AND SENHA = '"+usuario.getSenha()+"' ";
				
		// ABRIR O QUERY BROWSER NA MEMORIA DO COMPUTADOR E COLAR O CODIGO NO MYSQL PARA SER EXECUTADO
		try {
			this.comandoSQL = this.conexaoMySQL.abrirBanco().prepareStatement(autenticar);
			
		} catch (SQLException e) {
			System.out.println("Falha na Transferência das Informações." + e.getMessage());
		}

		// EXECUTANDO O SCRIPT NO BANCO DE DADOS
		try {
			this.resultadoConsulta = this.comandoSQL.executeQuery();
			
			if(this.resultadoConsulta.next()) {
				retorno = true;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Falha na Autenticação do Usuario" + e.getMessage());
		}
		
		this.conexaoMySQL.fecharBanco();
		return retorno;
	}
	
}
