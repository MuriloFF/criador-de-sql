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
@Table(name = "mesa", uniqueConstraints = {
		@UniqueConstraint(name = "const_mesa_empresa_numero", columnNames = { "empresa_id", "numero" }) })
public class Mesa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Mesa() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "empresa_id")
	private Empresa empresa;

	@Column(nullable = false, name = "numero")
	private Integer numero;

	@Column(nullable = false, name = "ocupado")
	private Boolean ocupado = false;

	@Column(nullable = true, name = "senha")
	private String senha;

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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Mesa ? this.id.equals(((Mesa) obj).getId()) : false;
	}

}
