<% String pageTitle = "Update Student Information"; %>
<%@ include file="./header.jsp" %>
<%   
		
	if(student == null)
	{
		session.setAttribute("errors", "You must be logged in to access your dashboard");
		response.sendRedirect("./login.jsp");
	}

	String FirstName= (String)session.getAttribute("FirstName");
    if(FirstName == null) //Session First Name not loaded on session
    {
        FirstName = "";
	} 

	String LastName= (String)session.getAttribute("LastName");
    if(LastName == null) //Session Last Name not loaded on session
    {
        LastName = "";
	} 

	String EmailAddress= (String)session.getAttribute("EmailAddress");
    if(EmailAddress == null) //Session Email Address not loaded on session
    {
        EmailAddress = "";
	} 

	String ProgramCode= (String)session.getAttribute("ProgramCode");
    if(ProgramCode == null) //Session Program Code  not loaded on session
    {
        ProgramCode = "";
	} 

	String ProgramDesc= (String)session.getAttribute("ProgramDesc");
    if(ProgramDesc == null) //Session Program Desc not loaded on session
    {
        ProgramDesc = "";
	} 

	String ProgYear= (String)session.getAttribute("ProgYear");
    if(ProgYear == null) //Session Prog Year not loaded on session
    {
        ProgYear = "";
	} 
	
%>

<div class="container register">
    <h6 style="text-align: center"><%= message %></h6>
    <form name="Input" method="post" action="./updateStudent">
        <div class="col-md-12 register-center">
            <div class="tab-content" id="myTabContent">

                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <h3 class="register-heading" style="text-align: center">Update Student Information</h3>
                   
				   <br/>
				   <br/>


                    <div class="row register-form">
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="First Name *" value="<%= FirstName %>"
                                    name="firstName" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *" value="<%= LastName %>"
                                    name="lastName" />
							</div>
							<div class="form-group">
                                <input type="email" class="form-control" placeholder="Email Address *" value="<%= EmailAddress %>"
                                    name="email" />
                            </div>
                        <!-- </div>

                        <div class="col-md-6"> -->
                            
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Code *" value="<%= ProgramCode %>"
                                    name="progCode" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Description *" value="<%= ProgramDesc %>"
                                    name="progDesc" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Year *" value="<%= ProgYear %>"
                                    name="progYear" />
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <div class="row row-no-gutters">
                <div class="col-xs-8 col-md-6"></div>
                <div class="col-xs-6 col-md-4"> <input type="submit" class="btnUpdate" value="Update" /></div>
                <div class="col-xs-6 col-md-4"></div>
            

        </div>

    </form>
</div>
<br /><br />


<%@ include file="./footer.jsp" %>
