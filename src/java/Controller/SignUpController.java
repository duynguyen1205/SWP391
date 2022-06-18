/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import daos.UserDao;
import dtos.UserDTO;
import dtos.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trong Duy
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {
    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userE = new UserError();
        UserDao dao = new UserDao();
        boolean checkValidation = true;
        try {
            String userID = request.getParameter("userID");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            Boolean checkDuplicateUser = dao.checkDuplicateUser(userID);
            Boolean checkDuplicateEmail = dao.checkDuplicate(userID, email);
            Boolean checkDuplicatePhone = dao.checkDuplicate(userID, phone);
            if(checkDuplicateUser) {
                userE.setUserID("Tên tài khoản đã tồn tại");
                checkValidation = false;
            }
            if(checkDuplicateEmail) {
                userE.setUserID("Email đã được sử dụng");
                checkValidation = false;
            }
            if(checkDuplicatePhone) {
                userE.setUserID("Số điện thoại đã được sử dụng");
                checkValidation = false;
            }
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, "", "US", email, phone, password);
                boolean checkCreate = dao.createUser(user);
                if(checkCreate) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
