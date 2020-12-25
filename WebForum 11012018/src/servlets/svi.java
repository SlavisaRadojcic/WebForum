package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import beans.Komentar;
import podaci.Komentari;

/**
 * Servlet implementation class svi
 */
@WebServlet("/svi")
public class svi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Komentar> spisak=new ArrayList<Komentar>();
		spisak=Komentari.spisakKomentara();
		Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(spisak, new TypeToken<List<Komentar>>() {}.getType());
		 
		  JsonArray jsonArray = element.getAsJsonArray();
		  String s = jsonArray.toString();
		  System.out.println("\n\n"+"JSON ARRAY is :  "+s);
		  
		  //response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			//response.getWriter().write(json);
		  response.setContentType("application/json");
		  response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
