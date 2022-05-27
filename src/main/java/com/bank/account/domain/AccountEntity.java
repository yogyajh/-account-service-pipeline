package com.bank.account.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;

import com.bank.account.constant.AcctType;
import com.bank.account.constant.Currency;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
*
* @author Yogya Hewavidana
*
*/
@Entity
@Table(name = "account", uniqueConstraints = { @UniqueConstraint(columnNames = { "acct_number" }) })
@Cacheable
@Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 9013151503308578258L;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	@NotNull
	@Column(name = "acct_number", nullable = false)
	private String acctNumber;

	@NotNull
	@Column(name = "acct_name", nullable = false)
    private String acctName;

	@Enumerated(EnumType.STRING)
	@Column(name = "acct_type")
	private AcctType acctType;

	@Enumerated(EnumType.STRING)
	@Column(name = "currency")
	private Currency currency;

	@Column(name = "available_balance")
	private BigDecimal availableBalance;

	@Column(name = "total_balance")
	private BigDecimal totalBalance;

}


//cache concurency strategy

//READ_WRITE: This strategy guarantees strong consistency which it achieves by using ‘soft' locks: 
//When a cached entity is updated, a soft lock is stored in the cache for that entity as well,
//which is released after the transaction is committed. 
//All concurrent transactions that access soft-locked entries
//will fetch the corresponding data directly from database


// serial verion uid

//The SerialVersionUID can be used during deserialization to verify that the sender and receiver 
//of a serialized object have loaded classes for that object that are compatible w.r.t serialization. 
//If the deserialization object is different than serialization, then it can throw an InvalidClassException