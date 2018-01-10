package gen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Milind Ghiya
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*50,      // 10MB
                 maxRequestSize=1024*1024*100)   // 50MB
public class UploadServlet extends HttpServlet {
      
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
        Connection con = null;
        Statement stmt = null;
         int count=0;
        String DB_URL = servletConfig.getServletContext().getInitParameter("DB_URL");
        String DB_DRIVER = servletConfig.getServletContext().getInitParameter("DB_DRIVER");
        String DB_USER = servletConfig.getServletContext().getInitParameter("DB_USER");
        String DB_PASSWORD = servletConfig.getServletContext().getInitParameter("DB_PASSWORD");
        String retpath=(String)request.getSession().getAttribute("retpath");
       String NameOfFile=null;
        boolean b=true;
        String message;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             User user=(User)request.getSession().getAttribute("user");
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
               // String path=(String)request.getSession().getAttribute("path");
                
               String path=(String)servletConfig.getServletContext().getAttribute("path2")+"/"+user.getUserInitial()+"/"+retpath.substring(0,retpath.length()-4);
             
        // constructs path of the directory to save uploaded file
        String savePath =path;
         
        // creates the save directory if it does not exists
        try{
           
         File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
         }
         
        Part part = request.getPart("file");
            
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
           if(fileName!=null)
           {NameOfFile=fileName;}
            
        
        
       
        File folder = new File(path);
      File[] listOfFiles = folder.listFiles();
        }
        catch(Exception e)
        {
          
        }

 /*   for (int i = 0; i < listOfFiles.length-1; i++) {
      if (listOfFiles[i].isFile()) {
      out.println( listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        out.println("Directory " + listOfFiles[i].getName());
      }
    }
      */
               
      
       try{
       Class.forName(DB_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
           String sql = "SELECT * FROM uploads";
           ResultSet rs=stmt.executeQuery(sql);
            
           while(rs.next())
             {if(rs.getString("address").equals(path+"/"+NameOfFile)) 
              {
                  b=false;
              }
             } 
             rs.close();
           if(b)
           {
             sql = "INSERT INTO uploads (user_id,doctype,docname,address)" + "VALUES ( '"+user.getUserID()+"', '"+retpath.substring(0, retpath.length()-4)+"', '"+request.getParameter("docname")+"','"+path+"/"+NameOfFile+"' )";
            
             stmt.executeUpdate(sql);
           }
              stmt.close();
            con.close();
            
        }
        catch(Exception e)
        {
        
        }
            
            
            
           if(b)
           { 
          message="Upload has been done successfully!";
           }
           else
           {message="File already exists in your uploads!";
          
           }
       request.setAttribute("message",message);
         retpath="/upload.jsp?pagename="+retpath;
         
         getServletContext().getRequestDispatcher(retpath).forward(request, response);
       
           out.println("</body>");
            out.println("</html>");
       
        }
        
        
    }
    
    
    
     private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
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
