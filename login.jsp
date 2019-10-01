<% String pageTitle = "Login Page"; %>

<%@ include file="./header.jsp" %>

<%   
	
	String login = (String)session.getAttribute("login"); 
	if(login == null)
		login = "";
	else
		session.removeAttribute("login");
		
%>

<div class="container">
	<center>

		<br />
		<h2>Please log in</h2>
		<br />
		

	</center>
	<div align="center">
		<h3><%= message %></h3><br />
		<form name="Input" method="post" action="./Login">
			<fieldset class="form-group">
				<label for="login">Login Id: </label>
				<input style="width: 50%;padding: 12px 20px;margin: 8px 0;box-sizing: border-box;" type="text"
					class="form-control" name="login" value="<%= login %>" size=20>
			</fieldset>
			<fieldset class="form-group">
				<label for="pwd">Password: </label>
				<input style="width: 50%;padding: 12px 20px;margin: 8px 0;box-sizing: border-box;" type="password"
					class="form-control" name="password" value="" size=20>
			</fieldset>
			<input type="submit" id="submit" class="btn btn-primary"
				style="text-align: center;margin:auto;display:block;" value="Log in"
				>
		</form>

	</div>
	<br /><br />


</div>
<%@ include file="./footer.jsp" %>