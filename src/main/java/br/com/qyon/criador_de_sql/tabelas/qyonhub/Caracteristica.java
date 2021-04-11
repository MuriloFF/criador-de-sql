package br.com.qyon.criador_de_sql.tabelas.qyonhub;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity()
@Table(name = "caracteristica", uniqueConstraints = {
		@UniqueConstraint(name = "const_caracteristica_empresa_nome", columnNames = { "empresa_id", "nome" }) })
public class Caracteristica implements Serializable {

	private static final long serialVersionUID = 1L;

	public Caracteristica() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "empresa_id")
	private Empresa empresa;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = false, name = "qtd_minima")
	private Integer qtdMinima = 0;

	@Column(nullable = false, name = "qtd_maxima")
	private Integer qtdMaxima = 0;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Integer qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Integer getQtdMaxima() {
		return qtdMaxima;
	}

	public void setQtdMaxima(Integer qtdMaxima) {
		this.qtdMaxima = qtdMaxima;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Caracteristica ? this.id.equals(((Caracteristica) obj).getId()) : false;
	}

}
