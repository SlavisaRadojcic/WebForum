package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import beans.Komentar;
import beans.User;
import podaci.Authenticator;
import podaci.Komentari;

/**
 * Servlet implementation class GlasoviPozitivniKomentar
 */
@WebServlet("/GlasoviPozitivniKomentar")
public class GlasoviPozitivniKomentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlasoviPozitivniKomentar() {
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
		System.out.println("ime korisnika koji je glasao je : "+ username);
		ArrayList <User> korisnici=new ArrayList<User>();
		ArrayList<Integer> pozitivnikomentari=new ArrayList<Integer>();
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
			pozitivnikomentari=korisnici.get(br).getPozitivnikomentari();
			pozitivnikomentari.add(id);
			korisnici.get(br).setPozitivnikomentari(pozitivnikomentari);
			Authenticator.sacuvajIzmene(korisnici);
			//errMessage="pozititvan glas  je sacuvan";
		}
		else {
			//errMessage="Pozitivan glas nije sacuvan";
		}
		
		request.getSession().setAttribute("user", korisnici.get(br));
		
		ArrayList <Komentar> spisak=new ArrayList<Komentar>();
		spisak=Komentari.spisakKomentara();
		nadjen=false;
		i=0;
		br=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getIdkomentara()==id) {
				nadjen=true;
				br=spisak.get(i).getPozitivniglasovi()+1;
				spisak.get(i).setPozitivniglasovi(br);
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
