<% String pageTitle = "Change Password"; %>
<%@ include file="./header.jsp" %>


<%   
        
%>



<div class="container register">



        <div class="row row-no-gutters">
                <div class="col-xs-4 col-md-4"></div>
                <div class="col-xs-8 col-md-8">
                        <h2>Change Password</h2>
                        <h3><%= message %></h3><br />

                        <form name="Input" method="post" action="./ChangePassword">
                                <fieldset class="form-group">
                                        <label for="currentpwd">Current Password: </label>
                                        <input style="width: 50%;padding: 12px 20px;margin: 8px 0;box-sizing: border-box;"
                                                type="password" class="form-control" name="currentpwd" value=""
                                                size=20 />
                                </fieldset>
                                <fieldset class="form-group">
                                        <label for="newpwd">New Password: </label>
                                        <input style="width: 50%;padding: 12px 20px;margin: 8px 0;box-sizing: border-box;"
                                                type="password" class="form-control" name="newpwd" value="" size=20 />
                                </fieldset>
                                <fieldset class="form-group">
                                        <label for="confirmpwd">Confirm New Password: </label>
                                        <input style="width: 50%;padding: 12px 20px;margin: 8px 0;box-sizing: border-box;"
                                                type="password" class="form-control" name="confirmpwd" value=""
                                                size=20 />
                                </fieldset>
                                <input type="submit" id="submit" class="btn btn-primary" style="align-content: center"
                                        style="text-align: center;margin:auto;display:block;" value="Change Password" />

                        </form>
                </div>
                <div class="col-xs-4 col-md-4"></div>
        </div>
</div>



<%@ include file="./footer.jsp" %>