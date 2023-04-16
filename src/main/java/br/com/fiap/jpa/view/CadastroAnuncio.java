package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AnuncioDaoImpl;
import br.com.fiap.jpa.dao.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.Anuncio;
import br.com.fiap.jpa.entity.Status;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroAnuncio {

	public static void main(String[] args) {

		try {
			// Obter o entity manager
			EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(em);
			AnuncioDaoImpl daoAnuncio = new AnuncioDaoImpl(em);
		
			//passar o id que foi cadastrado no banco
			Usuario usuario = daoUsuario.buscar(1);
			
			Anuncio anuncio = new Anuncio();
			anuncio.setUsuario(usuario);
			anuncio.setDescricao("Petshop");
			anuncio.setStatus(Status.ATIVO);
			
			daoAnuncio.salvar(anuncio);
			daoAnuncio.commit();
			System.out.println("Anuncio salvo com sucesso!");
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
	}

}
