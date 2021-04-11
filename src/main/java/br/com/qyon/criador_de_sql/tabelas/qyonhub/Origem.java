package br.com.qyon.criador_de_sql.tabelas.qyonhub;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
//@Table(name = "origem", uniqueConstraints = {
//		@UniqueConstraint(name = "const_origem_descricao", columnNames = { "descricao" }) }, schema = "vendas")
public class Origem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@Column(nullable = false, name = "ativo")
	private Boolean ativo;

	// "Sem limite" c/ text
	@Column(nullable = true, name = "tabela_preco", columnDefinition = "text")
	private String tabela_preco;

	@Column(nullable = true, name = "local_estoque")
	private String local_estoque;

	// "Sem limite" c/ varchar
	@Column(nullable = false, name = "logo", columnDefinition = "varchar")
	private String logo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getTabela_preco() {
		return tabela_preco;
	}

	public void setTabela_preco(String tabela_preco) {
		this.tabela_preco = tabela_preco;
	}

	public String getLocal_estoque() {
		return local_estoque;
	}

	public void setLocal_estoque(String local_estoque) {
		this.local_estoque = local_estoque;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

}
