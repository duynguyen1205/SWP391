/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import daos.UserDao;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trong Duy
 */
@WebServlet(name = "EditUserController", urlPatterns = {"/EditUserController"})
    public class EditUserController extends HttpServlet {
    private static final String ERROR = "userProfile.jsp";
    private static final String SUCCESS= "userProfile.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        try {
            String userID = request.getParameter("userID");
            String roleID = request.getParameter("roleID");
            String fullName = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            UserDao dao = new UserDao();
            boolean checkUpdate = dao.updateUser(userID,fullName, email, phone);
            UserDTO user = new UserDTO(userID, fullName, roleID, email, phone, "***");
            session.setAttribute("LOGIN_USER", user);
            if(checkUpdate) {
                url = SUCCESS;
                session.setAttribute("UPDATE", "Cập nhật thành công");
            }
        } catch (Exception e) {
            log("Error at EditUsPro:" + e.toString());
        } finally{
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
