package location.master.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import location.master.dao.AuthentInsert;
import location.master.dao.AuthentifDelete;
import location.master.dao.AuthentifUpdate;
import location.master.dao.Authentification;

/**
 * Servlet implementation class ContUser
 */
public class ContUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContUser() {
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
		String login,pass,type;
		if(page.equalsIgnoreCase("/init_login"))
		{
			login=request.getParameter("login");
			pass=request.getParameter("pass");
			type=request.getParameter("type");
			
			AuthentInsert nouveau=new AuthentInsert();
			nouveau.ajoutuser(login, pass, type);
			session.setAttribute("login", login);
			session.setAttribute("type", type);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} 
		else if(page.equalsIgnoreCase("/login"))
		{
			login=request.getParameter("login");
			pass=request.getParameter("pass");
			
			Authentification utilisateur=new Authentification();
			login=utilisateur.utilisateurs(login, pass,0).get(0).getlogin();
			if(login==null)
			{
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else
			{
				session.setAttribute("login", login);
				session.setAttribute("type", utilisateur.utilisateurs(login, pass,0).get(0).gettype());
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/deconnexion"))
		{
			session.setAttribute("login", null);
			session.setAttribute("type", null);
			getServletContext().getRequestDispatcher("/").forward(request, response);
		}
		else if(page.equalsIgnoreCase("/update"))
		{
			if(request.getParameter("modifier") != null)
			{
				Integer id_user=Integer.parseInt(request.getParameter("radio"));
				Authentification liste = new Authentification();
				String login1=liste.utilisateurs(null, null, id_user).get(0).getlogin();
				session.setAttribute("login", login1 );
				session.setAttribute("id_user", id_user);
				getServletContext().getRequestDispatcher("/WEB-INF/admin/update_user.jsp").forward(request, response);
			}
			else if(request.getParameter("nouveau") != null)
			{
				getServletContext().getRequestDispatcher("/WEB-INF/admin/new_user.jsp").forward(request, response);
			}
			else if(request.getParameter("valider") != null)
			{
				Integer id_user=Integer.parseInt(request.getParameter("id_user"));
				login=request.getParameter("login");
				pass=request.getParameter("pass");
				
				AuthentifUpdate util=new AuthentifUpdate();
				util.modifier(id_user, login, pass);
				getServletContext().getRequestDispatcher("/WEB-INF/admin/utilisateur.jsp").forward(request, response);
			}
			else if(request.getParameter("supprimer") != null)
			{
				Integer id_user=Integer.parseInt(request.getParameter("radio"));
				AuthentifDelete _user=new AuthentifDelete();
				_user.supprimer(id_user);
				getServletContext().getRequestDispatcher("/WEB-INF/admin/utilisateur.jsp").forward(request, response);
			}
			else if(request.getParameter("ajouter") != null)
			{
				login=request.getParameter("login");
				pass=request.getParameter("pass");
				type="Utilisateur";
				AuthentInsert util=new AuthentInsert();
				util.ajoutuser(login, pass, type);
				getServletContext().getRequestDispatcher("/WEB-INF/admin/utilisateur.jsp").forward(request, response);
			}
			else if(request.getParameter("annuler") != null)
			{
				getServletContext().getRequestDispatcher("/WEB-INF/admin/utilisateur.jsp").forward(request, response);
			}
		}
		else
		{
			getServletContext().getRequestDispatcher(page).forward(request, response);
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
