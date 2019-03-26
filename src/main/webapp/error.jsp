<%-- 
    Document   : error
    Created on : 24-03-2019, 20:40:37
    Author     : Obaydah Mohamad
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<c:if test="${not empty user}">
    <jsp:include page='/online/navbar.jsp'></jsp:include>
</c:if>
    <body>
        <div class="container-fluid h-100">
            <div class="row justify-content-center">
                <div class="col-md-8 pt30">
                    <div class="default-box">
                        <div class="default-box-title" style="padding-bottom: 0px;"><i class="fas fa-exclamation-triangle text-warning"></i> <span style="padding-left: 16px;">Denne side eksisterer ikke</span></div>
                        <c:if test="${empty user}">
                            <a class="btn btn-primary" href="/LegoHus" role="button" style="margin-top: 18px; border-radius: 2px; font-weight: 600; font-size: .8rem; padding: 0px 5px;">
                                Tilbage til log ind siden
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>
