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
        <script src="js/scriptsChangePass.js"></script>
        <title>Change Password</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !loginUser.getRoleID().equals("US")) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <%
            String changePass = (String) session.getAttribute("CHANGE_SUCCESS");
            if (changePass == null) {
                changePass = "";
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
                    <h3>Change password</h3>

                    <form action="MainController" class="form-horizontal" role="form" method="post" id="changePass">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Mật khẩu hiện tại:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="password" id="password" onblur="checkDuplicate()">
                                <input id="oldPass" value="<%=loginUser.getPassword()%>" hidden>
                                <p id="checkOldPass" style="display: none; color: red;">Sai mật khẩu hiện tại</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Mật khẩu mới:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="password" id="newPass" name="newPass">
                                <span class="form-message"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Xác nhận mật khẩu:</label>
                            <div class="col-lg-8">
                                <input class="form-control" type="password" id="password_confirm">
                                <span class="form-message"></span>
                            </div>
                        </div>
                        <input name="userID" value="<%=loginUser.getUserID()%>" hidden>
                        <div class="form-row">
                            <button type="submit" name="action" value="ChangePass" class="btn btn-primary">Save</button>
                        </div>
                        <p><%=changePass%></p>
                </div>
                </form>
            </div>
        </div>
    </div>
    <button class="btn btn-success">
        <a  href="user.jsp" > Back</a>
    </button>    
    <hr>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Mong muốn của chúng ta
            Validator({
                form: '#changePass',
                errorSelector: '.form-message',
                rules: [
                    Validator.minLength('#newPass', 6, 'Nhập vào tối thiểu 6 ký tự'),
                    Validator.isConfirmed('#password_confirm', function () {
                        return document.querySelector('#changePass #newPass').value;
                    }, 'Mật khẩu nhập lại không chính xác')
                ],
            });
        });
    </script>
</body>
</html>
