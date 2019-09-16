package bean;



public class BeanUsuarioFone {

	
	private String nome;
	private String email;
	private String senha;
	private Long ddd;
	private String numero;
	private String tipo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Long getDdd() {
		return ddd;
	}
	public void setDdd(Long ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	@Override
	public String toString() {
		return "BeanUsuarioFone [nome=" + nome + ", email=" + email + ", senha=" + senha + ", ddd=" + ddd + ", numero="
				+ numero + ", tipo=" + tipo + "]";
	}

}
