package br.com.alancrist.projetoavancado.services;

import java.util.List;

import javax.inject.Inject;

import br.com.alancrist.projetoavancado.models.Contato;
import br.com.alancrist.projetoavancado.repository.ContatoRepository;

public class ContatoService {
	
	@Inject
	private ContatoRepository dao;
	
	public void salvarContato(Contato contato) {
		this.dao.atualizarContato(contato);
	}
	
	public void removeContatoById(Long id) {
		this.dao.removeContatoById(id);
	}
	
	public List<Contato> listarContatos() throws Exception {
		return this.dao.listarContatos();
	}
	
}
