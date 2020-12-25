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
 * Servlet implementation class SacuvajKomentarServlet
 */
@WebServlet("/SacuvajKomentarServlet")
public class SacuvajKomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajKomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String n="";
		String komtekst="";
		int id=0;	
		if(request.getParameter("naslovteme")!=null)n=request.getParameter("naslovteme");
		if(request.getParameter("idkomentara")!=null) id=Integer.parseInt(request.getParameter("idkomentara"));
		if(request.getParameter("tekstkomentara")!=null)komtekst=request.getParameter("tekstkomentara");
		
		String ime="";
		String errMessage="";
	
		if(request.getParameter("user")!=null) ime=request.getParameter("user");
		ArrayList<User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
		ArrayList<String>kom=new ArrayList<String>();
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
			kom=spisak.get(br).getSacuvanikomentari();
			kom.add(komtekst);
			spisak.get(br).setSacuvanikomentari(kom);
			Authenticator.sacuvajIzmene(spisak);
			errMessage="Komentar  je sacuvan";
		}
		else {
			errMessage="Komentar nije sacuvan";
		}
		RequestDispatcher rd = null;
		request.setAttribute("errMessage",errMessage);
		rd = request.getRequestDispatcher("ListaKomentara");
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
