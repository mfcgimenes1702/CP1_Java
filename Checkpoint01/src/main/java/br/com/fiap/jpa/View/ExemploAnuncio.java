package br.com.fiap.jpa.View;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.AnuncioDao;
import br.com.fiap.jpa.dao.AnuncioDaoImpl;
import br.com.fiap.jpa.entity.Anuncio;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploAnuncio {

    public static void main(String[] args) {
        // Obter o entity manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        // Instanciar o DAO

        AnuncioDao dao = new AnuncioDaoImpl(em);

        // Instanciar (implementar um construtor na classe)
        Anuncio anuncio = new Anuncio("Ativo", "Contas Publicas", "Marcelo");

        // cadastrar
        try {
            dao.salvar(anuncio);
            dao.commit();
            System.out.println("Anuncio cadastrado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Pesquisar
            Anuncio busca = dao.buscar(1);
            System.out.println(busca.getConteudo());

            // Atualizar
            busca.setCodigo(1);
            dao.salvar(busca);
            dao.commit();
            System.out.println("Anuncio atualizado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // remover
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Anuncio removido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}