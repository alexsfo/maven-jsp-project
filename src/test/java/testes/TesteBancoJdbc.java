package testes;


import org.junit.Test;

import bean.*;
import dao.DaoUsuario;
import java.util.List;




public class TesteBancoJdbc  {
	
	
	
	@Test
	public void consultar() {
		BeanCadastro usuario = new BeanCadastro();
		usuario.setNome("Alex");
		
	}
	
	
	@Test
	public void updateUser(){
		BeanCadastro usuario = new BeanCadastro();
		usuario.setNome("alterado");
		usuario.setEmail("alterado@gmail.com");
		usuario.setSenha("alterado123");
		usuario.setId(10L);
	DaoUsuario  usuario2 = new DaoUsuario();
	usuario2.atualizar(usuario);
	}

	@Test
	public void initdeletar() {
		try {

			DaoUsuario dao = new DaoUsuario();
			dao.delete("Thomas Jefferson");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testeInsertTelefone() {
		BeanTelefone telefone = new BeanTelefone();
		telefone.setDdd(81);
		telefone.setNumero("esse momento é meu");
		telefone.setTipo("celular");
		telefone.setIdUsuario(1L);
		
		DaoUsuario daoUsuario = new DaoUsuario();
		daoUsuario.salvarTelefone(telefone);
	}
	
	
	@Test
	public void testSalvarUsuario() {
		BeanCadastro usuario = new BeanCadastro();
		usuario.setNome("TESTANDO");
		usuario.setEmail("TESTANDO");
		usuario.setSenha("TESTANDO");
		
		DaoUsuario daoUsuario = new DaoUsuario();
	daoUsuario.salvar(usuario);
	}
	
	
	@Test
	public void testeCaregaFonesUsuario() {
		DaoUsuario usuario = new DaoUsuario();
		
		
		List<BeanUsuarioFone> beanUsuarioFones = usuario.listaUsuarioFone(1L);
		
		for (BeanUsuarioFone beanUsuarioFone : beanUsuarioFones) {
			System.out.println(beanUsuarioFone);
			
		}
		
		
	}
	
	@Test
	public void testeDeleteUsuarioFone() {
		DaoUsuario usuario = new DaoUsuario();
		usuario.deleteFonesByUser(2L);
	}
	
	
	
	
	
	
	
	
}
