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
 * Servlet implementation class IzmenaTemaServlet
 */
@WebServlet("/IzmenaTemaServlet")
public class IzmenaTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaTemaServlet() {
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
		String nazivpf="";
		if(request.getParameter("naslovteme")!=null) nazivtm=request.getParameter("naslovteme");
		if(request.getParameter("naziv")!=null) nazivpf=request.getParameter("naziv");
		ArrayList <Tema> spisak=new ArrayList<Tema>();
		spisak=Teme.spisakTema();
		boolean nadjen=false;
		int i=0;
		int br=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getNaslovteme().equalsIgnoreCase(nazivtm)) {
				nadjen=true;
				br=i;
				}
			i++;
		}
		String msg="";
		Tema t1=new Tema();
		if (nadjen) {
	
	t1=spisak.get(br);
	msg="Mozete izmeniti naziv teme.";
		}
		else {
			msg="Nije pronadjena tema sa datim nazivom.";
		}
		request.setAttribute("naziv", nazivpf);
		request.setAttribute("tema", t1);
		request.setAttribute("errMessage",msg);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("/izmenaTema.jsp");
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
