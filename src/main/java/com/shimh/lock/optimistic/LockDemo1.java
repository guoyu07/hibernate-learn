package com.shimh.lock.optimistic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.OptimisticLock;

/*
 *  @Version 实现乐观锁 
 *  可以是：int or Integer short or Short long or Long java.sql.Timestamp 或java8的日期
 */
@Entity
@Table
public class LockDemo1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String need;
	/*
	 * 属性的修改都会触发version改变，此属性表示当我修改时不触发version改变
	 */
    @OptimisticLock( excluded = true )
    private long callCount;

    @Version
    private Long version;


    public void incrementCallCount() {
        this.callCount++;
    }


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNeed() {
		return need;
	}


	public void setNeed(String need) {
		this.need = need;
	}


	public long getCallCount() {
		return callCount;
	}


	public void setCallCount(long callCount) {
		this.callCount = callCount;
	}


	public Long getVersion() {
		return version;
	}


	public void setVersion(Long version) {
		this.version = version;
	}
    
    
}


