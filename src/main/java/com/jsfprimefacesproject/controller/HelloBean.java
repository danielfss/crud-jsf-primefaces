package com.jsfprimefacesproject.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsfprimefacesproject.model.Hello;

@Named
@ViewScoped
public class HelloBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Hello hello;

	@PostConstruct
	public void init() {
		hello = new Hello();
		hello.setUser("User");
		hello.setMessage("Hello");
	}

	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}

}
