/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milind Ghiya
 */
public class SttpServlet extends HttpServlet {
    
    ServletConfig servletConfig = null;
 @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.servletConfig = config;
        
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        
         Connection con = null;
        Statement stmt = null;
         
        String DB_URL = servletConfig.getServletContext().getInitParameter("DB_URL");
        String DB_DRIVER = servletConfig.getServletContext().getInitParameter("DB_DRIVER");
        String DB_USER = servletConfig.getServletContext().getInitParameter("DB_USER");
        String DB_PASSWORD = servletConfig.getServletContext().getInitParameter("DB_PASSWORD");
        
       
         User user=(User)request.getSession().getAttribute("user");
         
          try{
          Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
            String sql=sql = "INSERT INTO sttp (user_id,type,startdate,enddate,organised,sponsored,approved)" + "VALUES ( '"+user.getUserID()+"', '"+request.getParameter("type")+"', '"+request.getParameter("date1")+"', '"+request.getParameter("date2")+"', '"+request.getParameter("organizer")+"', '"+request.getParameter("sponsorer")+"', '"+request.getParameter("approver")+"' )";
            
             stmt.executeUpdate(sql);

            
            
            
            
           
            stmt.close();
            con.close();
         }
         catch(Exception e)
         {}
           String message=request.getParameter("type");
           message=message.substring(0, 1).toUpperCase() + message.substring(1);
                  message=message +" details added successfully";
           request.setAttribute("message",message);
          getServletContext().getRequestDispatcher("/sttp_workshop.jsp").forward(request, response);
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SttpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
