package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Komentar;
import beans.User;
import podaci.Authenticator;
import podaci.Komentari;

/**
 * Servlet implementation class GlasoviNegativniKomentar
 */
@WebServlet("/GlasoviNegativniKomentar")
public class GlasoviNegativniKomentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlasoviNegativniKomentar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id=0;
		String username="";
		if(request.getParameter("idkomentara")!=null) id=Integer.parseInt(request.getParameter("idkomentara"));
		if(request.getParameter("username")!=null) username=request.getParameter("username");
		System.out.println("ime korisnika koji je glasao negativno je : "+ username);
		
		ArrayList <Komentar> spisak=new ArrayList<Komentar>();
		spisak=Komentari.spisakKomentara();
		
		ArrayList <User> korisnici=new ArrayList<User>();
		ArrayList<Integer> negativnikomentari=new ArrayList<Integer>();
		korisnici=Authenticator.spisakKorisnika();
		boolean nadjen=false;
		int i=0;
		int br=-1;
		while(!nadjen && i<korisnici.size()) {
			if(korisnici.get(i).getUsername().equalsIgnoreCase(username)) {
				nadjen=true;
				 br=i;
			}
			i++;
		}
		if(nadjen) {
			negativnikomentari=korisnici.get(br).getNegativnikomentari();
			negativnikomentari.add(id);
			korisnici.get(br).setNegativnikomentari(negativnikomentari);
			Authenticator.sacuvajIzmene(korisnici);
			//errMessage="pozititvan glas  je sacuvan";
		}
		else {
			//errMessage="Pozitivan glas nije sacuvan";
		}
		
		request.getSession().setAttribute("user", korisnici.get(br));
		nadjen=false;
		i=0;
		br=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getIdkomentara()==id) {
				nadjen=true;
				br=spisak.get(i).getNegativniglasovi()+1;
				spisak.get(i).setNegativniglasovi(br);
			}
			i++;
		}
		String x;
		x=String.valueOf(br);
		Komentari.sacuvajKomentare(spisak);
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(x); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
