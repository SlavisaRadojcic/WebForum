package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import podaci.Authenticator;

/**
 * Servlet implementation class IzmenaKorisnikaServlet
 */
@WebServlet("/IzmenaKorisnikaServlet")
public class IzmenaKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaKorisnikaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String username="";
	if(request.getParameter("username")!=null) username=request.getParameter("username");
	ArrayList<User> spisak=new ArrayList<User>();
	spisak=Authenticator.spisakKorisnika();
	boolean nadjen=false;
	int i=0;
	User u=new User();
	while(!nadjen &&  i<spisak.size()) {
		if(spisak.get(i).getUsername().equalsIgnoreCase(username)) {
			nadjen=true;
			u=spisak.get(i);
		}
		i++;
	}
	String msg="";
	if(nadjen) {
		msg="mozete izmeniti podatke o korisniku.";
	}
	else {
		msg="doslo je do greske, podaci nisu pronadjeni.";
	}
	request.setAttribute("username", username);
	request.setAttribute("userizmena", u);
	request.setAttribute("errMessage",msg);
	RequestDispatcher rd=null;
	rd=request.getRequestDispatcher("/izmenaKorisnika.jsp");
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
