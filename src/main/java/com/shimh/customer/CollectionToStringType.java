package com.shimh.customer;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class CollectionToStringType implements UserType, ParameterizedType, Serializable{
	
    private String separator;
    /**
     * 默认 String
     */
    private Class elementType;
    /**
     * 默认 ArrayList
     */
    private Class collectionType;
	
	
	
	public void setParameterValues(Properties parameters) {
		String separator = (String) parameters.get("separator");
        if (!"".equals(separator)) {
            this.separator = separator;
        } else {
            this.separator = ",";
        }

        String collectionType = (String) parameters.get("collectionType");
        if (!"".equals(collectionType)) {
            try {
                this.collectionType = Class.forName(collectionType);
            } catch (ClassNotFoundException e) {
                throw new HibernateException(e);
            }
        } else {
            this.collectionType = java.util.ArrayList.class;
        }

        String elementType = (String) parameters.get("elementType");
        if (!"".equals(elementType)) {
            try {
                this.elementType = Class.forName(elementType);
            } catch (ClassNotFoundException e) {
                throw new HibernateException(e);
            }
        } else {
            this.elementType = String.class;
        }
		
	}

	public int[] sqlTypes() {
		return new int[]{Types.VARCHAR};
	}

	public Class returnedClass() {
		return collectionType;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return Objects.equals( x, y );
	}

	public int hashCode(Object x) throws HibernateException {
		 return Objects.hashCode( x );
	}
	
	/**
     * 从JDBC ResultSet读取数据,将其转换为自定义类型后返回
     * (此方法要求对可能出现null值进行处理)
     * names中包含了当前自定义类型的映射字段名称
     *
     * @param names
     * @param owner
     * @return
     * @throws org.hibernate.HibernateException
     * @throws java.sql.SQLException
     */
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		
		String columnName = names[0];
        String columnValue = rs.getString( columnName );

		if(null == columnValue || "".equals(columnValue)){
			return newCollection();
		}
		
		String[] values = columnValue.split(separator);

        Collection result = newCollection();

        for (String value : values) {
            if(!"".equals(value)) {
                result.add(elementType.cast(value));
            }
        }
        return result;
		
	}

	 private Collection newCollection() {
	        try {
	            return (Collection) collectionType.newInstance();
	        } catch (Exception e) {
	            throw new HibernateException(e);
	        }
	    }
    /**
     * 本方法将在Hibernate进行数据保存时被调用
     * 我们可以通过PreparedStateme将自定义数据写入到对应的数据库表字段
     */
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {

		String valueStr = "";
        if (value != null) {
        	Collection values = (Collection) value;
        	for(Object v:values ){
        		valueStr += (v + separator);
        	}
        }
        st.setString(index, valueStr);
	}
	
	public Object deepCopy(Object value) throws HibernateException {
		if (value == null) return null;
        Collection copyCollection = newCollection();
        copyCollection.addAll((Collection) value);
        return copyCollection;
	}

	public boolean isMutable() {
		 return true;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return ((Serializable) value);
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		 return cached;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		 return original;
	}

}
