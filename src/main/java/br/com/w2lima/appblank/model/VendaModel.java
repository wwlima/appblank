package br.com.w2lima.appblank.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsExclude;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
 
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_VENDA")
public class VendaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENDA", nullable = false)
    private Integer id;
	
    @EqualsExclude
	@ManyToOne	
	@JoinColumn(name = "ID_NOTA")
	private NotaModel nota;

    @EqualsExclude
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "ID_PRODUTO")
	private ProdutoModel produto;	
	
    @EqualsExclude
	@Column(name = "QTD_PRODUTO")
	private int qtd;
	
    @EqualsExclude
	@Column(name = "VL_PRODUTO")
	private double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NotaModel getNota() {
		return nota;
	}

	public void setNota(NotaModel nota) {
		this.nota = nota;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
		VendaModel other = (VendaModel) obj;
		return Objects.equals(id, other.id);
	}

	

	

}
