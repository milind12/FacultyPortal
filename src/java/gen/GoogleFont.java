/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Milind Ghiya
 */
public class GoogleFont extends SimpleTagSupport {
     private String text;
     public void setText(String text) {
        this.text = text;
    }

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
         try {
             out.println("<strong style='padding-left:10px;'>");
         } catch (IOException ex) {
             Logger.getLogger(GoogleFont.class.getName()).log(Level.SEVERE, null, ex);
         }
         String color=null; int j=-1;
        for(int i=0;i<text.length();i++){
         try {
            j++;
             if(text.charAt(i)==' ')
             {j--;}
             if(text.charAt(i)!='/')
             {
             switch(j%10)
             {
                 case 0:
                      color="#007fff";
                     break;
                case 1:
                     color="red";break;
                 case 2:
                     color="orange";break;
                     case 3:
                      color="#007fff";break;
                         case 4:
                      color="forestgreen";break;
                             case 5:
                      color="red";break;
                   case 6:
                      color="orange";break;
                   case 7:
                       color="#007fff";break;
                               case 8:
                                   color="forestgreen";break;
                               case 9:
                                   color="red";break;
              
             }
             }else
             {color="#007fff";j--;}
             out.print("<font size='5'  style='color:"+color+";font-fsmily:Courier New'>"+text.charAt(i)+"</font>");
         
             } catch (IOException ex) {
             Logger.getLogger(GoogleFont.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
         try {
             out.println("</strong>");
         } catch (IOException ex) {
             Logger.getLogger(GoogleFont.class.getName()).log(Level.SEVERE, null, ex);
         }
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in GoogleFont tag", ex);
        }
    }
    
}
