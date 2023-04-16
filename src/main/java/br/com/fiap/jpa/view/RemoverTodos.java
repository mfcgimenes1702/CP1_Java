package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AnuncioDaoImpl;
import br.com.fiap.jpa.dao.ComandoDaoImpl;
import br.com.fiap.jpa.dao.InsightDaoImpl;
import br.com.fiap.jpa.dao.TransacaoDaoImpl;
import br.com.fiap.jpa.dao.UsuarioDaoImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class RemoverTodos {

	public static void main(String[] args) {

		try {
			// Obter o entity manager
			EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			
			UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(em);
			TransacaoDaoImpl daoTransacao = new TransacaoDaoImpl(em);
			AnuncioDaoImpl daoAnuncio = new AnuncioDaoImpl(em);
			ComandoDaoImpl daoComando = new ComandoDaoImpl(em);
			InsightDaoImpl daoInsight = new InsightDaoImpl(em);
			
			//usar IDs que estão cadastrados no banco
			daoInsight.remover(1);
			daoComando.remover(1);
			daoAnuncio.remover(1);
			daoTransacao.remover(1);
			daoUsuario.remover(1);
			
			daoInsight.commit();
			daoComando.commit();
			daoAnuncio.commit();
			daoTransacao.commit();
			daoUsuario.commit();
			
			System.out.println("Registros removidos com sucesso!");
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}

	}

}
