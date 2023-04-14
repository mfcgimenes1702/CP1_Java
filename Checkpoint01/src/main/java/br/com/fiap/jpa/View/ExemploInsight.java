package br.com.fiap.jpa.View;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.InsightDaoImpl;
import br.com.fiap.jpa.dao.InsigthDao;
import br.com.fiap.jpa.entity.Insight;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploInsight {

    public static void main(String[] args) {
        // Obter o entity manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        // Instanciar o DAO

        InsigthDao dao = new InsightDaoImpl(em);

        // Instanciar (implementar um construtor na classe)
        Insight insight = new Insight("Soverte", "Foto Sorvete", "Qualidade do Sorvete");

        // cadastrar
        try {
            dao.salvar(insight);
            dao.commit();
            System.out.println("Insight cadastrado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Pesquisar
            Insight busca = dao.buscar(1);
            System.out.println(busca.getConteudo());

            // Atualizar
            busca.setConteudo("Sorvete");
            dao.salvar(busca);
            dao.commit();
            System.out.println("Insight atualizado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // remover
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Insight removido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}