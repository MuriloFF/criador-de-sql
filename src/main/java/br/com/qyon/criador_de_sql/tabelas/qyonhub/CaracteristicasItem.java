package br.com.qyon.criador_de_sql.tabelas.qyonhub;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity()
@Table(name = "caracteristica_item", uniqueConstraints = {
		@UniqueConstraint(name = "const_caracteristicaItem_caracteristica_nome", columnNames = { "caracteristica_id",
				"nome" }) })
public class CaracteristicasItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public CaracteristicasItem() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "caracteristica_id")
	private Caracteristica caracteristica;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@Column(nullable = false, name = "preco_adicional")
	private BigDecimal precoAdicional = BigDecimal.ZERO;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoAdicional() {
		return precoAdicional;
	}

	public void setPrecoAdicional(BigDecimal precoAdicional) {
		this.precoAdicional = precoAdicional;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof CaracteristicasItem ? this.id.equals(((CaracteristicasItem) obj).getId()) : false;
	}

}
