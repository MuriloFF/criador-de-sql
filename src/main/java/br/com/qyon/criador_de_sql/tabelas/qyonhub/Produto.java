package br.com.qyon.criador_de_sql.tabelas.qyonhub;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity()
@Table(name = "produto", uniqueConstraints = {
		@UniqueConstraint(name = "const_produto_empresa_nome", columnNames = { "empresa_id", "nome" }) })
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Produto() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "empresa_id")
	private Empresa empresa;

	@ManyToMany
	@JoinColumn(name = "caracteristica_id")
	private List<Caracteristica> caracteristicas = new ArrayList<>();

	@ManyToMany
	@JoinColumn(name = "grupo_id")
	private List<Grupo> grupo = new ArrayList<>();

	@OneToMany(mappedBy = "produto")
	// @JoinColumn(name = "imagem_url")
	private List<ProdutoImagem> imagem = new ArrayList<>();

	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@Column(nullable = false, name = "preco")
	private BigDecimal preco = BigDecimal.ZERO;

	@Column(nullable = false, name = "preco_com_desconto")
	private BigDecimal precoComDesconto = BigDecimal.ZERO;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoComDesconto() {
		return precoComDesconto;
	}

	public void setPrecoComDesconto(BigDecimal precoComDesconto) {
		this.precoComDesconto = precoComDesconto;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Produto ? this.id.equals(((Produto) obj).getId()) : false;
	}

}
