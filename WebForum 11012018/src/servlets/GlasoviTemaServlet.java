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
 * Servlet implementation class GlasoviTemaServlet
 */
@WebServlet("/GlasoviTemaServlet")
public class GlasoviTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlasoviTemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n="";
		String x="";
		String np="";
		int idteme=0;
		String username="";
		int y=0;
		if(request.getParameter("naslovteme")!=null)n=request.getParameter("naslovteme");
		if(request.getParameter("glas")!=null)x=request.getParameter("glas");
		if(request.getParameter("naziv")!=null)np=request.getParameter("naziv");
		if(request.getParameter("username")!=null)username=request.getParameter("username");
		if(request.getParameter("idteme")!=null)idteme=Integer.parseInt(request.getParameter("idteme"));

		ArrayList<User> spisakkorisnika=new ArrayList<User>();
		spisakkorisnika=Authenticator.spisakKorisnika();
		ArrayList<Integer>pozitivni=new ArrayList<Integer>();
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
		pozitivni=spisakkorisnika.get(br).getPozitivniteme();
		pozitivni.add(idteme);
		spisakkorisnika.get(br).setPozitivniteme(pozitivni);
		System.out.println("glasovi korisnika "+ spisakkorisnika.get(br).getPozitivniteme());
		Authenticator.sacuvajIzmene(spisakkorisnika);
		
		request.getSession().setAttribute("user", spisakkorisnika.get(br));
		
		PrintWriter pw=response.getWriter();
		y=Integer.parseInt(x);
		pw.println(n);
		pw.println("glas je "+ y);
		ArrayList<Tema>spisak=new ArrayList<Tema>();
		spisak=Teme.spisakTema();
		nadjen=false;
		i=0;
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getNaslovteme().equalsIgnoreCase(n)) {
				spisak.get(i).setPozitivni(spisak.get(i).getPozitivni()+1);
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
