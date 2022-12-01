package com.jsfprimefacesproject.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jsfprimefacesproject.model.User;
import com.jsfprimefacesproject.repository.Users;
import com.jsfprimefacesproject.util.Transacional;

public class CadastroUserService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Users users;

    @Transacional
    public void salvar(User user) {
    	users.guardar(user);
    }

    @Transacional
    public void excluir(User user) {
    	users.remover(user);
    }

}