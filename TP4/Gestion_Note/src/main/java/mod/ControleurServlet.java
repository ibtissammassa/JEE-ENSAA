package mod;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.beans.NoteForm;
import mod.sco.Note;
import mod.sco.Scolarite;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep)
			throws ServletException, IOException{
	    Scolarite sco = new Scolarite();
		NoteForm nf = new NoteForm();
		
		String num_Ins = req.getParameter("num_Ins");
		System.out.println(num_Ins);
		nf.setNum_Ins(num_Ins);
		Vector<Note> Notes = sco.getNotes(num_Ins);
		nf.setLesNotes(Notes);
		
		HttpSession session = req.getSession();
		session.setAttribute("nf", nf);
		System.out.println("redirecting ..");
		rep.sendRedirect("Notes.jsp");
	}

}
