/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Milind Ghiya
 */
public class DisplayUploadList extends SimpleTagSupport {
    private String pagename;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            
            
              String path=(String)getJspContext().getAttribute("path", PageContext.SESSION_SCOPE);
             User user=(User)getJspContext().getAttribute("user", PageContext.SESSION_SCOPE);
         /*    String retpath=(String)getJspContext().getAttribute("retpath", PageContext.SESSION_SCOPE);
             retpath=retpath.substring(0,retpath.length()-4);
*/
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
          /*
             File folder = new File(path);
                  path=path+"/"+pagename;
      File[] listOfFiles = folder.listFiles();
    
     for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()&&!(listOfFiles[i].getName().equals("Thumbs.db")) ){
      out.println( "<li><a target=\"_blank\" style='text-decoration:none;color:deepskyblue' href='ce/"+user.getUserInitial()+"/"+retpath+"/"+listOfFiles[i].getName()+"'/>"+listOfFiles[i].getName()+"</a>"+"</li>");
      } else if (listOfFiles[i].isDirectory()) {
        out.println("Directory " + listOfFiles[i].getName());
      }
    }
 
*/
            Connection con = null;
        Statement stmt = null;
        PageContext pc=(PageContext)getJspContext();
        
        int count=0;
     
       String DB_URL = pc.getServletContext().getInitParameter("DB_URL");
        String DB_DRIVER = pc.getServletContext().getInitParameter("DB_DRIVER");
        String DB_USER = pc.getServletContext().getInitParameter("DB_USER");
        String DB_PASSWORD = pc.getServletContext().getInitParameter("DB_PASSWORD");
            ArrayList<String> al;
        
          try{
                    Class.forName(DB_DRIVER);
                    con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                        stmt = con.createStatement();
            
          
                          String  sql = "SELECT * FROM uploads WHERE user_id='"+user.getUserID()+"'";
                               ResultSet rs = stmt.executeQuery(sql);
                           al=new ArrayList<String>();
                                             while (rs.next()) {
                                                if(rs.getString("doctype").equals(pagename))
                                                    { count++;
                                                       al.add(rs.getString("docname"));
                                                        }
                                                
            
                                             }
                                           
                                   pc.getRequest().setAttribute("al",al);
                           stmt.close();
                     con.close();
                           pc.getRequest().setAttribute("count",count);
            
               }
         catch(Exception e)
         {}
                           if(count==0){out.println("<br><br><br><br><br><strong><center style='margin-left:250px'>You haven't uploaded any document yet");}
                          
            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in DisplayUploadList tag", ex);
        }
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }
    
}
