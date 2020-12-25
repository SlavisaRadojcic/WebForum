package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tema;
import podaci.Teme;

/**
 * Servlet implementation class ListaTemaServlet
 */
@WebServlet("/ListaTemaServlet")
public class ListaTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaTemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n="";
		if(request.getParameter("naziv")!=null)n=request.getParameter("naziv");
		System.out.println("naziv iz lista tema servleta"+ n);
		ArrayList<Tema> spisak=new ArrayList<Tema>();
		ArrayList<Tema> odabrane=new ArrayList<Tema>();
		Tema x=new Tema();
		spisak=Teme.spisakTema();
		if(!n.equals("")) {
		for(int i=0;i<spisak.size();i++) {
			x=spisak.get(i);
			if(x.getPodforum().equals(n))
				odabrane.add(x);
			
		}}
		else odabrane=spisak;
		request.setAttribute("spisakTema", odabrane);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("/pregledTema.jsp");
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
