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

import beans.Tema;
import podaci.Teme;

/**
 * Servlet implementation class SacuvajIzmeneTemaServlet
 */
@WebServlet("/SacuvajIzmeneTemaServlet")
public class SacuvajIzmeneTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajIzmeneTemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String nazivtm="";
		String novnazivtm="";
		if(request.getParameter("naslovteme")!=null) nazivtm=request.getParameter("naslovteme");
		if(request.getParameter("novnaslovteme")!=null) novnazivtm=request.getParameter("novnaslovteme");
		ArrayList <Tema> spisak=new ArrayList<Tema>();
		spisak=Teme.spisakTema();
		boolean nadjen=false;
		int i=0;
		int br=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getNaslovteme().equalsIgnoreCase(nazivtm)) {
				nadjen=true;
				br=i;
				spisak.get(i).setNaslovteme(novnazivtm);
				}
			i++;
		}
		
		String msg="";
	if (nadjen) {
	Teme.sacuvajSpisak(spisak);
	msg="Izmene su sacuvane";
		}
		else {
			msg="Doslo je do greske izmene nisu sacuvane.";
		}
	PrintWriter printWriter = response.getWriter();
	printWriter.print(msg);
	RequestDispatcher rd = null;
	request.setAttribute("errMessage",msg);
	rd = request.getRequestDispatcher("ListaTema");
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
