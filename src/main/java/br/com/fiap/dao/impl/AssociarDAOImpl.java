package br.com.fiap.dao.impl;

import br.com.fiap.entity.Associar;

public class AssociarDAOImpl extends HibernateGenericDAO<Associar, Long> {

	private static AssociarDAOImpl instance = null;
	
	public static AssociarDAOImpl getInstance() {
		if (instance == null) {
			instance = new AssociarDAOImpl();
		}
		
		return instance;
	}
	
	private AssociarDAOImpl() {
		super(Associar.class);
	}

}
