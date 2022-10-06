/**
 * 
 */
package br.com.w2lima.appblank.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.w2lima.appblank.model.ProdutoModel;

/**
 * 
 * @author William Wilson Carvalho de Lima ( wwlima@gmail.com )
 *
 */
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

}
