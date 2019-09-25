package br.com.alancrist.projetoavancado.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alancrist.projetoavancado.models.Contato;
import br.com.alancrist.projetoavancado.services.ContatoService;

@Named
@RequestScoped
public class ContatoController {
	
	private List<Contato> contatos;

	@Inject
	private Contato contato;

	@Inject
	private ContatoService service;
	
	public List<Contato> listarContatos() throws Exception {
		this.contatos = service.listarContatos();
		return this.contatos;
	}
	
	public String salvarContato() {
		service.salvarContato(contato);
		return "";
	}
	
	public String removeContato() {
		service.removeContatoById(contato.getId());
		return "";
	}
	
	public String novoContato() {
		Contato contato = new Contato();
		return "";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
}