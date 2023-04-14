package br.com.fiap.jpa.View;

import java.util.Calendar;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.TransacaoDao;
import br.com.fiap.jpa.dao.TransacaoDaoImpl;
import br.com.fiap.jpa.entity.Transacao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploTransacao {

    public static void main(String[] args) {
        // Obter o entity manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        // Instanciar o DAO do Usuário

        TransacaoDao dao = new TransacaoDaoImpl(em);

        // Instanciar (implementar um construtor na classe)
        Transacao transacao = new Transacao("Marca de Soverte", "asyusuai", Calendar.DATE, "150.00", "Marcelo");

        // cadastrar
        try {
            dao.salvar(transacao);
            dao.commit();
            System.out.println("Transação cadastrada!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Pesquisar
            Transacao busca = dao.buscar(1);
            System.out.println(busca.getTitulo());

            // Atualizar
            busca.setTitulo("Marca de Sorvete");
            dao.salvar(busca);
            dao.commit();
            System.out.println("Transação atualizada!");
        } catch (CommitException e) {
            System.out.println(e.getMessage());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // remover
        try {
            dao.remover(1);
            dao.commit();
            System.out.println("Transação removida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}