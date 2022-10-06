package br.com.w2lima.appblank.model;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_PRODUTO")
public class ProdutoModel {

	@Id
	@Column(name = "ID_PRODUTO", length = 36)
	@org.hibernate.annotations.Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

	@Column(name = "NM_PRODUTO")
    private String name;

	private Double valor;
	
	@OneToMany(mappedBy = "produto")	
	@Builder.Default
	private Set<VendaModel> vendas = new LinkedHashSet<>();

	@Override
	public String toString() {
		return "ProdutoModel [id=" + id + ", name=" + name + ", valor=" + valor;
	}
	
	
}
