package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AnuncioDaoImpl;
import br.com.fiap.jpa.entity.Anuncio;
import br.com.fiap.jpa.entity.Comando;
import br.com.fiap.jpa.entity.Insight;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroComandoAndInsight {

	public static void main(String[] args) {
		try {
			// Obter o entity manager
			EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			AnuncioDaoImpl daoAnuncio = new AnuncioDaoImpl(em);
			
			//passar o id que foi cadastrado no banco
			Anuncio anuncio = daoAnuncio.buscar(1);
			
			Comando comando = new Comando();
			comando.setAnuncio(anuncio);
			comando.setConteudo("Me gere um anúncio sobre uma mecanica de motos que está localizada em são paulo e oferece serviços acessiveis");
			anuncio.getComandos().add(comando);
			
			Insight insight = new Insight();
			insight.setAnuncio(anuncio);
			insight.setConteudo("Título: Mecânica de motos acessível em São Paulo - Conheça nossos serviços!"
					+ "\r\n"
					+ "\r\n"
					+ "Descrição: Na nossa oficina de motos em São Paulo, oferecemos serviços de manutenção e reparo com qualidade e preços acessíveis. "
					+ "Nossa equipe de mecânicos especializados está pronta para atender todas as suas necessidades!");
			anuncio.getInsights().add(insight);
			
			daoAnuncio.salvar(anuncio);
			daoAnuncio.commit();
			System.out.println("Comando e Insight criados com sucesso!");
			
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}

	}

}
