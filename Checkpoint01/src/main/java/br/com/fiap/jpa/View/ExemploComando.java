package br.com.fiap.jpa.View;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ComandoDao;
import br.com.fiap.jpa.dao.ComandoDaoImpl;
import br.com.fiap.jpa.entity.Comando;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploComando {

    public static void main(String[] args) {
        // Obter o entity manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        // Instanciar o DAO

        ComandoDao dao = new ComandoDaoImpl(em);

        // Instanciar (implementar um construtor na classe)
        Comando comando = new Comando("Sorvete", "Qualidade do Sorverte");

        // cadastrar
        try {
            dao.salvar(comando);
            dao.commit();
            System.out.println("Comando cadastrado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Pesquisar
            Comando busca = dao.buscar(1);
            System.out.println(busca.getConteudo());

            // Atualizar
            busca.setCodigo(1);
            dao.salvar(busca);
            dao.commit();
            System.out.println("Comando atualizado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // remover
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Comando removido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}