package epsi;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class RequeteServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String nom = req.getParameter("nom");
		
		Query query = new  Query("Etudiant");
		FilterPredicate pr = new FilterPredicate("nom", Query.FilterOperator.EQUAL, nom);
		query.setFilter(pr);
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq = dataStore.prepare(query);
		
		for(Entity entity: pq.asIterable()){
			System.out.println(entity.getProperty("nom"));
		}
		
		System.out.println("Je suis dans RequeteServlet");
		
		resp.sendRedirect("index.html");
		
	}
}
