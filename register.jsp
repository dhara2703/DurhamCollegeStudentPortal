<% String pageTitle = "Register Page"; %>
<%@ include file="./header.jsp" %>

<%
    String emailAddress= (String)session.getAttribute("EmailAddress");
    if(emailAddress == null) //SessionEmailAddress not loaded on session
    {
        emailAddress = "";
    } 

%>

<div class="container register">
    <h6 style="text-align: center"><%= message %></h6>
    <form name="Input" method="post" action="./Register">
        <div class="col-md-12 register-center">
            <div class="tab-content" id="myTabContent">

                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                    <h3 class="register-heading" style="text-align: center">Register as a Student</h3>
                   
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="User ID *" value="" name="userId" />
                    </div>

                    <div class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password *" value=""
                                    name="password" />
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirm Password *" value=""
                                    name="  " />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="First Name *" value=""
                                    name="firstName" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Last Name *" value=""
                                    name="lastName" />
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email Address *" value="<%= emailAddress %>"
                                    name="email" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Code *" value=""
                                    name="progCode" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Description *" value=""
                                    name="progDesc" />
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Program Year *" value=""
                                    name="progYear" />
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <div class="row row-no-gutters">
                <div class="col-xs-8 col-md-6"></div>
                <div class="col-xs-6 col-md-4"> <input type="submit" class="btnRegister" value="Register" /></div>
                <div class="col-xs-6 col-md-4"></div>
            

        </div>

    </form>
</div>
<br /><br />

<%@ include file="./footer.jsp" %>