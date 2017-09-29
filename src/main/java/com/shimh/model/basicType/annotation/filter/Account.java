package com.shimh.model.basicType.annotation.filter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

/*
 * filter entites use @filter   
 * 
 * 不可能将@Filter和缓存集合@Cache结合起来。
 * 这种限制是由于确保一致性，因为过滤信息不存储在第二级缓存中。 
 * 
 * 如果当前筛选的集合允许缓存，则第二级缓存将只存储整个集合的一个子集。
 * 之后，即使会话级过滤器没有显式激活，其他会话也将从缓存中获取经过筛选的集合。
 * 因此，第二级集合缓存仅限于存储整个集合，而不是存储子集
 */
@Entity
@Table
@FilterDef(name="activeAccount", parameters= {@ParamDef( name="active", type="boolean")} )
@Filter(name="activeAccount", condition="active = :active")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Client client;
    
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType type;

    private Double amount;

    private Double rate;

    private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", client=" + client + ", type=" + type + ", amount=" + amount + ", rate=" + rate
				+ ", active=" + active + "]";
	}


}
