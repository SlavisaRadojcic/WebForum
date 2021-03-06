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

import com.oreilly.servlet.MultipartRequest;

import beans.Tema;
import podaci.Teme;

/**
 * Servlet implementation class UpisTemeServlet2
 */
@WebServlet("/UpisTemeServlet2")
public class UpisTemeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpisTemeServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("sevlet za upis 2");
		ArrayList<Tema> spisak=new ArrayList<Tema>();
		String poruka="";
		String tip="";
		spisak=Teme.spisakTema();
		int maxid=Teme.maxid(spisak)+1;
		if(request.getParameter("autor")!=null) {
		Tema t1=new Tema();
		tip=request.getParameter("tip");
		if(tip.equalsIgnoreCase("tekst")) {
			t1.setTip("tekst");
			t1.setSadrzajtip(request.getParameter("sadrzajtekst"));
		}
		if(tip.equalsIgnoreCase("link")) {
			t1.setTip("link");
			t1.setSadrzajtip(request.getParameter("sadrzajlink"));
		}
		t1.setPodforum(request.getParameter("naziv"));
		System.out.println("naziv teme je "+ request.getParameter("naziv"));
		t1.setNaslovteme(request.getParameter("naslovteme"));
		t1.setAutor(request.getParameter("autor"));
		t1.setIdteme(maxid);
		
		PrintWriter printWriter = response.getWriter();
		if(!Teme.temeProvera(t1, spisak)) {
			if(Teme.sacuvajTemu(t1,spisak)) {
				printWriter.print("Tema je sacuvana");
				poruka="Nova tema je uspsno sacuvana";
			}
			else {
				printWriter.print("Tema nije sacuvana");
				poruka="Nova tema nije sacuvana, doslo je do greske.";
			}
		}else {
			//vec postoji tema sa datim imenom 
			poruka="Vec postoji tema sa tim nazivom, doslo je do greske pri cuvanju";
		}
		}
		RequestDispatcher rd = null;
		request.setAttribute("errMessage",poruka);
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
