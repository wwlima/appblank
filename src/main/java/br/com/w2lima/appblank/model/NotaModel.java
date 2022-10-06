package br.com.w2lima.appblank.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsExclude;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 */

@Entity
@Table(name = "TB_NOTA")
public class NotaModel {

	@Id
	@Column(name = "ID_NOTA", length = 36)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;

	@EqualsExclude
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data;

	@EqualsExclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USER")
	private UserModel user;

	@EqualsExclude
	@OneToMany(mappedBy = "nota", cascade = CascadeType.ALL)
	private List<VendaModel> vendas = new ArrayList<>();

	public NotaModel() {
		super();
	}

	public NotaModel(UUID id, LocalDate data, UserModel user) {
		super();
		this.id = id;
		this.data = data;
		this.user = user;
	}

	public void addProduto(ProdutoModel produto, int qtd) {
		VendaModel venda = new VendaModel();
		venda.setNota(this);
		venda.setProduto(produto);
		venda.setQtd(qtd);
		venda.setValor(produto.getValor());
		vendas.add(venda);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<VendaModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaModel> vendas) {
		this.vendas = vendas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaModel other = (NotaModel) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		String result = """
				Nota: [IDNOTA]
				  Cliente: [NOMEUSUARIO]
				  Data: [DATANOTA]
				  itens:
				""";
		String itens =

				" --ID--------------------------------- PRODUTO -- QTD ----  VALOR --------\n";
		for (VendaModel vendaModel : vendas) {
			itens = itens
					.concat(" " + vendaModel.getProduto().getId().toString() + "  " + vendaModel.getProduto().getName()
							+ "     " + vendaModel.getQtd() + "         " + vendaModel.getValor() + "\n");
		}

		return result.concat(itens).replace("[IDNOTA]", id.toString()).replace("[NOMEUSUARIO]", user.getName())
				.replace("[DATANOTA]", data.toString());
	}

}
