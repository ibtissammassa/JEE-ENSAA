package mod;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import form.beans.NoteForm;
import mod.sco.Note;
import mod.sco.Scolarite;

public class ControleurServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
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
		rep.sendRedirect("Notes.jsp");
	}
	
}
