package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Anuncio;

public class AnuncioDaoImpl extends GenericDaoImpl<Anuncio, Integer> implements AnuncioDao {

    public AnuncioDaoImpl(EntityManager em) {
        super(em);
    }

}
