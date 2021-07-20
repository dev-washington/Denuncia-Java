
public class Denuncia {

	// ATRIBUTOS
	private int id;
	private Usuario usuario;
	private String ocorrencia;
	private String tipo;
	private String rua;
	private String bairro;
	private String cidade;
	private String dataHora;
	
	
	// CONSTRUTORES
	public Denuncia() {
		super();
	}


	public Denuncia(int id, Usuario usuario, String ocorrencia, String tipo, String rua, String bairro, String cidade,
			String dataHora) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.ocorrencia = ocorrencia;
		this.tipo = tipo;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.dataHora = dataHora;
	}


	public Denuncia(Usuario usuario, String ocorrencia, String tipo, String rua, String bairro, String cidade,
			String dataHora) {
		super();
		this.usuario = usuario;
		this.ocorrencia = ocorrencia;
		this.tipo = tipo;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.dataHora = dataHora;
	}


	// METODOS GET E SET
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getOcorrencia() {
		return ocorrencia;
	}


	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getDataHora() {
		return dataHora;
	}


	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
}
