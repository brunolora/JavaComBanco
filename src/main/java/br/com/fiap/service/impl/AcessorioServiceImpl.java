package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.AcessorioDAOImpl;
import br.com.fiap.entity.Acessorio;
import br.com.fiap.service.GenericService;

public class AcessorioServiceImpl extends GenericService<Acessorio, Long> {

private static AcessorioServiceImpl instance = null;
	
	private AcessorioDAOImpl AcessorioDAO;
	
	private AcessorioServiceImpl() {
		AcessorioDAO = AcessorioDAOImpl.getInstance();
	}
	
	public static AcessorioServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new AcessorioServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Acessorio instance) {
		try {
			AcessorioDAO.salvar(instance, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Acessorio instance) {
		try {
			AcessorioDAO.atualizar(instance, getEntityManager());
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
			AcessorioDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Acessorio obter(Long id) {
		Acessorio Acessorio = null;
		
		try {
			Acessorio = AcessorioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return Acessorio;
	}

	@Override
	public List<Acessorio> listar() {
		List<Acessorio> Acessorios = null;
		
		try {
			Acessorios = AcessorioDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return Acessorios;
	}

}
