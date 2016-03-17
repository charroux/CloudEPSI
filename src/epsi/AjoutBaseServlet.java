package epsi;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

@SuppressWarnings("serial")
public class AjoutBaseServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {	
	
		String nom = req.getParameter("nom");
		String a = req.getParameter("age");
		int age1 = Integer.parseInt(a);
		
		Queue queue = QueueFactory.getDefaultQueue();
		queue.add(TaskOptions.Builder.withUrl("/tacheDeFond").method(Method.POST).param("nom", nom).param("age", a));
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		
	}
}
