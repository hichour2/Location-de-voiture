package location.master.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import location.master.dao.*;

import java.util.*;

/**
 * Servlet implementation class ContReservation
 */
public class ContReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		String page=request.getParameter("page");
		
		if(page.equalsIgnoreCase("/etape1"))
		{
			if(request.getParameter("suivant") != null)
			{
				doetape1(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation2.jsp").forward(request, response);
			}
			else
			{
				String cin=request.getParameter("cin");
				Clientdao rechclient = new Clientdao();
				
				
				session.setAttribute("cin", cin);
				session.setAttribute("nom", rechclient.clients(cin).get(0).getnom());
				session.setAttribute("prenom", rechclient.clients(cin).get(0).getprenom());
				session.setAttribute("adresse", rechclient.clients(cin).get(0).getadresse());
				session.setAttribute("tel", rechclient.clients(cin).get(0).getnumtel());
				session.setAttribute("codecate", rechclient.clients(cin).get(0).getcodecat());
				
				
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation1.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/etape2"))
		{
			if(request.getParameter("precedent") != null)
			{
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation1.jsp").forward(request, response);
			}
			else if(request.getParameter("suivant") != null)
			{
				doetape2(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation3.jsp").forward(request, response);
			}
			else if(request.getParameter("terminer") != null)
			{
				doreserv(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation_incomp.jsp").forward(request, response);
			}
			else if(request.getParameter("completer") != null)
			{
				docompleter(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation3.jsp").forward(request, response);
			}
			else if(request.getParameter("annuler") != null)
			{
				SupReservation reserv=new SupReservation();
			    reserv.supprimer(Integer.parseInt(request.getParameter("radio")));
			    getServletContext().getRequestDispatcher("/WEB-INF/location/reservation_incomp.jsp").forward(request, response);
			}
			else
			{
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation2.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/etape3"))
		{
			if(request.getParameter("precedent") != null)
			{
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation2.jsp").forward(request, response);
			}
			else if(request.getParameter("terminer") != null)
			{
				doetape3(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation4.jsp").forward(request, response);
			}
			else
			{
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation3.jsp").forward(request, response);
			}
		}
		else if(page.equalsIgnoreCase("/etape4"))
		{
			if(request.getParameter("terminer") != null)
			{
				doetape4(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation_incomp.jsp").forward(request, response);
			}
			else
			{
				getServletContext().getRequestDispatcher("/WEB-INF/location/reservation3.jsp").forward(request, response);
			}
				
		}
		else if(page.equalsIgnoreCase("/imprimer"))
		{
			getServletContext().getRequestDispatcher("/WEB-INF/location/facture.jsp").forward(request, response);
		}
		else
		{
			session.setAttribute("cin", null);
			getServletContext().getRequestDispatcher("/WEB-INF/location/reservation1.jsp").forward(request, response);
		}
		
	}

	private void doetape1(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		//NewClientdao newclient = new NewClientdao();
		String cin=request.getParameter("cin");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		int tel=Integer.parseInt(request.getParameter("tel"));
		int codecate=Integer.parseInt(request.getParameter("cat"));
		
		//newclient.nouveau(cin, nom, prenom, adresse,tel);
		
		session.setAttribute("cin", cin);
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("adresse", adresse);
		session.setAttribute("tel", tel);
		session.setAttribute("codecate", codecate);
	}
	
	private void doetape2(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		String cin=(String)session.getAttribute("cin");
		String nom=(String)session.getAttribute("nom");
		String prenom=(String)session.getAttribute("prenom");
		String adresse=(String)session.getAttribute("adresse");
		int tel=(Integer)session.getAttribute("tel");
		int codecate=(Integer)session.getAttribute("codecate");
		String immatr=request.getParameter("radio");
		
		
		NewClientdao newclient=new NewClientdao();
		NewReservation newreserv=new NewReservation();
		
		newclient.nouveau(cin, nom, prenom, adresse, tel,codecate);
		newreserv.nouvelle(cin, immatr);
		
		Reservationdao reserv = new Reservationdao();
		int codereserv=reserv.reservations(-1).get(0).getcodereserv();
		
		String modele=reserv.reservations(codereserv).get(0).getmodele();
		int nbreplace=reserv.reservations(codereserv).get(0).getnbreplace();
		String categorie=reserv.reservations(codereserv).get(0).getlibcat();
		
		session.setAttribute("cin", cin);
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("adresse", adresse);
		session.setAttribute("tel", tel);
		session.setAttribute("codecate", codecate);
		session.setAttribute("immatr", immatr);
		session.setAttribute("modele", modele);
		session.setAttribute("nbreplace", nbreplace);
		session.setAttribute("categorie", categorie);
		session.setAttribute("codereserv", codereserv);
		
	}
	
	public static double diffjour(Date datedebut, Date datefin) {
		double result = Double.POSITIVE_INFINITY;
		if (datedebut != null && datefin != null) {
			final long milise_par_jour = 1000 * 60 * 60 * 24;
			Calendar aCal = Calendar.getInstance();
			aCal.setTime(datedebut);
			long aFromOffset = aCal.get(Calendar.DST_OFFSET);
			aCal.setTime(datefin);
			long aToOffset = aCal.get(Calendar.DST_OFFSET);
			long aDayDiffInMili = (datefin.getTime() + aToOffset) - (datedebut.getTime() + aFromOffset);
			result = ((double) aDayDiffInMili / milise_par_jour);
		}
		return result;
	}
	
	private void doetape3(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		//Locationdao newlocation = new Locationdao();
		
		String cin=(String)session.getAttribute("cin");
		String nom=(String)session.getAttribute("nom");
		String prenom=(String)session.getAttribute("prenom");
		String adresse=(String)session.getAttribute("adresse");
		int tel=(Integer)session.getAttribute("tel");
		int codecate=(Integer)session.getAttribute("codecate");
		String immatr=(String)session.getAttribute("immatr");
		Date datelocation=Date.valueOf(request.getParameter("date_location"));
		Date dateretour=Date.valueOf(request.getParameter("date_retour"));
		Date datefacture=Date.valueOf(request.getParameter("date_facturation"));
		int codereserv=(Integer)session.getAttribute("codereserv");
		
		Locationdao maxfact = new Locationdao();
		int numfacture=maxfact.locations("max").get(0).getnumfacture();
		
		Vehiculedao tarif=new Vehiculedao();
		CatVehiculedao catvehi =new CatVehiculedao();
		
		Float _tarif=catvehi.categories(tarif.listevehicules(immatr).get(0).getcodecat()).get(0).getprix();
		
		long nbrejour = (long) diffjour(datelocation,dateretour);
		
		Float prix = nbrejour*_tarif ;
		
		CatClientdao catclient=new CatClientdao();
		Float taux=catclient.categories(codecate).get(0).gettauxremise();
		prix=prix-(prix*taux/100);
		
		//newlocation.nouvelle(cin, immatr, datelocation, dateretour, datefacture, prix);
		
		session.setAttribute("cin", cin);
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("adresse", adresse);
		session.setAttribute("tel", tel);
		session.setAttribute("taux", taux);
		session.setAttribute("codecate", codecate);
		session.setAttribute("immatr", immatr);
		session.setAttribute("datelocation", datelocation);
		session.setAttribute("dateretour", dateretour);
		session.setAttribute("datefacture", datefacture);
		session.setAttribute("numfacture", numfacture+1);
		session.setAttribute("prix", prix);
		session.setAttribute("codereserv", codereserv);
		
		
	}
	
	private void doetape4(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		NewClientdao newclient=new NewClientdao();
		NewLocation newlocation = new NewLocation();
		
		String cin=(String)session.getAttribute("cin");
		String nom=(String)session.getAttribute("nom");
		String prenom=(String)session.getAttribute("prenom");
		String adresse=(String)session.getAttribute("adresse");
		int tel=(Integer)session.getAttribute("tel");
		int codecate=(Integer)session.getAttribute("codecate");
		String immatr=(String)session.getAttribute("immatr");
		Date datelocation=(Date)session.getAttribute("datelocation");
		Date dateretour=(Date)session.getAttribute("dateretour");
		Date datefacture=(Date)session.getAttribute("datefacture");
		int codereserv=(Integer)session.getAttribute("codereserv");
		Float prix=(Float)session.getAttribute("prix");
		
		
		
		
		SupReservation supreserv  = new SupReservation();
		supreserv.supprimer(codereserv);
		
		newclient.nouveau(cin, nom, prenom, adresse, tel,codecate);
		newlocation.nouvelle(cin, immatr, datelocation, dateretour, datefacture, prix);
		
	}
	
	private void doreserv(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		String cin=(String)session.getAttribute("cin");
		String nom=(String)session.getAttribute("nom");
		String prenom=(String)session.getAttribute("prenom");
		String adresse=(String)session.getAttribute("adresse");
		int tel=(Integer)session.getAttribute("tel");
		String immatr=request.getParameter("radio");
		int codecate=(Integer)session.getAttribute("codecate");
		
		
		NewClientdao newclient=new NewClientdao();
		NewReservation newreserv=new NewReservation();
		
		newclient.nouveau(cin, nom, prenom, adresse, tel,codecate);
		newreserv.nouvelle(cin, immatr);
	}
	
	private void docompleter(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		
		int codereserv=Integer.parseInt(request.getParameter("radio"));
		Reservationdao reserv = new Reservationdao();

		String cin=reserv.reservations(codereserv).get(0).getcin();
		String nom=reserv.reservations(codereserv).get(0).getnom();
		String prenom=reserv.reservations(codereserv).get(0).getprenom();
		String adresse=reserv.reservations(codereserv).get(0).getadresse();
		int tel=reserv.reservations(codereserv).get(0).gettel();
		String immatr=reserv.reservations(codereserv).get(0).getimmatr();
		String modele=reserv.reservations(codereserv).get(0).getmodele();
		int nbreplace=reserv.reservations(codereserv).get(0).getnbreplace();
		String categorie=reserv.reservations(codereserv).get(0).getlibcat();
				
		session.setAttribute("cin", cin);
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("adresse", adresse);
		session.setAttribute("tel", tel);
		session.setAttribute("immatr", immatr);
		session.setAttribute("modele", modele);
		session.setAttribute("nbreplace", nbreplace);
		session.setAttribute("categorie", categorie);
		session.setAttribute("codereserv", codereserv);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
