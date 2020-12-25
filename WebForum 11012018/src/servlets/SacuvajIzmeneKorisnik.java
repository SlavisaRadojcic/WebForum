package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import podaci.Authenticator;

/**
 * Servlet implementation class SacuvajIzmeneKorisnik
 */
@WebServlet("/SacuvajIzmeneKorisnik")
public class SacuvajIzmeneKorisnik extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajIzmeneKorisnik() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String novauloga="";
		String username="";
		if(request.getParameter("novauloga")!=null) novauloga=request.getParameter("novauloga");
		if(request.getParameter("username")!=null) username=request.getParameter("username");
		ArrayList<User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
	boolean	nadjen=false;
		int i=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getUsername().equalsIgnoreCase(username)) {
				nadjen=true;
				spisak.get(i).setUloga(novauloga);
				
			}
			i++;
		}
		String msg="";
		if(nadjen) {
			Authenticator.sacuvajIzmene(spisak);
			msg="Izmene su sacuvane.";
		}
		else {
			msg="doslo je do greske, izmene nisu sacuvane.";
		}
		//PrintWriter printWriter = response.getWriter();
		//printWriter.print(msg);
		RequestDispatcher rd = null;
		request.setAttribute("errMessage",msg);
		rd = request.getRequestDispatcher("ListaKorisnika");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
