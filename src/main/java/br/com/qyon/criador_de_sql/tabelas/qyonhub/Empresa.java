package br.com.qyon.criador_de_sql.tabelas.qyonhub;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity()
@Table(name = "empresa", uniqueConstraints = { //
		@UniqueConstraint(name = "const_empresa_razaoSocial", columnNames = { "razao_social" }), //
		@UniqueConstraint(name = "const_empresa_cnpj", columnNames = { "cnpj" }) //
})
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Empresa() {
		this.id = UUID.randomUUID();
	}

	@Id
	private UUID id;

	@Column(nullable = false, name = "razao_social")
	private String razaoSocial;

	// Apelido
	@Column(nullable = false, name = "nome")
	private String nome;

	@Column(nullable = false, name = "cnpj")
	private String cnpj;

	@Column(nullable = false, name = "descricao")
	private String descricao;

	@Column(nullable = true, name = "imagem_logo")
	private String imagemLogo;

	@Column(nullable = true, name = "imagem_background")
	private String imagemBackground;

	@Column(nullable = false, name = "estado")
	private String estado;

	@Column(nullable = false, name = "cidade")
	private String cidade;

	@Column(nullable = false, name = "endereco")
	private String endereco;

	@Column(nullable = false, name = "numero")
	private Integer numero;

	@Column(nullable = false, name = "cep")
	private String cep;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagemLogo() {
		return imagemLogo;
	}

	public void setImagemLogo(String imagemLogo) {
		this.imagemLogo = imagemLogo;
	}

	public String getImagemBackground() {
		return imagemBackground;
	}

	public void setImagemBackground(String imagemBackground) {
		this.imagemBackground = imagemBackground;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof Empresa ? this.id.equals(((Empresa) obj).getId()) : false;
	}

}
