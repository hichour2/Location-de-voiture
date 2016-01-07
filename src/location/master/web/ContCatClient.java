package location.master.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import location.master.dao.CatClientdao;
import location.master.dao.ModifCatClient;
import location.master.dao.NewCatClient;
import location.master.dao.SupCatClient;

/**
 * Servlet implementation class Controleur
 */
public class ContCatClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContCatClient() {
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
				getServletContext().getRequestDispatcher("/WEB-INF/admin/modifier_cat_client.jsp").forward(request, response);
			}
			else if(request.getParameter("supprimer") != null)
			{
				dosupprimer(request, response);				
				getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_client.jsp").forward(request, response);
			}
			else
			{	
				getServletContext().getRequestDispatcher("/WEB-INF/admin/nouvelle_cat_client.jsp").forward(request, response);
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
			getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_client.jsp").forward(request, response);
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
		getServletContext().getRequestDispatcher("/WEB-INF/admin/cat_client.jsp").forward(request, response);
		}
		else
		{
		getServletContext().getRequestDispatcher(page).forward(request, response);	
		}
	}
	
	private void doajouter(HttpServletRequest request, HttpServletResponse response)
	{
		NewCatClient newcateg = new NewCatClient();
		String nlibelle=request.getParameter("cat");
		Float ntauxremise=Float.parseFloat(request.getParameter("tauxremise"));
		newcateg.nouvelle(nlibelle, ntauxremise);
	}
	
	private void domodifier(HttpServletRequest request, HttpServletResponse response)
	{
		ModifCatClient modifcateg = new ModifCatClient();
		int mcode=Integer.parseInt(request.getParameter("code"));
		String mlibelle=request.getParameter("cat");
		Float mtauxremise=Float.parseFloat(request.getParameter("tauxremise"));
		modifcateg.modifier(mcode, mlibelle, mtauxremise);
	}
	
	private void domodifier1(HttpServletRequest request, HttpServletResponse response)
	{
		int code=Integer.parseInt(request.getParameter("radio"));
		CatClientdao categ=new CatClientdao();
		request.setAttribute("code", categ.categories(code).get(0).getcode());
		request.setAttribute("cat", categ.categories(code).get(0).getlibelle());
		request.setAttribute("tauxremise", categ.categories(code).get(0).gettauxremise());
	}
	
	private void dosupprimer(HttpServletRequest request, HttpServletResponse response)
	{
		SupCatClient supcateg = new SupCatClient();
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
