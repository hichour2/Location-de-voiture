package location.master.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import location.master.dao.ClientModif;
import location.master.dao.ClientSupprim;
import location.master.services.Client;

/**
 * Servlet implementation class ContClient
 */
public class ContClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		String page=request.getParameter("page");
		
		
		if(request.getParameter("modifier") != null)
		{
			String cin=request.getParameter("radio");
			request.setAttribute("cin", cin);
			getServletContext().getRequestDispatcher("/WEB-INF/admin/modifier_client.jsp").forward(request, response);
		}
		else if(request.getParameter("valider") != null)
		{
			String cin=request.getParameter("cin");
			int codecate=Integer.parseInt(request.getParameter("cat"));
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String adresse=request.getParameter("adresse");
			int tel=Integer.parseInt(request.getParameter("tel"));
			
			ClientModif client=new ClientModif();
			client.modifier(cin, codecate, nom, prenom, adresse, tel);
			getServletContext().getRequestDispatcher("/WEB-INF/admin/liste_clients.jsp").forward(request, response);
		}
		else if(request.getParameter("supprimer") != null)
		{
			String cin=request.getParameter("radio");
			
			ClientSupprim client=new ClientSupprim();
			
			client.supprimer(cin);
			getServletContext().getRequestDispatcher("/WEB-INF/admin/liste_clients.jsp").forward(request, response);
		}
		else
		{
			getServletContext().getRequestDispatcher("/WEB-INF/admin/liste_clients.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
