package mod.sco;

public class Note {
	private int id_note;
	private String num_Ins;
	private String matiere;
	private float note;
	public int getId_note() {
		return id_note;
	}
	public void setId_note(int id_note) {
		this.id_note = id_note;
	}
	public String getNum_Ins() {
		return num_Ins;
	}
	public void setNum_Ins(String num_Ins) {
		this.num_Ins = num_Ins;
	}
	public String getMetiere() {
		return matiere;
	}
	public Note(int id_note, String num_Ins, String metiere, float note) {
		super();
		this.id_note = id_note;
		this.num_Ins = num_Ins;
		this.matiere = metiere;
		this.note = note;
	}
	public void setMetiere(String metiere) {
		this.matiere = metiere;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
}
