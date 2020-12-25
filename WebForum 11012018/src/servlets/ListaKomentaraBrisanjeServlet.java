package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Komentar;
import podaci.Komentari;

/**
 * Servlet implementation class ListaKomentaraBrisanjeServlet
 */
@WebServlet("/ListaKomentaraBrisanjeServlet")
public class ListaKomentaraBrisanjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaKomentaraBrisanjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String n="";		
		
		if(request.getParameter("naslovteme")!=null)n=request.getParameter("naslovteme");
	
		
		System.out.println("naslov teme u servletu lista komentara je: "+n);
		ArrayList<Komentar> spisak=new ArrayList<Komentar>();
		ArrayList<Komentar> odabrani=new ArrayList<Komentar>();
		
		Komentar x=new Komentar();
		spisak=Komentari.spisakKomentara();
		if(!n.equals("")) {
			for(int i=0;i<spisak.size();i++) {
				x=spisak.get(i);
				if(x.getTema().equals(n))
					
					odabrani.add(x);
				
			}}
			else odabrani=spisak;
			request.setAttribute("spisakKomentara", odabrani);
			RequestDispatcher rd=null;
			rd=request.getRequestDispatcher("/adminkomentara.jsp");
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
