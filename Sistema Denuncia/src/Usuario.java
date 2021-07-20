
public class Usuario {

	// ATRIBUTOS
	private int id;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String sexo;
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String estadoCivil;
	private String email;
	private String senha;
	private int status;
	private int nivel;
	
	// CONSTRUTORES
	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String dataNascimento, String cpf, String rg, String sexo, String cep,
			String rua, String bairro, String cidade, String estado, String estadoCivil, String email, String senha,
			int status, int nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.nivel = nivel;
	}

	public Usuario(String nome, String dataNascimento, String cpf, String rg, String sexo, String cep, String rua,
			String bairro, String cidade, String estado, String estadoCivil, String email, String senha, int status,
			int nivel) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.nivel = nivel;
	}

	// METODOS GET E SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
