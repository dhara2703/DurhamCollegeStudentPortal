<% String pageTitle = "Logout Page"; %>
<%@ include file="./header.jsp" %>


<%   
	String logoutMessage = (String)session.getAttribute("logout"); 
	String userName = (String)session.getAttribute("user");
	String userinfo = (String)session.getAttribute("info");

	if(logoutMessage == null)
		logoutMessage="";
	
	if(userName == null)
		userName="";
	else
		session.removeAttribute("userName"); 
	if(userinfo == null)
		userinfo="";
	else
		session.removeAttribute("userinfo"); 
	
%>
<br />

<h3 align="center">Click on the Log out button to log out from the system</h3>

<!-- <h1><%= logoutMessage %></h1> -->
<br /><br />
<a href="./login.jsp">
	<button type="button" class="btn btn-primary btn-lg btn-block">Log Out</button>
</a>

<%@ include file="./footer.jsp" %>