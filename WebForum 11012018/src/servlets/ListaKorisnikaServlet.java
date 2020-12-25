package servlets;

import java.io.IOException;

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
 * Servlet implementation class ListaKorisnikaServlet
 */
@WebServlet("/ListaKorisnikaServlet")
public class ListaKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaKorisnikaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter pw=response.getWriter();
		ArrayList <User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
		
		
		
		request.setAttribute("spisakKorisnika", spisak);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/pregledKorisnika.jsp");
		rd.forward(request, response);
		
		/*for(int i=0;i<spisak.size();i++) {
			System.out.println(spisak.get(i).getUsername());
			System.out.println(spisak.get(i).mojdatum());
			
			//pw.println(spisak.get(i).getUsername());*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
