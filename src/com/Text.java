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
				System.out.println("�����ɹ�");
				con=(Connection) DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
				System.out.println("�ɹ�����connection");
				Statement sta=(Statement) con.createStatement();
				int n=sta.executeUpdate("insert student values('"+username2+"','"+pwd2+"')");
				if(n>0){
					System.out.println("����ɹ�");
				}
			
			}catch(ClassNotFoundException e){
				System.out.println("û���ҵ�");
			}catch(SQLException e){
				System.out.println("����ʧ��");
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
				System.out.println("�����ɹ�");
				con=(Connection) DriverManager.getConnection
						("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
				System.out.println("�ɹ�����connection");
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
				System.out.println("û���ҵ�");
				return false;
			}catch(SQLException e){
				System.out.println("����ʧ��");
				return false;
			}
			return true;
	}
}
