package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroUsuario {

	public static void main(String[] args) {
		try {
			// Obter o entity manager
			EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

			Usuario usuario = new Usuario();
			usuario.setNome("Gustavo Balero");
			usuario.setEmail("rm93090@fiap.com.br");
			usuario.setSenha("12345");
			usuario.setSaldo(200.00);

			UsuarioDaoImpl dao = new UsuarioDaoImpl(em);
			dao.salvar(usuario);
			dao.commit();
			System.out.println("Usuario salvo com sucesso!");

		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}

	}

}
