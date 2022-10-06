/**
 * 
 */
package br.com.w2lima.appblank.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.w2lima.appblank.model.NotaModel;

/**
 * 
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
public interface NotaRepository extends JpaRepository<NotaModel, UUID> {

	
	@Query("""
			select n from NotaModel n 
				join fetch n.user u				
				join fetch n.vendas v
				join fetch v.produto p
			where n.id = :nota
			""")
	NotaModel findNota(UUID nota);
	
}
