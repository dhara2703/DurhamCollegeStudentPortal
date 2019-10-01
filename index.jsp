<% String pageTitle = "Home Page"; %>
<%@ include file="./header.jsp" %>


<div class="col-sm-12 text-center">
	<br />
	<p style="color: rgb(32, 3, 3);font-size: 120%;">
		This project is part of our assignment where we have created a system for a user to access. It uses Java, JSP,
		TomCat and Servlets to make a website.
	</p>
	<p style="color: rgb(32, 3, 3);font-size: 120%;">
		This website allows a user to login to the system. Students can access their information
		track thier grades and update their info. Faculty members will be able to login to the
		system to update thier own information and add student's grade to the system. User have
		to give thier id and password to login to the system. Depending upon the user type
		(Student or Faculty) they will get access to thier records.
	</p>
	
</div>

	<%  if(student == null)
	{ %>

		<br>
		<hr style="border-color: rgb(11, 13, 48)">
		<p style="color: rgb(32, 3, 3);font-size: 120%;text-align: center">
			If you are a student/faculty, please log in.
		</p>
		<table align="center" bgcolor="lightgoldenrodyellow">
			<tr>
				<td width="100" align="Center">
					<a class="active" href="login.jsp">
						<strong>
							<font size="+1">Log In</font>
						</strong></a>
				</td>
			</tr>
		</table>
	<% } %>

<%@ include file="./footer.jsp" %>