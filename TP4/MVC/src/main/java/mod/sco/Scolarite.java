package mod.sco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Vector;

public class Scolarite {
	public Vector<Note> getNotes(String num_Ins){
		Vector<Note> vectNotes = new Vector<Note>();
		try {
			DatabaseConn DBConn = new DatabaseConn();
			Connection conn = DBConn.getConn();
	        String sql = "SELECT * FROM notes WHERE Num_Ins = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setString(1, num_Ins);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            int Id_note = resultSet.getInt("Id_Note");
	            String Num_Ins = resultSet.getString("Num_Ins");
	            String Matiere = resultSet.getString("Matiere");
	            float note = resultSet.getFloat("Note");
	            Note noteObj = new Note(Id_note,Num_Ins,Matiere,note);
	            vectNotes.add(noteObj);
	        }
			
		}catch(Exception e) {
			System.out.println("error while getting data from database");
			e.fillInStackTrace();
		}
		return vectNotes;
		
	}
}
