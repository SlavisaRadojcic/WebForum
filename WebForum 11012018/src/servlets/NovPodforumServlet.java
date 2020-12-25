package servlets;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.io.OptionalDataException;

import beans.Podforum;
import podaci.Podforumi;


/**
 * Servlet implementation class NovPodforumServlet
 */
@WebServlet("/NovPodforumServlet")
public class NovPodforumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovPodforumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String poruka="";
		if (Podforumi.sacuvajPodforumPocetak()){
			poruka="Fajl sa podforumima je napravljen";
			System.out.println("sacuvan spisak");}
		else {
			poruka="Fajl sa podforumima nije napravljen";
			System.out.println("nije sacuvan spisak");
		}
		RequestDispatcher rd=null;
		request.setAttribute("porukapodforumi", poruka);
		rd=request.getRequestDispatcher("/forum.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		}
	  
			
			
			
						        
									

				

		
		
		
		
	}


