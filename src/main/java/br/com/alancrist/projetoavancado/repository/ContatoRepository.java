package br.com.alancrist.projetoavancado.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.alancrist.projetoavancado.jpautils.JPAUtils;
import br.com.alancrist.projetoavancado.models.Contato;

public class ContatoRepository {

		public Contato getbyId(Long id) {
			EntityManager entityManager = JPAUtils.getEntityManager();
			return entityManager.find(Contato.class, id);
		}
		
		public void salvarContato(Contato contato) {
			EntityManager entityManager = JPAUtils.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			if (contato.getId() == null) {
				entityManager.persist(contato);
			} else {
				entityManager.merge(contato);
			}
			entityTransaction.commit();
			entityManager.close();
		}
		
		public Contato atualizarContato(Contato contato) {
			EntityManager entityManager = JPAUtils.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Contato updateContato = entityManager.merge(contato);
			entityTransaction.commit();
			entityManager.close();
			
			return updateContato;
		}
		
		public void removeContato(Contato contato) {
			EntityManager entityManager = JPAUtils.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(contato);
			entityTransaction.commit();
			entityManager.close();
		}
		
		public void removeContatoById(Long id) {
			EntityManager entityManager = JPAUtils.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			Contato contato = new Contato();
			contato = entityManager.find(Contato.class, id);
			entityTransaction.begin();
			entityManager.remove(contato);
			
			entityTransaction.commit();
			entityManager.close();
		}
		
		
		public List<Contato> listarContatos() throws Exception {
			EntityManager entityManager = JPAUtils.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			List<Contato> contatos = new ArrayList<Contato>();
			
			try {
				entityTransaction.begin();
				Query query = entityManager.createQuery("SELECT object(c) FROM contatos as c");
				entityTransaction.commit();
				return query.getResultList();
			} catch (Exception e) {
				e.getMessage();
				entityTransaction.rollback();
			} finally {
				entityManager.close();
			}
			
			return contatos;
		}
		
		
	
	
}
