package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

    void salvar(String usuario);

}
