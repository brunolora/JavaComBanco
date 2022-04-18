package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_associar")
@SequenceGenerator(name = "associar", sequenceName = "SQ_TB_ASSOCIAR", allocationSize = 1)
public class Associar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Lob
	private Carro carro;

	private Acessorio acessorio;

	private Modelo modelo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;
	
	@ManyToMany
	@JoinTable(
			name = "tb_carro_acessorio",
			joinColumns = @JoinColumn(name = "carro_id"),
			inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private Modelo modelos;
	
	public Associar() {
		super();
	}
	
	public Associar(Carro carro, Modelo modelo, Acessorio acessorio) {
		this();
		this.carro = carro;
		this.acessorio = acessorio;
		this.modelo = modelo;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
	return "\nCarro: " + this.getCarro() 
		+ "\nModelo: " + this.getModelo()
		+ "\nAcessorio: " + this.getAcessorio();
}

}
	
	

