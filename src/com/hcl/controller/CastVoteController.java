package com.hcl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.DAO.CastVoteDAO;
import com.hcl.model.VoterDetails;


@WebServlet("/CastVoteController")
public class CastVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CastVoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String voterId = request.getParameter("voterId");
		String voterName = request.getParameter("voterName");
		double age = Double.parseDouble(request.getParameter("age"));
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");
		String candidateName = request.getParameter("candidateName");
		
		VoterDetails voter = new VoterDetails();
		voter.setVoterId(voterId);
		voter.setVoterName(voterName);
		voter.setAge(age);
		voter.setEmail(email);
		voter.setPhoneNo(phoneNo);
		voter.setCandidateName(candidateName);
		
		CastVoteDAO castVoteDAO = new CastVoteDAO();
		castVoteDAO.connecToDB();
		castVoteDAO.insertValues(voter);
		/*List<Integer> list = castVoteDAO.updateValues(voter);
		
		RequestDispatcher rd = request.getRequestDispatcher("DisplayResults.jsp");
		rd.forward(request, response);	
		request.setAttribute("Result",list );*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
