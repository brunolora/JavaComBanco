package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)
public class Acessorio implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;

	@Column(name = "ds_descricao", length = 80, nullable = true)
	private String descricao;
	
	@ManyToMany(mappedBy="acessorios")
	private List<Carro> carros;
	
	public Acessorio() {
		super();
	}

	public Acessorio(String descricao) {
		this();
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "\nDescricao: " + this.getDescricao();
	}

}
