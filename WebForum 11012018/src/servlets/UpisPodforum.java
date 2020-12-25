package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import beans.Podforum;
import beans.Tema;
import podaci.Podforumi;
import podaci.Teme;

/**
 * Servlet implementation class UpisPodforum
 */
@WebServlet("/UpisPodforum")
public class UpisPodforum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpisPodforum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*Podforum p1=new Podforum("Servleti","Cemu sluze i kako funkcionisu","java.jpg","Pera");
		Podforum p2=new Podforum("JSP","Java Server Pages","java1.jpg","Lepa");*/
				
		ArrayList<Podforum> spisak=new ArrayList<Podforum>();
		spisak=Podforumi.listapodforuma();
		int maxid=Podforumi.maxid(spisak)+1;
		String msg="";
		String fajl;
		MultipartRequest m=new MultipartRequest(request,"c:/new/slike");
		//fajl=m.getFilesystemName("ikonica");
		//System.out.println("pokusaj da se procita ime fajla "+fajl);
		//fajl=m.getParameter("naziv");
		//System.out.println("pokusaj da se procita ime posta koje je prosldjen "+fajl);
		System.out.println("ovoo je get metoda za upis podforuma");
		if(m.getParameter("naziv")!=null) {
			//MultipartRequest m=new MultipartRequest(request,"c:/new/slike");
			Podforum p=new Podforum();
			p.setIdpodforuma(maxid);
			p.setNaziv(m.getParameter("naziv"));
			p.setOpis(m.getParameter("opis"));
			fajl=m.getFilesystemName("ikonica");
			System.out.println(fajl);
			p.setIkonica(fajl);
			p.setOdgovornimoderator(m.getParameter("odgovornimoderator"));
		
			PrintWriter printWriter = response.getWriter();
		
			if(!Podforumi.podforumProvera(p, spisak)) {
		
				if(Podforumi.sacuvajPodforum(p, spisak)) {
					printWriter.print("Podforum je sacuvana");
					msg="Podforum je dodati u spisak";
				}
		
				else { printWriter.print("Podforum nije sacuvan");
				msg="podforum nije sacuvan, doslo je do greske.";
				}		}
		else {
			//podforum takvog imena postoji
			msg="vec postoji podforum sa predlozenim imenom.";
		}
		
		}
		else {
			System.out.println(request.getParameter("naziv"));
		}
			
			
			RequestDispatcher rd = null;
			request.setAttribute("errMessage",msg);
			rd = request.getRequestDispatcher("ListaPodforuma");
			rd.forward(request, response);

	


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("ovo je post metoda za upis");
	}

}
