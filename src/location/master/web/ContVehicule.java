package location.master.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.master.dao.ModifCatVehicule;
import location.master.dao.ModifVehicule;
import location.master.dao.NewCatVehicule;
import location.master.dao.NewVehicule;
import location.master.dao.SupVehicule;

/**
 * Servlet implementation class ContVehicule
 */
public class ContVehicule extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
				getServletContext().getRequestDispatcher("/WEB-INF/admin/modifier_vehicule.jsp").forward(request, response);
			}
			else if(request.getParameter("supprimer") != null)
			{
			    dosupprimer(request, response);				
				getServletContext().getRequestDispatcher("/WEB-INF/admin/vehicule.jsp").forward(request, response);
			}
			else
			{	
				getServletContext().getRequestDispatcher("/WEB-INF/admin/nouveau_vehicule.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/modif2"))	
		{
		domodifier(request, response);			
		getServletContext().getRequestDispatcher("/WEB-INF/admin/vehicule.jsp").forward(request, response);
		}
		else if(page.equalsIgnoreCase("/nouveau"))
		{
			if(request.getParameter("annuler") != null)
			{
			}
			else
			{
		doajouter(request, response);
			}
		getServletContext().getRequestDispatcher("/WEB-INF/admin/vehicule.jsp").forward(request, response);
		}
		else
		{
		getServletContext().getRequestDispatcher(page).forward(request, response);	
		}
		
	}
	
	private void doajouter(HttpServletRequest request, HttpServletResponse response)
	{
		NewVehicule newvehi= new NewVehicule();
		String immatr=request.getParameter("immatr");
		int cat=Integer.parseInt(request.getParameter("cat"));
		String modele=request.getParameter("modele");
		int nbreplace=Integer.parseInt(request.getParameter("nbre_place"));
		newvehi.nouveau(immatr, cat, modele, nbreplace);
		
	}
	
	private void domodifier(HttpServletRequest request, HttpServletResponse response)
	{
		ModifVehicule modifvehi = new ModifVehicule();
		String immatr1=request.getParameter("immatr1");
		String immatr=request.getParameter("immatr");
		String modele=request.getParameter("modele");
		int nbreplace=Integer.parseInt(request.getParameter("nbre_place"));
		int cat=Integer.parseInt(request.getParameter("cat"));
		modifvehi.modifier(immatr1,immatr, cat, modele, nbreplace);
	}
	
	private void dosupprimer(HttpServletRequest request, HttpServletResponse response)
	{
		SupVehicule supvehi=new SupVehicule();
		String immatr=request.getParameter("radio");
		supvehi.supprimer(immatr);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
