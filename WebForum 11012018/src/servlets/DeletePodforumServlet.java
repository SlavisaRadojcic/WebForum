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
import beans.Podforum;
import podaci.Komentari;
import podaci.Podforumi;

/**
 * Servlet implementation class DeletePodforumServlet
 */
@WebServlet("/DeletePodforumServlet")
public class DeletePodforumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePodforumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nazivpf="";
		if(request.getParameter("nazivpodforuma")!=null) nazivpf=request.getParameter("nazivpodforuma");
		ArrayList <Podforum> spisak=new ArrayList<Podforum>();
		spisak=Podforumi.listapodforuma();
		boolean nadjen=false;
		int i=0;
		int br=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getNaziv().equalsIgnoreCase(nazivpf)) {
				nadjen=true;
				br=i;
				}
			i++;
		}
		spisak.remove(br);
		String msg="";
		if(Podforumi.sacuvajSpisakPodforum(spisak)) {
			msg="Podforum je obrisan";
		}
		
		else { 
		msg="doslo je do greske podforum nije obrisan.";
		}
		
		
				
			
			
			RequestDispatcher rd = null;
			request.setAttribute("errMessage",msg);
			rd = request.getRequestDispatcher("ListaPodforuma");
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
