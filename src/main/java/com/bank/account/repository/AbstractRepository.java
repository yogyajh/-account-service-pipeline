package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
*
* @author Yogya Hewavidana
*
*/
@NoRepositoryBean
public interface AbstractRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T>{

    
	//implements Custom behaviour
   // @Modifying
   // @Query("update #{#entityName} e set e.deletedDate = ?2, e.version= (e.version+1) where e.id= ?1")
   // public void deleteSoft(Serializable id, Date date);
	
	
	
//	public class ExtendedRepositoryImpl<T, ID extends Serializable>
//	  extends SimpleJpaRepository<T, ID> implements ExtendedRepository<T, ID> {
//	    
//	    private EntityManager entityManager;
}
