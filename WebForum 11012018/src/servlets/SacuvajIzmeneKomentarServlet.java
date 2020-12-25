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

import beans.Komentar;
import beans.Tema;
import podaci.Komentari;
import podaci.Teme;

/**
 * Servlet implementation class SacuvajIzmeneKomentarServlet
 */
@WebServlet("/SacuvajIzmeneKomentarServlet")
public class SacuvajIzmeneKomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajIzmeneKomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idkomentara=0;
		String tekstkomentara="";
		if(request.getParameter("idkomentara")!=null) idkomentara=Integer.parseInt(request.getParameter("idkomentara"));
		if(request.getParameter("tekstkomentara")!=null) tekstkomentara=request.getParameter("tekstkomentara");
		ArrayList <Komentar> spisak=new ArrayList<Komentar>();
		
		spisak=Komentari.spisakKomentara();
		boolean nadjen=false;
		int i=0;
		int br=0;
		String naslovteme="";
		while(!nadjen && i<spisak.size()) {
			if(spisak.get(i).getIdkomentara()==idkomentara) {
				nadjen=true;
				br=i;
				spisak.get(i).setTekstkomentara(tekstkomentara);
				spisak.get(i).setIzmenjen(true);
				naslovteme=spisak.get(i).getTema();
				//System.out.println("ovo je naslov teme za pronadjeni komentar"+spisak.get(i).getTema());
				}
			i++;
		}
	
		String msg="";
	if (nadjen) {
		Komentari.sacuvajKomentare(spisak);
   	msg="Izmene su sacuvane";
		}
		else {
			msg="Doslo je do greske izmene nisu sacuvane.";
		}
	PrintWriter printWriter = response.getWriter();
	printWriter.print(msg);
	RequestDispatcher rd = null;
	request.setAttribute("errMessage",msg);
	request.setAttribute("naslovteme",naslovteme);
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
