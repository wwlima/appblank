/**
 * 
 */
package br.com.w2lima.appblank.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.w2lima.appblank.model.VendaModel;

/**
 * 
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
public interface VendaRepository extends JpaRepository<VendaModel, UUID> {

	List<VendaModel> findByNotaId(UUID notaId);	
	
}
