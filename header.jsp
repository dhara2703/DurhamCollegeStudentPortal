<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
        <%@ page import="webd4201.savaliyad.*" %>
        <%@ page import = "java.util.*" %>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title><%= pageTitle %></title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>

        <script type="text/JavaScript1.2">
		function verify() {
			if (document.Input.login.value == "") 
			{
				alert("You must enter a student ID!!");
				return false;
			}
			if (document.Input.password.value == "") 
			{
				alert("You must enter a password!!");
				return false;
			}
			return true;
		}
	</script>
        <style>
                .selector-for-some-widget {
                        box-sizing: content-box;
                }

                ul {
                        list-style-type: none;
                        margin: 0;
                        padding: 0;
                        overflow: hidden;
                }

                li {
                        float: right;
                }

                li a {
                        display: block;
                        color: rgb(8, 113, 235);
                        text-align: center;
                        padding: 14px 16px;
                        text-decoration: none;
                        font-size: 130%;
                }

                li a:hover {
                        background-color: rgb(231, 182, 182);
                }
        </style>

        <%
                String message = (String)session.getAttribute("message");
                if(message == null)
                        message = "";
                else
                        session.removeAttribute("message");

                //HttpSession session = request.getSession(true);

                Student student = (Student)session.getAttribute("student");
                
                String href1 = "login.jsp";
                String link1 = "Log in";
                String href2 = "register.jsp";
                String link2 = "Register";
                String href3 = "index.jsp";
                String link3 = "Home";
               

                if(student != null)
                {  
                        //Student is logged in, because they are on the session
                        href1 = "./Logout";
                        link1 = "Log out";
                        href2 = "changePassword.jsp";
                        link2 = "Change Password";
                        href3 = "dashboard.jsp";
                        link3 = "Dashboard";
                        
                }
%>
</head>

<body style="background-color: rgb(245, 248, 239)">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="col-sm-12 text-left" style="position: fixed;left: 0;width: 100%;background-color: rgb(230, 236, 195);
                        color: rgb(8, 58, 58); text-align: center;">


                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                                <ul class="navbar-nav">
                                        <li class="nav-item active">
                                                <a href="<%= href1 %>"><%= link1 %> <span
                                                                class="sr-only">(current)</span></a>
                                                <!-- <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
                                        </li>
                                        <li class="nav-item">
                                                <a href="<%= href2 %>"><%= link2 %></a>
                                        </li>
                                        <li class="nav-item">
                                                <a href="<%= href3 %>"><%= link3 %></a>
                                        </li>
                                        <%  if(student != null)
                                        {
                                                String href4 = "updateStudent.jsp";
                                                String link4 = "Update Student"; 
                                        %> 
                                                <li class="nav-item">
                                                        <a href="<%= href4 %>"><%= link4 %></a>
                                                </li>
                                                <% } %>

                                </ul>
                        </div>
                </div>
        </nav>
        <br />
        <h1 class="w3-wide" style="margin: auto;width: 100%;padding: 10px; text-align: center">
                <u>
                        <a href="./index.jsp">
                                <font style="color: rgb(11, 17, 102)">Durham College Marks Tracking System </font>
                        </a>
                </u>
        </h1>
        <br />


        <!-- <nav class="navbar navbar-light bg-light"> -->

        <!-- 
        <div class="col-sm-12 text-left" style="position: fixed;left: 0;width: 100%;background-color: rgb(230, 236, 195);
        color: rgb(8, 58, 58); text-align: center;">
                <h1 class="w3-wide" style="margin: auto;width: 100%;padding: 10px; text-align: left;">
                        <u>
                                <a href="./index.jsp">
                                        <font style="color: rgb(11, 17, 102)">Durham College Marks Tracking
                                                System
                                        </font>
                                </a>
                        </u>
                </h1>
        </div>

        <br /><br /><br />
        <div class="col-sm-12 text-left">
                <ul>
                        <li><a href="<%= href1 %>"><%= link1 %></a></li>
                        <li><a href="<%= href2 %>"><%= link2 %></a></li>
                        <li><a href="<%= href3 %>"><%= link3 %></a></li>
                </ul>

        </div>
        </nav> -->