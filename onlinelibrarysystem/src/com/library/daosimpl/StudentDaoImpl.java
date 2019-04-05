package com.library.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.library.daos.StudentDao;
import com.library.models.Student;
import com.library.utility.ConnectionProvider;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean registerStudent(Student StudObj) {
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into studenttab values(?,?,?,?,?,?)");
			ps.setString(1,StudObj.getEmail());
			ps.setString(2,StudObj.getPassword());
			ps.setString(3,StudObj.getFirstName());
			ps.setString(4,StudObj.getLastName());
			ps.setString(5,StudObj.getGender());
			
			/*Converting java.util.Date into java.sql.Date*/
			Date dateOfBirth=StudObj.getDateOfBirth();
			long l=dateOfBirth.getTime();
			java.sql.Date dob=new java.sql.Date(l);
			ps.setDate(6, dob);
			
			int i=ps.executeUpdate();
			if(i!=0){
				PreparedStatement p1=conn.prepareStatement("insert into login values(?,?,?)");
				p1.setString(1,StudObj.getEmail());
				p1.setString(2,StudObj.getPassword());
				p1.setString(3,"user");
				int i1=p1.executeUpdate();
				if(i1!=0)
				{
				return true;
			}}
			else {
				return false;
			}}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public Student getUser(String email) {
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from studenttab where email=?");
			ps.setString(1,email);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			  Student stud=new Student();
			  stud.setEmail(rs.getString(1));
			  stud.setPassword(rs.getString(2));
			  stud.setFirstName(rs.getString(3));
			  stud.setLastName(rs.getString(4));
			  stud.setGender(rs.getString(5));
			  
			  String date=rs.getString(6);
			  
			  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");
			  java.util.Date d=sdf.parse(date);
			  stud.setDateOfBirth(d);
			  
			  return stud;		  
			  
			}
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean updateStudent(Student StudObj) {
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update studenttab set password=?,firstname=?,lastname=?,gender=?,dob=? where email=?");
			ps.setString(1,StudObj.getPassword());
			ps.setString(2,StudObj.getFirstName());
			ps.setString(3,StudObj.getLastName());
			ps.setString(4,StudObj.getGender());
			ps.setString(6,StudObj.getEmail());
						
			Date dateOfBirth=StudObj.getDateOfBirth();
			long l=dateOfBirth.getTime();
			java.sql.Date dob=new java.sql.Date(l);
			ps.setDate(5,dob);
			
			int i=ps.executeUpdate();
			if(i!=0){
				return true;
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean changePassword(String email, String newPassword,String ConfirmPassword) {
		
		try {
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("update studenttab set Password=? where email=?");
			ps.setString(1,newPassword);
			ps.setString(2,email);
			int i=ps.executeUpdate();
			if(i!=0){
				PreparedStatement p1=conn.prepareStatement("insert into login values(?)");
				ps.setString(1,newPassword);
				int i1=ps.executeUpdate();
				if(i1!=0)
				{
				 p1.setString(1,newPassword);
				return true;
				}}
			else {
				return false;
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}			
		return false;
	}
}
