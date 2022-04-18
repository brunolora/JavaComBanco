package br.com.fiap.service.impl;

import java.util.List;

import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.entity.Carro;
import br.com.fiap.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long> {

	private static CarroServiceImpl instance = null;
	
	private CarroDAOImpl carroDAO;

	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Carro carro) {
		try {
			carroDAO.salvar(carro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Carro carro) {
		try {
			carroDAO.atualizar(carro, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Carro obter(Long id) {
		Carro Carro = null;
		
		try {
			Carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return Carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> Carros = null;
		
		try {
			Carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return Carros;
	}
}
