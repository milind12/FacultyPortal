<%-- 
    Document   : sttp_workshop
    Created on : May 14, 2016, 2:38:16 PM
    Author     : Milind Ghiya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/tlds/newtag_library" prefix="d"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
        <style>
        #id {
            margin: 10px 10px;font-size:15px;
        }
        button:hover{opacity:0.9;border-color: blue;}
    </style>
        <script>
            
function myFunction() {
 
            var e = document.getElementById("sel");
var strUser = e.options[e.selectedIndex].text;
 //document.getElementById("demo3").innerHTML =strUser;
 var i=0;
  document.getElementById("demo0").innerHTML=strUser.charAt(0).toString();
   document.getElementById("demo1").innerHTML=strUser.charAt(1).toString();
         document.getElementById("demo2").innerHTML=strUser.charAt(2).toString();
         document.getElementById("demo3").innerHTML=strUser.charAt(3).toString();
         document.getElementById("demo4").innerHTML=strUser.charAt(4).toString();
         document.getElementById("demo5").innerHTML=strUser.charAt(5).toString();
         document.getElementById("demo6").innerHTML=strUser.charAt(6).toString();
         document.getElementById("demo7").innerHTML=strUser.charAt(7).toString();
         document.getElementById("demo8").innerHTML=strUser.charAt(8).toString();
        
        
         }
            </script>
   <!-- <link href="css/bootstrap.min.css" rel="stylesheet"/> -->
<title>DDU Portal</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--link rel="stylesheet" type="text/css" href="css/style1.css"--%>
</head>
<body>
    <%@include file="header.html"%>
    <c:choose>
    <c:when test="${sessionScope.user !=null && sessionScope.user.userType eq 'admin_sp'}">
            <jsp:include page="sidebar_sp.html" />
    </c:when>
    <c:when test="${sessionScope.user !=null && sessionScope.user.userType eq 'admin'}">
            <jsp:include page="sidebar_admin.html" />
    </c:when>
    <c:otherwise>
          <jsp:include page="sidebar.html" />
    </c:otherwise>
    </c:choose>

    <jsp:include page="login_check.jsp"></jsp:include>
    
    <div class="container" style='width: 400px;margin-left: 500px;background-color: #F7F7F7;box-shadow: 2px 1px 2px 2px #CCCCCC;'>
            <%--@include file="title.html" --%>
            
  </center>
     
     
            <c:if test="${sessionScope.user!= null}">
                <c:choose>
                <c:when test="${requestScope.message == null}">
                    </center><font color="black"><h3>${param.message}</h3></font></center>
                </c:when>
                <c:otherwise>
                        <center><font  color="black"><h3>${requestScope.message}</h3></font></center>
                </c:otherwise>
                </c:choose>
            </c:if>
                         <center><font color="indianred"><h2>Hello, 
        <c:if test="${sessionScope.user!= null}">${sessionScope.user.userName}</c:if></h2></font>
    
                
                <form action="SttpServlet" action="post">
                    <table  >
                        <th colspan="2" align='left'><h3 style="margin:10px 10px"><strong >Program Information: <font id='demo0' color="#007fff"></font><font id='demo1'color="red" ></font><font id='demo2'color="orange" ></font><font id='demo3' color="#007fff"></font><font id='demo4' color="forestgreen"></font><font id='demo5'  color="red"></font><font id='demo6' color="orange"></font><font id='demo7' color="#007fff" ></font><font id='demo8' color="forestgreen"></font></strong></h3></th>
                                     <tr><td>                    <div id="id">
                                                 <font style="color:indianred">*</font><strong>Type:</strong></td><td><select name="type" id="sel" onchange="myFunction()" style="padding-right:75px;font-size :15px">
                                                         <option value="seminar" >Seminar</option>
                                        <option value="workshop" selected="selected">Workshop</option>
                                        <option value="training">Training</option>
                                        <option value="others">Others</option>
                                    </select> 
                                     </div></td></tr>
                                    <tr><td>     <div id="id">
                                                <font style="color:indianred">*</font ><strong>Start Date:</strong></td><td><input type="date" name="date1" style="font-size:15px" required>
                                    </div></td></tr>
                  
                                      <tr><td><div id="id">
                                                  <font style="color:indianred">*</font><strong>End Date:</strong></td><td><input type="date" name="date2" style="font-size:15px" required>
                                   </div></td></tr>
                  
                                  <tr><td>   <div id="id">
                                              <font style="color:indianred">*</font><strong>Organized By:</strong></td><td> <input type="text" name="organizer" placeholder="Enter Organized by"  style="font-size:13px" required>
                                 </div></td></tr>
                        
                                    <tr><td>   <div id="id">
                                                <strong> Sponsored By:</strong></td><td><input type="text" name="sponsorer" placeholder="Enter Sponsored by"  style="font-size:13px" >
                                          </div></td></tr>
                           
                                     <tr><td>  <div id="id">
                                                 <strong> Approved By:</strong></td><td><input type="text" name="approver" placeholder="Enter Approved by" style="font-size:13px">
                                            </div></td></tr>
                        
                                  <tr><td align="center" colspan='2'><button type="submit"  style="padding: 5px 20px;margin:10px;margin-right: 10px;background-color: indianred;border-color: indianred;color:white">Submit</button>
                               </td></tr>
                              <tr><td align="left" style="padding-left:10px" colspan='2'>
                                <font style="color:indianred;font-size:13px">* indicates required field </font></td></tr>
                            </table>
                </form>
                        
          <c:set var="retpath" value="sttp_workshop.jsp" scope="session"/>
   
   
                               
</div>
<div class="footer" >
           <div class="footer_resize">
               <%@include file="footer.html" %>

           </div>
       </div>
</body>
</html>
