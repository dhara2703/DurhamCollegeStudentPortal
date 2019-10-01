<% String pageTitle = "Dashboard"; %>
<%@ include file="./header.jsp" %>
<%   
	
	//Student student = (Student)session.getAttribute("student");
	
	if(student == null)
	{
		session.setAttribute("errors", "You must be logged in to access your dashboard");
		response.sendRedirect("./login.jsp");
	}
	


%>
<div style="color:midnightblue;text-align: center">
	<h2><b>Welcome <%= student.getFirstName() %></b></h2>

	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Course Code</th>
				<th scope="col">Course Title</th>
				<th scope="col">GPA Weighting</th>
				<th scope="col">Result</th>
			</tr>
		</thead>
		<tbody>
			<% Vector<Mark> marks = student.getMarks();
	for(int i = 0; i < marks.size(); i++){
		out.print("<tr>");
		out.print("<th scope='row'>");
			%><%=marks.elementAt(i).getCourseCode()%><%
		out.print("</th>");
		out.print("<td>");
				%><%=marks.elementAt(i).getCourseName()%><%
			out.print("</td>");
			out.print("<td>");
					%><%=marks.elementAt(i).getGpaWeighting()%><%
				out.print("</td>");
		out.print("<td>");
				%><%=marks.elementAt(i).getResult()%><%
			out.print("</td>");
		out.print("</tr>");

	} %>
		</tbody>
	</table>
	<div class="p-3 mb-2 bg-info text-white"><h2>GPA = <%=student.CalculateGPA()%></h2></div>


	<br /><br /><br />

</div>
<br />

<%@ include file="./footer.jsp" %>