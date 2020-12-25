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
 * Servlet implementation class KorisnikServlet
 */
@WebServlet("/KorisnikServlet")
public class KorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KorisnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String ime="";
		if(request.getParameter("ime")!=null)ime=request.getParameter("ime");
		System.out.println("naziv iz lista tema servleta"+ ime);
		ArrayList <User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
		User k1=new User();
		int i=0;
		while(i<spisak.size()) {
			if(spisak.get(i).getUsername().equals(ime)) {
				k1=spisak.get(i);
			}
			i++;
		}
		
		
		request.setAttribute("korisnik", k1);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/profilkorisnika.jsp");
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
