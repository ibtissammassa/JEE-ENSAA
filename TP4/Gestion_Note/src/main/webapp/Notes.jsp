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
System.out.println("in");
float s = 0;
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
    	s+=note.getNote();
    %>
        <tr>
            <td><%=note.getMetiere()%></td>
            <td><%=note.getNote()%></td>
        </tr>
    <%
    }%>
</table>
<br/>
	Moyenne : <%=s/dataVect.size()%>
	<%}%>
</body>
</html>