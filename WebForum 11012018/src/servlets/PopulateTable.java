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
 * Servlet implementation class PopulateTable
 */
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int rid=0;
		rid=Integer.parseInt(request.getParameter("roditeljskikomentar"));
		
		ArrayList<Komentar>komentari=new ArrayList<Komentar>();
		ArrayList<Komentar> odabrani=new ArrayList<Komentar>();
		komentari=Komentari.spisakKomentara();
		Komentar x=new Komentar();
		if(rid!=0) {
		for(int i=0;i<komentari.size();i++) {
				x=komentari.get(i);
				if(x.getRoditeljskikomentar()==rid)
					odabrani.add(x);
				
			}}
		else odabrani=komentari;
		
		  Gson gson = new Gson();
		  JsonElement element = gson.toJsonTree(odabrani, new TypeToken<List<Komentar>>() {}.getType());
		 
		  JsonArray jsonArray = element.getAsJsonArray();
		  String s = jsonArray.toString();
		  System.out.println("\n\n"+"JSON ARRAY is :  "+s);
		  
		
	      response.setCharacterEncoding("UTF-8");
	
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
