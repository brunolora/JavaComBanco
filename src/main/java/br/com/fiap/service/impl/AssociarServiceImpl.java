package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.entity.Associar;
import br.com.fiap.dao.impl.AssociarDAOImpl;
import br.com.fiap.service.GenericService;

public class AssociarServiceImpl extends GenericService<Associar, Long> {
	
	private static AssociarServiceImpl instance = null;
	private AssociarDAOImpl associarDAO;

	private AssociarServiceImpl() {
		associarDAO = AssociarDAOImpl.getInstance();
	}

	public static AssociarServiceImpl getInstance() {
		if (instance == null) {
			instance = new AssociarServiceImpl();
		}
		return instance;
	}

	@Override
	public void inserir(Associar instance) {
		try {
			associarDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Associar instance) {
		try {
			associarDAO.atualizar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			associarDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Associar obter(Long id) {
		Associar associar = null;
		try {
			associar = associarDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		return associar;
	}

	@Override
	public List<Associar> listar() {
		List<Associar> associar = null;
		try {
			associar = associarDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		return associar;
	}
}
