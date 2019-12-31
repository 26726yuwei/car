package com.oracle.cars.model;
/**
 * @author Administrator
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CarDAO {

	public  List<Car>  listAll(){
		List<Car>  cars=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars3", "root", "root");
			QueryRunner run = new QueryRunner();
			ResultSetHandler<List<Car>> h = new BeanListHandler<Car>(Car.class);
			cars= run.query(connection,"SELECT * FROM car", h);
		} catch (Exception e) {
			cars=new ArrayList<>();
			e.printStackTrace();
		}
		return cars;
	}
	/**
	 * 这是删除车辆信息的dao方法
	 * @param carid
	 * @return
	 */
	public boolean  deleteCar(int carid) {
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars3", "root", "root");
			QueryRunner run = new QueryRunner();
			 int count=run.update(connection, "delete from car where carid=?",carid);
			 result=count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean  addCar(Car c) {
		boolean result=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars3", "root", "root");
			QueryRunner run = new QueryRunner();
			 int count=run.update(connection, "insert into(pinpaiming,xilie,gonglishu,yanse,shoujia) car(?,?,?,?,?)",c.getPinpaiming(),c.getXielie(),c.getGonglishu(),c.getYanse(),c.getShoujia());
			 result=count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
