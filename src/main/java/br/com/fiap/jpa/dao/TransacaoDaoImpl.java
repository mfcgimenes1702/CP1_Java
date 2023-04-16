package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Transacao;

public class TransacaoDaoImpl extends GenericDaoImpl<Transacao, Integer> implements TransacaoDao {

    public TransacaoDaoImpl(EntityManager em) {
        super(em);
    }

}