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
import podaci.Teme;

/**
 * Servlet implementation class UpisKorisnikServlet
 */
@WebServlet("/UpisKorisnikServlet")
public class UpisKorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpisKorisnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u= new User();
		String greska="";
		//User u=new User("Lepa","456","Dragana","Popović","062765346","lepa@gmail.com");
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setIme(request.getParameter("ime"));
		u.setPrezime(request.getParameter("prezime"));
		u.setEmail(request.getParameter("email"));
		u.setTelefon(request.getParameter("telefon"));
				
		ArrayList<User> spisak=new ArrayList<User>();
		spisak=Authenticator.spisakKorisnika();
		if (!Authenticator.registracijaProvera(u, spisak)) {
			//ne postoji dato korisnicko ime u bazi, korsinik moze da se registruje
		PrintWriter printWriter = response.getWriter();
			if(Authenticator.sacuvajKorisnika(u, spisak)) {
				printWriter.print("Korisnik je sacuvan");
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/uspesnaRegistracija.jsp");
				rd.forward(request, response);
			}
			else {
				greska="doslo je do greske, podaci nisu sacuvani";
				printWriter.print("Krisnik nije sacuvan");
				request.setAttribute("errMessage", greska);
				request.getRequestDispatcher("/registracija.jsp").forward(request, response);
			}
		}
		else {
			greska="doslo je do greske pri registraciji, pokusajte ponovo";
			//korisnik sa tim korisnickim imenom postoji u bazi
			request.setAttribute("errMessage", greska);
			request.getRequestDispatcher("/registracija.jsp").forward(request, response);
		}
	//	response.sendRedirect("ListaKorisnikaServlet");
		//RequestDispatcher rd = null;
		//rd = request.getRequestDispatcher("ListaKorisnikaServlet");
		//rd.
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
