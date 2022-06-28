<%-- 
    Document   : userProfile
    Created on : Jun 26, 2022, 7:30:45 PM
    Author     : Trong Duy
--%>

<%@page import="dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/userprofile.css">
        <title>My profile</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <%
            String update = (String) session.getAttribute("UPDATE");
            if (update == null) {
                update = "";
            }
        %>
        <div class="container bootstrap snippets bootdey">
            <h1 class="text-primary">My Profile</h1>
            <hr>
            <div class="row">
                <!-- left column -->
                <div class="col-md-3">
                    <div class="text-center">
                        <img src="icon/cv__29__generated.jpg" class="avatar img-circle img-thumbnail" alt="avatar">
                    </div>
                </div>

                <!-- edit form column -->
                <div class="col-md-9 personal-info">
                    <h3>Personal info</h3>

                    <form action="MainController" class="form-horizontal" role="form" method="post">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Tên của bạn:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="name" value="<%=loginUser.getUserName()%>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Email</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="email" value="<%=loginUser.getEmail()%>">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Số điện thoại:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" name="phone" value="<%=loginUser.getPhone()%>">
                            </div>
                        </div>
                        <input name="roleID" value="<%=loginUser.getRoleID()%>" hidden="">
                        <input name="userID" value="<%=loginUser.getUserID()%>" hidden="">
                        <div class="form-row">
                            <button type="submit" name="action" value="Edit" class="btn btn-primary">Save</button>
                        </div>
                        <h3><%=update%></h3>
                </div>
                </form>
            </div>
        </div>
    </div>
                <button class="btn btn-success">
                    <a  href="user.jsp" > Back</a>
                </button>
    <hr>
</body>
</html>
