package form.beans;
import java.util.Vector;
import mod.sco.Note;

public class NoteForm {
	private String num_Ins;
	private Vector<Note> notes;
	public String getNum_Ins() {
		return num_Ins;
	}
	public void setNum_Ins(String num_Ins) {
		this.num_Ins = num_Ins;
	}
	public Vector<Note> getLesNotes() {
		return notes;
	}
	public void setLesNotes(Vector<Note> notes) {
		this.notes = notes;
	}
	
}
