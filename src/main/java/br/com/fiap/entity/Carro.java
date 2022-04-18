package br.com.fiap.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;

	@Column(name = "ds_placa", length = 7, nullable = false)
	private String placa;

	@Column(name = "ds_cor", length = 20, nullable = false)
	private String cor;

	@Column(name = "ds_chassi", length = 17, nullable = false)
	private String chassi;

	@ManyToMany
	@JoinTable(name = "tb_carro_acessorio", 
	joinColumns = @JoinColumn(name = "carro_id"), 
	inverseJoinColumns = @JoinColumn(name = "acessorio_id"))

	private List<Acessorio> acessorios;

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setAcessorios(List<Acessorio> Acessorios) {
		this.acessorios = Acessorios;
	}

	public Carro() {
	}
	
	public Carro(String placa, String cor, String chassi) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	@Override
	public String toString() {
		return "Placa: " + this.getPlaca() + "\nCor: " + this.getCor() 
		+ "\nChassi: " + this.getChassi();
	}

}
