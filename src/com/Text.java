package com;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Text {
	private static String username1;
	private static String pwd1;
	public void tianjia(String username2,String pwd2){
		Connection con=null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("创建成功");
				con=(Connection) DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
				System.out.println("成功连接connection");
				Statement sta=(Statement) con.createStatement();
				int n=sta.executeUpdate("insert student values('"+username2+"','"+pwd2+"')");
				if(n>0){
					System.out.println("插入成功");
				}
			
			}catch(ClassNotFoundException e){
				System.out.println("没有找到");
			}catch(SQLException e){
				System.out.println("连接失败");
			}
	}
	
	
	public static void main(String[] args){
		Text a=new Text();
		System.out.println(a.panduan(username1, pwd1));
		
	}
	
	public boolean panduan(String username1,String pwd1){
		Connection con=null;
		
		try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("创建成功");
				con=(Connection) DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
				System.out.println("成功连接connection");
				Statement sta=(Statement) con.createStatement();

				ResultSet n=sta.executeQuery("select * from student");
				if(n.next()){
					String user=n.getString(1);
					String pwds=n.getString(2);
					if(user==username1&&pwds==pwd1){
						return true;
					}else{
						return false;
					}		
				}
				
			}catch(ClassNotFoundException e){
				System.out.println("没有找到");
				return false;
			}catch(SQLException e){
				System.out.println("连接失败");
				return false;
			}
			return true;
	}
}
