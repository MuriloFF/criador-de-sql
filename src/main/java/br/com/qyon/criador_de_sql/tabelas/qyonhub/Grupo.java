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
@Table(name = "grupo", uniqueConstraints = {
		@UniqueConstraint(name = "const_grupo_empresa_nome", columnNames = { "empresa_id", "nome" }) })
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	public Grupo() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "empresa_id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(nullable = true, name = "grupo_pai_id")
	private Grupo grupoPai;

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = false, name = "ordem")
	private Integer ordem;

	@Column(nullable = true, name = "imagem_url")
	private String imagemUrl;

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

	public Grupo getGrupoPai() {
		return grupoPai;
	}

	public void setGrupoPai(Grupo grupoPai) {
		this.grupoPai = grupoPai;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Grupo ? this.id.equals(((Grupo) obj).getId()) : false;
	}

}
