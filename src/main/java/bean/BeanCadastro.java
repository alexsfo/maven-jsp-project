package bean;

import java.util.ArrayList;

public class BeanCadastro {

	private String nome;
	private String email;
	private String senha;
	private Long id;
	private ArrayList<BeanTelefone> telefones = new ArrayList<BeanTelefone>();

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<BeanTelefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<BeanTelefone> telefones) {
		this.telefones = telefones;
	}

	public BeanCadastro() {

	}

}
