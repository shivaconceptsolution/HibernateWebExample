package bao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import dao.Register;


/**
 * Servlet implementation class AppointmentSer
 */
@WebServlet("/AppointmentSer")
public class AppointmentSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfiguration cfg =new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s =sf.openSession();
        Transaction tx = s.beginTransaction();
        Register obj = new Register();
        obj.setUsername("Operator1");
        obj.setPassword("12345");
        obj.setEmail("abcd@gmail.com");
        obj.setMobile("9812312345");
        s.save(obj);
        tx.commit();
        s.close();
	}

}
