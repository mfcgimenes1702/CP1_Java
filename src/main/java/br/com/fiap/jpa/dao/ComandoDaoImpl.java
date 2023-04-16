package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Comando;

public class ComandoDaoImpl extends GenericDaoImpl<Comando, Integer> implements ComandoDao {

    public ComandoDaoImpl(EntityManager em) {
        super(em);
    }

}