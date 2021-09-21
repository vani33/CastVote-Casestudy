package com.hcl.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcl.model.VoterDetails;

public class CastVoteDAO {

	static Connection connection;
	public  void connecToDB(){
	String url = "jdbc:mysql://localhost:3306/hibernate";
	String userName = "root";
	String password ="root";
	try{

	  Class.forName("com.mysql.jdbc.Driver");
	  connection = DriverManager.getConnection(url,userName,password);
	  System.out.println("connection successful");
	}
	catch(Exception e){
		System.out.println(e.getMessage());

	 }
}

	 public void insertValues(VoterDetails voter){

	 try{

	  String insertTableSQL="INSERT INTO candidateResults(voterId,voterName,age,email,phoneNo,candidateName) values(?,?,?,?,?,?)";
	  PreparedStatement preparedStatement=connection.prepareStatement(insertTableSQL);
	  preparedStatement.setString(1,voter.getVoterId());
	  preparedStatement.setString(2,voter.getVoterName());
	  preparedStatement.setDouble(3,voter.getAge());
	  preparedStatement.setString(4,voter.getEmail());
	  preparedStatement.setString(5,voter.getPhoneNo());
	  preparedStatement.setString(6,voter.getCandidateName());
	  preparedStatement.executeUpdate();
	  System.out.println("record inserted");
	  Statement stmt1= connection.createStatement();

	  //System.out.println(voter.getCandidateName());
	  String query = "UPDATE candidate " + "SET noOfVotes = noOfVotes+1 WHERE candidateName='"+voter.getCandidateName()+ "'";
	  stmt1.executeUpdate(query); 
	  String query1 = "UPDATE candidate " + "SET percentageOfVotes= percentageOfVotes+4 WHERE candidateName='"+voter.getCandidateName()+ "'";
	  stmt1.executeUpdate(query1); 

	 }
	 catch(Exception e){
		 System.out.println(e.getMessage());

	 }
	 }
	 
	 /*public VoterDetails selectValues() {
		    
		 VoterDetails  voter1 = new VoterDetails();
	        
		 String query = "select * from candidateResults";
		    try
		    {
		      Statement st = connection.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        String voterId = rs.getString(1);
		        String voterName = rs.getString(2);
		        Double age = rs.getDouble(3);
		        String email = rs.getString(4);
		        String phoneNo = rs.getString(5);
		        String candidateName = rs.getString(6);
		        voter1.setVoterId(voterId);
		        voter1.setVoterName(voterName);
		        voter1.setAge(age);
		        voter1.setEmail(email);
		        voter1.setPhoneNo(phoneNo);
		        voter1.setCandidateName(candidateName);
		        
		     }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		    return voter1;
		  }*/
	 
 }
	 

	      

		

