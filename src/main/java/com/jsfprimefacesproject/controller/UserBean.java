package com.jsfprimefacesproject.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.jsfprimefacesproject.model.User;
import com.jsfprimefacesproject.repository.Users;
import com.jsfprimefacesproject.service.CadastroUserService;
import com.jsfprimefacesproject.util.FacesMessages;

@Named
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Users users;

	@Inject
	private FacesMessages messages;

	@Inject
	private CadastroUserService cadastroUserService;

	private List<User> listaUsers;

	private String termoPesquisa;

	private User user;

	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	
	public void prepararNovoUser() {
		user = new User();
	}

	public void salvar() {
		cadastroUserService.salvar(user);

		atualizarRegistros();

		messages.info("Usuário salvo com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:usersDataTable", "frm:messages"));
	}

	public void excluir() {
		cadastroUserService.excluir(user);

		user = null;

		atualizarRegistros();

		messages.info("Usuário excluído com sucesso!");
	}

	public void pesquisar() {
		listaUsers = users.pesquisar(termoPesquisa);

		if (listaUsers.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	public void todosUsers() {
		listaUsers = users.todas();
	}

	private void atualizarRegistros() {
		if (jaHouvePesquisa()) {
			pesquisar();
		} else {
			todosUsers();
		}
	}

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}

	public List<User> getListaUsers() {
		return listaUsers;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isUserSeleciona() {
		return user != null && user.getId() != null;
	}
}