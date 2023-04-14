package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Insight;

public class InsightDaoImpl extends GenericDaoImpl<Insight, Integer> implements InsigthDao {

    public InsightDaoImpl(EntityManager em) {
        super(em);
    }

}
