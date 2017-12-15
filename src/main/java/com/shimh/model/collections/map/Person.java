package com.shimh.model.collections.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.MapKeyTemporal;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;

/**
 *  当map的value值为基本值时（不是实体） 必须用 @ElementCollection 标注
 *  	
 * 	当map的value值为基本值时  自定义关联表用 @CollectionTable
 *				为实体时    自定义关联表用 @JoinTable
 */


@Table
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	//private Map<Integer,String> lifes = new HashMap<>();

	/**
	 * person_hobbies{
	 * 	Person_id: person的id
	 * 	hobbies: map的value值
	 *  hobbies_KEY: map的key值
	 * 	
	 * }
	 */
	@ElementCollection
	private Map<Integer,String> hobbies = new HashMap<>();
	
	/**
	 * person_hobbies2{
	 * 	Person_id: person的id
	 * 	hobbies2: map的value值
	 *  hobbies2_KEY: map的key值
	 * 	
	 * }
	 */
	@ElementCollection
	@MapKeyTemporal(TemporalType.DATE)
	private Map<Date,String> hobbies2 = new HashMap<>();
	
	
	/**
	 * 什么都不加：
	 * 
	 * person{
	 * 	id
	 * 	name
	 * }
	 * 
	 * person_mobile{
	 * 	Person_id: person的id
	 * 	mobiles_id: mobile的id
	 * 	mobiles_KEY:map的key
	 * }
	 * 
	 * mobile{
	 * 	id
	 * 	name
	 * }
	 * 
	 * map的key为Mobile类的name属性，与保存时写啥没有关系
	 * Map<Mobile的name值,Mobile>
	 */
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private Map<String,Mobile> mobiles = new HashMap<>();
	
	
	/**
	 * @MapKeyColumn(name="m_key") 映射
	 * 
	 * person{
	 * 	id
	 * 	name
	 * }
	 * 
	 * person_mobile{
	 * 	Person_id: person的id
	 * 	mobiles_id: mobile的id
	 * 	m_key：map的key
	 * }
	 * 
	 * mobile{
	 * 	id
	 * 	name
	 * }
	 * 
	 * map的key为Mobile类的name属性，与保存时写啥没有关系
	 * Map<Mobile的name值,Mobile>
	 */
	//@MapKeyColumn(name="m_key")
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private Map<String,Mobile> mobiles = new HashMap<>();
	
	
	/**
	 * @MapKey 映射
	 * 
	 * person{
	 * 	id
	 * 	name
	 * }
	 * 
	 * person_mobile{
	 * 	Person_id: person的id
	 * 	mobiles_id: mobile的id
	 * }
	 * 
	 * mobile{
	 * 	id
	 * 	name
	 * }
	 * 
	 * map的key为Mobile类的name属性，与保存时写啥没有关系
	 * Map<Mobile的name值,Mobile>
	 */
	@MapKey(name = "name")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Map<String,Mobile> mobiles = new HashMap<>();
	
	@ElementCollection
	@MapKeyJoinColumn(name = "m_id")
	private Map<Mobile,String> mobiles2 = new HashMap<>();
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<Integer, String> getHobbies() {
		return hobbies;
	}


	public void setHobbies(Map<Integer, String> hobbies) {
		this.hobbies = hobbies;
	}


	public Map<Date, String> getHobbies2() {
		return hobbies2;
	}


	public void setHobbies2(Map<Date, String> hobbies2) {
		this.hobbies2 = hobbies2;
	}


	public Map<String, Mobile> getMobiles() {
		return mobiles;
	}


	public void setMobiles(Map<String, Mobile> mobiles) {
		this.mobiles = mobiles;
	}


	public Map<Mobile, String> getMobiles2() {
		return mobiles2;
	}


	public void setMobiles2(Map<Mobile, String> mobiles2) {
		this.mobiles2 = mobiles2;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", hobbies=" + hobbies + ", hobbies2=" + hobbies2 + ", mobiles="
				+ mobiles + ", mobiles2=" + mobiles2 + "]";
	}





/*	public Map<Integer, String> getLifes() {
		return lifes;
	}


	public void setLifes(Map<Integer, String> lifes) {
		this.lifes = lifes;
	}*/
	
	
	
	
	
}
