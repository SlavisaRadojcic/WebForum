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
 * Servlet implementation class ObrisatiKomentarServlet
 */
@WebServlet("/ObrisatiKomentarServlet")
public class ObrisatiKomentarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObrisatiKomentarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String naslovteme="";		
		int idkomentara=0;
		if(request.getParameter("naslovteme")!=null)naslovteme=request.getParameter("naslovteme");
		if(request.getParameter("idkomentara")!=null) idkomentara=Integer.parseInt(request.getParameter("idkomentara"));
		System.out.println("komentar koji treba da se brise: "+idkomentara);
		System.out.println("njegova tema je: "+naslovteme);
		ArrayList<Komentar> spisak=new ArrayList<Komentar>();
		spisak=Komentari.spisakKomentara();
		int i=0;
		boolean nadjen=false;
		while(i<spisak.size()&&!nadjen) {
			if(spisak.get(i).getIdkomentara()==idkomentara) {
				spisak.get(i).setObrisan(!spisak.get(i).isObrisan());
				nadjen=true;
			}
			i++;
		}
		Komentari.sacuvajKomentare(spisak);
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("ListaKomentaraBrisanje");
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
