<%-- 
    Document   : Identity_proof.jsp
    Created on : May 14, 2016, 2:15:05 PM
    Author     : Milind Ghiya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/newtag_library" prefix="d"%>
<!DOCTYPE html>
<head>
    <c:set var="retpath" value="${param.pagename}" scope="session"/>
    


<title>DDU Portal</title>
<style>
    #id{margin-top: 50px;   position:relative;width:500px;
     padding: 0px 40px 0px 20px;
    background-color:#F7F7F7 ;box-shadow:2px 1px 2px 2px #CCCCCC;//0 0 10px 0 rgba(0, 0, 0, 0.3), 0 5px 5px 0 rgba(0, 0, 0, 0.12); //5px 5px 5px #888888;//border:2px solid ${sessionScope.color};}
  
    input:focus{
  border-color: #358efb;
font-size: 14px;


}
   
    button:hover{opacity:0.8;}
    tr { height:35px;}
         td { font-size: 16px;}
   
    .color{ 
        margin-top: 5px;

           // border: 3px solid teal; /* padding-right: 50px;padding-bottom: 80px; 
    }
  
</style>

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
    
    <div class="container" style=";width:965px;height:500px;padding-left: 30px;margin-left: 280px;padding-left: 130px;padding-top: 40px;margin-top: 80px">
            <%--@include file="title.html" --%>
    
    
    
    
    </center>
    
    
    
    
          <div class="color">
                         <div id="id">
    <font color="indianred">
           <br>
          
                        
                        
                        
                        
                        
             <center>           
               
                             <h2>Hello, 
        <c:if test="${sessionScope.user!= null}">${sessionScope.user.userName}</c:if></h2></font>
          
         <c:if test="${sessionScope.user!= null}">
                <c:choose>
                <c:when test="${requestScope.message == null}">
                  <font color="black"><h3>${param.message}</h3></font>
                </c:when>
                <c:otherwise>
                       <font color="black"><h3>${requestScope.message}</h3></font>
                        <c:remove var="message" scope="request"/>
                </c:otherwise>
                </c:choose>
            </c:if>
       
    <form method="post" action="UploadServlet"
        enctype="multipart/form-data">
       
        <table >
            <th align="left" colspan='1'><strong style="font-size:20px;" >Document Upload:</strong>
            </th>
            <th align="left" colspan='1'>
                           
        <c:choose>
<c:when test="${param.pagename eq 'Identity_proof.jsp'}">
    <c:set var="name" value="Id proofs" scope="session"/> 
    
    <d:googlefont text="${name}" />

     
</c:when>
    <c:when test="${param.pagename eq 'certificate.jsp'}">
    <c:set var="name" value="Others" scope="session"/> 
     <d:googlefont text="${name}" />

    <c:set var="color" value="darkorange" scope="session"/> 
</c:when>
    <c:when test="${param.pagename eq 'paper_article.jsp'}">
    <c:set var="name" value="Papers/Articles" scope="session"/> 
      <d:googlefont text="${name}" />
 
    <c:set var="color" value="darkmagenta" scope="session"/> 
</c:when>
</c:choose>                   
                           
                       
            
        
        
        
        
        </th>
            <tr>
                <td >
                    
                    <font style="color:indianred">*</font ><strong>Select file to upload:</strong></td>
                <td><input type="file" name="file" size="60" style="background-color:deepskyblue;color:white" required/></td>
            </tr>
             <tr>
                 <td ><font style="color:indianred">*</font><strong>Name of document</strong></td>
                 <td><input type="text" name="docname" placeholder="Give a name without special characters" size="29" required/></td>
            <tr><td align="center">
                    <p> <button  type="reset"  class="w3-btn w3-round-large" style="background-color: indianred;color:white;width: 80px;height:30px" >Reset</button></p>
                    </p>
                </td><td align="center" style="padding-right:70px">
                    <p> <button  type="submit"  class="w3-btn w3-round-large" style="background-color: indianred;color:white;width: 80px;height:30px" >Upload</button></p>
                    </p>
                </td>
            </tr>
              <tr><td align="left"  colspan='2'>
                                <font style="color:indianred;font-size:13px">* indicates required field </font></td></tr>
        </table>
        </center>
           </div>
          </form>
                         </div>
        <!--             <br>
                         <br>
                      <div style="margin:0px 0px;padding:20px 120px;background-color:palegoldenrod;min-height: 150px;list-style-image: url(images/new.png);">
                     <strong> Your Uploads: <br></stromg>
                             
<ul > </ul>
</div>
 -->
   
                               
</div>
<div class="footer" >
           <div class="footer_resize">
               <%@include file="footer.html" %>

           </div>
       </div>
</body>
</html>
