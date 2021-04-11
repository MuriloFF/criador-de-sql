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

@Entity
@Table(name = "produto_imagem", uniqueConstraints = {
		@UniqueConstraint(name = "const_produtoImagem_produto_imagemUrl", columnNames = { "produto_id",
				"imagem_url" }) })
public class ProdutoImagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	@ManyToOne
	@JoinColumn(nullable = false, name = "produto_id")
	private Produto produto;

	@Column(nullable = false, name = "imagem_url")
	private String imagemUrl;

	public ProdutoImagem() {
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof ProdutoImagem ? this.id.equals(((ProdutoImagem) obj).getId()) : false;
	}

}
