<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>
<%@ page import="mod.sco.Note" %>
<%@ page import="form.beans.NoteForm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NOTES</title>
</head>
<body>
<%
NoteForm nf = (NoteForm)session.getAttribute("nf");
Vector<Note> dataVect=null;
if(nf!=null){
	dataVect = nf.getLesNotes() ;
}
%>
<form action="fetchNote.php" method = "post">
Num Inscription : <input type="text" name="num_Ins" >
<input type="submit" value="OK">
</form>
<table>
    <tr>
        <th>Matière</th>
        <th>Note</th>
    </tr>
    <%
    if(dataVect!=null){
    for (Note note : dataVect){
    %>
        <tr>
            <td>${note.matiere}</td>
            <td>${note.note}</td>
        </tr>
    <%}}%>
</table>
</body>
</html>