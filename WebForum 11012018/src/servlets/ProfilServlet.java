package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import beans.Komentar;
import beans.User;
import podaci.Authenticator;
import podaci.Komentari;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String username="Pera";
		String password="123";
	
	if(request.getParameter("username")!=null)username=request.getParameter("username");
	if(request.getParameter("password")!=null)password=request.getParameter("password");
	//System.out.println(password);
	//RequestDispatcher rd = null;
	
	//Authenticator authenticator = new Authenticator();
	User user = new User();
	ArrayList<User> spisak=new ArrayList<User>();
	spisak=Authenticator.spisakKorisnika();
	user=Authenticator.Provera(username, password,spisak);
	//System.out.println(user.getIme());
	
	String json = new Gson().toJson(user);
	//System.out.println("\n\n"+"JSON ARRAY is :  "+json);
   // response.setContentType("application/json");
    //response.setCharacterEncoding("UTF-8");
    //response.getWriter().print(json);*/
		
		int br=0;
		
		String x;
		x=String.valueOf(br);
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(json); 
	
	  

		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
