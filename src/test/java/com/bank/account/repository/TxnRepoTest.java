package com.bank.account.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;

import com.bank.account.config.JpaDataConfig;
import com.bank.account.constant.AcctType;
import com.bank.account.domain.TransactionEntity;

@ContextConfiguration(classes = JpaDataConfig.class)
@DataJpaTest
public class TxnRepoTest {

	@Autowired
	TxnRepository txnRepository;

	public static final String acctNumber = "567459872";

	@Test
	public void findUser() throws Exception {
	
		Page<TransactionEntity> page = txnRepository.getTransactions(acctNumber,
				PageRequest.of(0, 10, Sort.by("createdDate").descending()));
		assertEquals(4, page.getNumberOfElements());
		assertEquals(acctNumber, page.getContent().iterator().next().getToAccount().getAcctNumber());
	}
	
	
	@Test
	public void findUser2() throws Exception {
	
		System.out.println("///////////spec");
		Page<TransactionEntity> page = txnRepository.findAll(new TxnDetailSpec(acctNumber),
				PageRequest.of(0, 10, Sort.by("createdDate").descending()));
		assertEquals(4, page.getNumberOfElements());
		assertEquals(acctNumber, page.getContent().iterator().next().getToAccount().getAcctNumber());
	}
	
	public class TxnDetailSpec implements Specification<TransactionEntity> {

		private static final long serialVersionUID = 8504696003067354251L;
		private String acctNumber;

		public TxnDetailSpec(String acctNumber) {
			this.acctNumber = acctNumber;

		}

		@Override
		public Predicate toPredicate(Root<TransactionEntity> root, CriteriaQuery<?> query,
				CriteriaBuilder criteriaBuilder) {
			root.fetch("fromAccount", JoinType.LEFT);
			root.fetch("toAccount", JoinType.LEFT);
			List<Predicate> predicateList = new ArrayList<Predicate>();
			predicateList.add(criteriaBuilder.or(
					criteriaBuilder.equal(root.get("fromAccount").get("acctNumber"), acctNumber),
					criteriaBuilder.equal(root.get("toAccount").get("acctNumber"), acctNumber)));

			return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
		}

	}
	
	
//	EntityManager em = ...;
//	CriteriaBuilder cb = em.getCriteriaBuilder();
//
//	CriteriaQuery<Entity class> cq = cb.createQuery(Entity.class);
//	Root<Entity> from = cq.from(Entity.class);
//
//	cq.select(Entity);
//	TypedQuery<Entity> q = em.createQuery(cq);
//	List<Entity> allitems = q.getResultList();
//	
//	
//	TypedQuery<T> instance is used to prepare a query for execution and 
//	specifying the type of the query result.
	
//	
//	QCustomer customer = QCustomer.customer;
//
//
//	BooleanExpression customerHasBirthday = customer.birthday.eq(today);
//	BooleanExpression isLongTermCustomer = customer.createdAt.lt(today.minusYears(2));
//	customerRepository.findAll(customerHasBirthday.and(isLongTermCustomer));

}
