package mod.sco;

import java.util.Vector;

public class TestMetier {
public static void main(String[] args) {
	Scolarite sc = new Scolarite();
	try {
		Vector<Note> notes = sc.getNotes("123");
		for(int i=0;i<notes.size();i++) {
			Note note = notes.get(i);
			System.out.println("matiere : "+note.getMetiere()+" note : "+note.getNote()+"\n");
		}
	}catch(Exception e) {
		System.out.println("error");
		e.printStackTrace();
	}
	
	
}
}
