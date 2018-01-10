/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Milind Ghiya
 */
public class DownloadServlet extends HttpServlet {
    
    ServletConfig servletConfig = null;
    
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
        
         HttpSession session = request.getSession(false);
          Connection con = null;
        Statement stmt = null;
        String DB_URL = servletConfig.getServletContext().getInitParameter("DB_URL");
        String DB_DRIVER = servletConfig.getServletContext().getInitParameter("DB_DRIVER");
        String DB_USER = servletConfig.getServletContext().getInitParameter("DB_USER");
        String DB_PASSWORD = servletConfig.getServletContext().getInitParameter("DB_PASSWORD");
        User user=(User)session.getAttribute("user");
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
       
           ResultSet rs=null;
           try{
            Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
            String sql;
                sql = "SELECT * FROM uploads WHERE docname='"+request.getParameter("v")+"'";
               rs = stmt.executeQuery(sql);
               
               
                 while (rs.next()) {
              if(rs.getInt("user_id")==user.getUserID()&&rs.getString("doctype").equals((String)session.getAttribute("doctype")))
              {               response.setContentType("text/html");
		 String filepath = rs.getString("address"); 
		      File downloadFile = new File(filepath); 
		     String filename=downloadFile.getName();
		    
                       response.setContentType("APPLICATION/OCTET-STREAM"); 
		  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\""); 
          	  java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath);
		  
		  int i; 
		  while ((i=fileInputStream.read()) != -1) {
		    out.write(i); 
		  } 
		  fileInputStream.close(); 
		 
                        }
                
            }

                rs.close();
            stmt.close();
            
           
           }catch(Exception e)
           { }
           
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
