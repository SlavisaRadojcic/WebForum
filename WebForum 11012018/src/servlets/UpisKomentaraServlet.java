package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Komentar;

import podaci.Komentari;

/**
 * Servlet implementation class UpisKomentaraServlet
 */
@WebServlet("/UpisKomentaraServlet")
public class UpisKomentaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpisKomentaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Komentar k2=new Komentar("Kako funkcionisu servleti","Pera",4,1,"posebno su interesantni HttpServleti");
		String poruka="";
		Komentar k1=new Komentar();
		k1.setAutor(request.getParameter("autor"));
		k1.setTekstkomentara(request.getParameter("tekstkomentara"));
		k1.setTema(request.getParameter("naslovteme"));
		k1.setRoditeljskikomentar(Integer.parseInt(request.getParameter("roditeljskikomentar")));
		
		
		
		ArrayList<Komentar> spisak=new ArrayList<Komentar>();
		spisak=Komentari.spisakKomentara();
		
		int id;
		id= Komentari.maxid(spisak)+1;
		k1.setIdkomentara(id);
	
		System.out.println("komentar koji ce biti sacuvan: "+k1.getAutor()+","+k1.getIdkomentara()+","+k1.getTema()+","+k1.getTekstkomentara());
		spisak.add(k1);
		
		if(Komentari.sacuvajKomentare(spisak)) {
			System.out.println("nov komentar je sacuvan");
			poruka="Hvala na ucesu u diskusiji, komentar je sacuvan.";
		}
		else {
			System.out.println("nov komentar nije sacuvan");
			poruka="Komentar nije sacuvan, doslo je do greske.";
		}
		
		
		RequestDispatcher rd=null;
		request.setAttribute("errMessage",poruka);
	    rd=request.getRequestDispatcher("/upisankomentar.jsp");
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
