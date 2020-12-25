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
import beans.User;
import podaci.Authenticator;
import podaci.Teme;

/**
 * Servlet implementation class GlasoviNegativniTema
 */
@WebServlet("/GlasoviNegativniTema")
public class GlasoviNegativniTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlasoviNegativniTemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n="";
		String np="";
		int idteme=0;
		String username="";
		int y=0;
		if(request.getParameter("naslovteme")!=null)n=request.getParameter("naslovteme");
		if(request.getParameter("naziv")!=null)np=request.getParameter("naziv");
		if(request.getParameter("username")!=null)username=request.getParameter("username");
		if(request.getParameter("idteme")!=null)idteme=Integer.parseInt(request.getParameter("idteme"));

		ArrayList<User> spisakkorisnika=new ArrayList<User>();
		spisakkorisnika=Authenticator.spisakKorisnika();
		ArrayList<Integer>negativni=new ArrayList<Integer>();
		boolean nadjen=false;
		int i=0;
		int br=-1;
		while(!nadjen && i<spisakkorisnika.size()) {
			if(spisakkorisnika.get(i).getUsername().equalsIgnoreCase(username)) {
				nadjen=true;
				 br=i;
			}
			i++;
		}
		negativni=spisakkorisnika.get(br).getNegativniteme();
		negativni.add(idteme);
		spisakkorisnika.get(br).setNegativniteme(negativni);
		System.out.println("negativni glasovi korisnika "+ spisakkorisnika.get(br).getNegativniteme());
		Authenticator.sacuvajIzmene(spisakkorisnika);
		
		request.getSession().setAttribute("user", spisakkorisnika.get(br));
		
		PrintWriter pw=response.getWriter();
		pw.println(n);
		pw.println("glas je "+ y);
		ArrayList<Tema>spisak=new ArrayList<Tema>();
		spisak=Teme.spisakTema();
		nadjen=false;
		i=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getNaslovteme().equalsIgnoreCase(n)) {
				spisak.get(i).setNegativni(spisak.get(i).getNegativni()+1);
				nadjen=true;
				pw.println("nadjena tema je "+spisak.get(i).getNaslovteme());
			}
			i++;
		}
		
		Teme.sacuvajSpisak(spisak);
		spisak=Teme.spisakTema();
		System.out.println("naziv iz glasovi tema servleta"+ np);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("ListaTemaServlet");
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
