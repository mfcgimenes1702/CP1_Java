package br.com.fiap.jpa.View;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.UsuarioDao;
import br.com.fiap.jpa.dao.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploUsuario {

    public static void main(String[] args) {
        // Obter o entity manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        // Instanciar o DAO

        UsuarioDao dao = new UsuarioDaoImpl(em);

        // Instanciar (implementar um construtor na classe)
        Usuario usuario = new Usuario("Marcelo Gimenes", "marcelo@hotmail.com", "123456", 10);

        // cadastrar
        try {
            dao.salvar(usuario);
            dao.commit();
            System.out.println("Usuário cadastrado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Pesquisar
            Usuario busca = dao.buscar(1);
            System.out.println(busca.getNome());

            // Atualizar
            busca.setCodigo(1);
            dao.salvar(busca);
            dao.commit();
            System.out.println("Usuário atualizado!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // remover
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Usuário removido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}