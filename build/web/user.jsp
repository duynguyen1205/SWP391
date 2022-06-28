<%-- 
    Document   : user
    Created on : Jun 13, 2022, 1:34:49 PM
    Author     : Trong Duy
--%>

<%@page import="dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/userstyles.css">
        <title>User Page</title>
        
    </head>
    <body>
         <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">FBS</a>
            <div class="action">
                <div class="profile" onclick="menuToggle();">
                    <!-- <i class="fa fa-camera-retro fa-5x"></i> -->
                    <img src="img/Duy.jpg" alt="">
                </div>
                <div class="menu">
                    <h3><%=loginUser.getUserID()%> <br/><span>Website design</span></h3>
                    <ul>
                        <li><img src="icon/user.png"><a href="userProfile.jsp">My Profile</a></li>
                        <li><img src="icon/edit.png"><a href="changePassword.jsp">Change password</a></li>
                        <li><img src="icon/log-out.png"><a href="MainController?action=Logout">Log out</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <!--JS-->
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            function menuToggle() {
                const toggleMenu = document.querySelector('.menu');
                toggleMenu.classList.toggle('active');
            }
        </script>
    </body>
</html>
