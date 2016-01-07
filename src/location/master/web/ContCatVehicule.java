package location.master.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import location.master.dao.*;

/**
 * Servlet implementation class Controleur
 */
public class ContCatVehicule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContCatVehicule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String page=request.getParameter("page");
		
				
		if(page.equalsIgnoreCase("/modif1"))
		{
			
			if(request.getParameter("modifier") != null)
			{
				domodifier1(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/admin/modifier_cat_vehicule.jsp").forward(request, response);
			}
			else if(request.getParameter("supprimer") != null)
			{
				dosupprimer(request, response);				
				getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_vehicule.jsp").forward(request, response);
			}
			else
			{	
				getServletContext().getRequestDispatcher("/WEB-INF/admin/nouvelle_cat_vehicule.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/modif2"))	
		{
			if(request.getParameter("annuler") != null)
			{
			}
			else
			{
			domodifier(request, response);	
			}		
			getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_vehicule.jsp").forward(request, response);
		}
		else if(page.equalsIgnoreCase("/nouvelle"))
		{
			if(request.getParameter("annuler") != null)
			{
			}
			else
			{
			doajouter(request, response);
			}
		getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_vehicule.jsp").forward(request, response);
		}
		else
		{
		getServletContext().getRequestDispatcher(page).forward(request, response);	
		}
	}
	
	private void doajouter(HttpServletRequest request, HttpServletResponse response)
	{
		NewCatVehicule newcateg = new NewCatVehicule();
		String nlibelle=request.getParameter("cat");
		Float nprix=Float.parseFloat(request.getParameter("prix"));
		newcateg.nouvelle(nlibelle, nprix);
	}
	
	private void domodifier(HttpServletRequest request, HttpServletResponse response)
	{
		ModifCatVehicule modifcateg = new ModifCatVehicule();
		int mcode=Integer.parseInt(request.getParameter("code"));
		String mlibelle=request.getParameter("cat");
		Float mprix=Float.parseFloat(request.getParameter("prix"));
		modifcateg.modifier(mcode, mlibelle, mprix);
	}
	
	private void domodifier1(HttpServletRequest request, HttpServletResponse response)
	{
		int code=Integer.parseInt(request.getParameter("radio"));
		CatVehiculedao categ=new CatVehiculedao();
		request.setAttribute("code", categ.categories(code).get(0).getcode());
		request.setAttribute("cat", categ.categories(code).get(0).getlibelle());
		request.setAttribute("prix", categ.categories(code).get(0).getprix());
	}
	
	private void dosupprimer(HttpServletRequest request, HttpServletResponse response)
	{
		SupCatVehicule supcateg = new SupCatVehicule();
		int scode=Integer.parseInt(request.getParameter("radio"));
		supcateg.supprimer(scode);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
