package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import podaci.Komentari;

/**
 * Servlet implementation class UpisKomentarPocetakServlet
 */
@WebServlet("/UpisKomentarPocetakServlet")
public class UpisKomentarPocetakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpisKomentarPocetakServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String poruka="";
		if (Komentari.sacuvajKomentarPocetak()) {
	System.out.println("fajl sa komentarima je napravljen");	
	poruka="fajl sa komentarima je napravljen";
	}
	else {
		System.out.println("fajl sa komentarima nije napravljen");	
		poruka="fajl sa komentarima nije napravljen";
	}
		RequestDispatcher rd=null;
		request.setAttribute("porukakomentari", poruka);
		rd=request.getRequestDispatcher("/forum.jsp");
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
