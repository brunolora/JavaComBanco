package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.ModeloDAOImpl;
import br.com.fiap.entity.Modelo;
import br.com.fiap.service.GenericService;

public class ModeloServiceImpl extends GenericService<Modelo, Long> {

private static ModeloServiceImpl instance = null;
	
	private ModeloDAOImpl ModeloDAO;
	
	private ModeloServiceImpl() {
		ModeloDAO = ModeloDAOImpl.getInstance();
	}
	
	public static ModeloServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new ModeloServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Modelo modelo) {
		try {
			ModeloDAO.salvar(modelo, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void atualizar(Modelo instance) {
		try {
			ModeloDAO.atualizar(instance, getEntityManager());
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
			ModeloDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Modelo obter(Long id) {
		Modelo Modelo = null;
		
		try {
			Modelo = ModeloDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return Modelo;
	}

	@Override
	public List<Modelo> listar() {
		List<Modelo> Modelos = null;
		
		try {
			Modelos = ModeloDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return Modelos;
	}

}