package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import podaci.Podforumi;
import podaci.Teme;

/**
 * Servlet implementation class TemaServletPocetak
 */
@WebServlet("/TemaServletPocetak")
public class TemaServletPocetak extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemaServletPocetak() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String poruka="";
		if (Teme.sacuvajTemuPocetak()){
			System.out.println("sacuvan pocetni spisak tema");
		poruka="fajl sa temama je napravljen";	
		}
		else {
			System.out.println("nije sacuvan  pocetni spisak tema");
			poruka="fajl sa temama nije napravljen";
		}
		RequestDispatcher rd=null;
		request.setAttribute("porukateme", poruka);
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
