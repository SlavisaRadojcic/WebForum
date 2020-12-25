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
 * Servlet implementation class SacuvajPodforumServlet
 */
@WebServlet("/SacuvajPodforumServlet")
public class SacuvajPodforumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajPodforumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nazivpf="";
		String ime="";
		String errMessage="";
		if(request.getParameter("naziv")!=null) nazivpf=request.getParameter("naziv");
		if(request.getParameter("user")!=null) ime=request.getParameter("user");
		ArrayList<User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
		ArrayList<String>pf=new ArrayList<String>();
		boolean nadjen=false;
		int i=0;
		int br=-1;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getUsername().equalsIgnoreCase(ime)) {
				nadjen=true;
				 br=i;
			}
			i++;
		}
		if(nadjen) {
			pf=spisak.get(br).getSacuvanipodforumi();
			pf.add(nazivpf);
			spisak.get(br).setSacuvanipodforumi(pf);
			Authenticator.sacuvajIzmene(spisak);
			errMessage="Podforum je sacuvan";
		}
		else {
			errMessage="Podforum nije sacuvan";
		}
		RequestDispatcher rd = null;
		request.setAttribute("errMessage",errMessage);
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
