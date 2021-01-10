package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.New;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



@SuppressWarnings("unchecked")
public class BaseDao<E> {
	
	//获取当前父类泛型的Class
	private Class<E> clazz=null;
	{
		Type genericSuperclass=this.getClass().getGenericSuperclass();
		ParameterizedType paramType=(ParameterizedType)genericSuperclass;
		Type[] typeArguments=paramType.getActualTypeArguments();
		clazz=(Class<E>) typeArguments[0];
		
	}
	
	public void Updata(Connection conn,String sql,Object...args) throws SQLException 
	{
		QueryRunner runner=new QueryRunner();
			runner.update(conn,sql,args);
	}
	
	@SuppressWarnings("rawtypes")
	public List<E> Select(Connection conn,String sql,Object...args) throws SQLException
	{
		QueryRunner runner=new QueryRunner();
		List<E> list=(List<E>) runner.query(conn, sql, new BeanListHandler(clazz), args);
		return list;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public E getInstance(Connection conn,String sql,Object...args) throws SQLException 
	{
		QueryRunner runner=new QueryRunner();
		E stu=(E) runner.query(conn, sql,new BeanHandler(clazz),args);
		
		return stu;
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public List<E> getForList(Connection conn,String sql,Object...args) throws SQLException
	{
		QueryRunner runner=new QueryRunner();
		List<E> stu=(List<E>) runner.query(conn, sql,new BeanListHandler(clazz),args);
		
		return stu;
	
	}
	
	
	
	
}

