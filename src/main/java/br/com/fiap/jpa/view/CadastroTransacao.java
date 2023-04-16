package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TransacaoDaoImpl;
import br.com.fiap.jpa.dao.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.Transacao;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTransacao {

	public static void main(String[] args) {
		try {
			// Obter o entity manager
			EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
			UsuarioDaoImpl daoUsuario = new UsuarioDaoImpl(em);
			TransacaoDaoImpl daoTransacao = new TransacaoDaoImpl(em);

			//passar o id que foi cadastrado no banco
			Usuario usuario = daoUsuario.buscar(1);

			Transacao transacao = new Transacao();
			transacao.setUsuario(usuario);
			transacao.setTitulo("Crédito Adicionado");
			transacao.setDataCadastro(new GregorianCalendar(2023, Calendar.APRIL, 15));
			transacao.setValor(25.0);

			daoTransacao.salvar(transacao);
			System.out.println("Transacao salva com sucesso!");
			
			usuario.setSaldo(usuario.getSaldo() + transacao.getValor());
			daoUsuario.salvar(usuario);
			System.out.println("Saldo do usuario atualizado com sucesso!");

			daoTransacao.commit();
		} catch (Exception e) {
			
			System.err.println(e.getStackTrace());
		}
	}

}
