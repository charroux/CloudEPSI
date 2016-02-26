package epsi;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class AjoutBaseServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {	
	
		String nom = req.getParameter("nom");
		String a = req.getParameter("age");
		int age = Integer.parseInt(a);
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		Entity etudiant = new Entity("Etudiant");
		etudiant.setProperty("nom", nom);
		etudiant.setProperty("age", age);
		dataStore.put(etudiant);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		
	}
}
