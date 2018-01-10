<%-- 
    Document   : get_document
    Created on : May 22, 2016, 8:56:32 PM
    Author     : Milind Ghiya
--%>


<%@page import="java.util.ArrayList"%>
<%@taglib uri="/WEB-INF/tlds/newtag_library" prefix="d"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="gen.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <style>
            .b {
                background-image:url('images/bi.jpg');
                box-shadow: 2px 2px 5px black;
                display: inline-block;
                height: 44px;
                line-height: 44px;
                text-align: left;
                text-decoration:none !important;
                border-radius: 10px;
            }
            .b:hover{ background-image: url('images/bi2.jpg');color:red;}
            .b span.title{
                display: block;
                color: blue;
                font-size: 14px;
                padding: 0 56px 0 45px;
                position: relative;
                text-align: center;

            }



            .abc:hover{
                background-color: #f5f5f5;color:#007fff;margin:200px auto;
            }
        </style>
        <title>DDU Portal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <%--link rel="stylesheet" type="text/css" href="css/style1.css"--%>
        <link href="css/button.css" rel="stylesheet">



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

            <div class="container">
            <%--@include file="title.html" --%>
            </center><font color="indianred"><h2>Hello, 
                    <c:if test="${sessionScope.user!= null}">${sessionScope.user.userName}</c:if></h2></font></center>


            <d:printlist pagename="${param.pagename}" />

            <center>
                <c:choose>
                    <c:when test="${param.pagename eq 'Identity_proof' and count ne 0}">
                        <c:set var="name" value="Id proofs" scope="session"/> 

                        <d:googlefont text="${name}" /><font size="4">(${count})</font>


                    </c:when>
                    <c:when test="${param.pagename eq 'certificate' and count ne 0}">
                        <c:set var="name" value="Others" scope="session"/> 
                        <d:googlefont text="${name}" /><font size="4">(${count})</font>

                        <c:set var="color" value="darkorange" scope="session"/> 
                    </c:when>
                    <c:when test="${param.pagename eq 'paper_article' and count ne 0}">
                        <c:set var="name" value="Papers/Articles" scope="session"/> 
                        <d:googlefont text="${name}" /><font size="4">(${count})</font>

                        <c:set var="color" value="darkmagenta" scope="session"/> 
                    </c:when>
                </c:choose>     
            </center>


            <c:if test="${sessionScope.user!= null}">
                <c:choose>
                    <c:when test="${requestScope.message == null}">
                        </center><font color="black"><h3>${param.message}</h3></font></center>
                            </c:when>
                            <c:otherwise>
                        <center><font color="black"><h3>${requestScope.message}</h3></font></center>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                        <c:set var="doctype" value="${param.pagename}" scope="session" />

            <c:if test="${not empty al}">

                <table width="800px" border="0" style="margin-top: 50px" >
                    <tr style="background-color:deepskyblue"><td align="center" width='150px'>No. </td>
                        <td align="center">Name Of Document:</td>
                        <td colspan="2" align="center">Action</td>

                    </tr>
                    <c:forEach items="${al}" var="currentname" varStatus="o">
                        <tr class="abc" style="height:70px;"><td align="center" width='150px'>${o.count}</td>
                            <td  align="center">${currentname}</td>
                            <td align="center"  >

<!--   <a href="DownloadServlet?v=${currentname}" class="btn-icon" ><span class="icon32 download"></span><span class="title">DOWNLOAD</span></a> -->


                                <a href="<c:url value="DownloadServlet"><c:param name="v" value="${currentname}"/></c:url>">Download</a></td> 
                            <td align="center"><a   href="<c:url value="DeleteFileServlet"><c:param name="v" value="${currentname}"/></c:url>">Delete</a></td>
                            </tr>

                            <tr>

                        </c:forEach>
                </table>
            </c:if>

        </div>
        <div class="footer" >
            <div class="footer_resize">
                <%@include file="footer.html" %>

            </div>
        </div>
    </body>
</html>

