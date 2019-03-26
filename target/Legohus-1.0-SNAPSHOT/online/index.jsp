<%-- 
    Document   : customer
    Created on : 20-03-2019, 16:57:23
    Author     : Obaydah Mohamad
--%>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/LegoHus");
    }
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<jsp:include page='/online/navbar.jsp'></jsp:include>
    <body>
        <div class="container-fluid h-100">
            <div class="row justify-content-center">
                <div class="col-md-4 pt30">
                    <div class="default-box text-center">
                        <div class="default-box-title" style="padding-bottom: 0px;">
                            <i class="fas fa-laugh-beam text-warning" style="font-size: 2rem;"></i>
                            <div style="padding-top: 10px; font-size: 2rem;">Velkommen ${user.username}</div>
                        </div>
                        
                    </div>
                </div>
            </div>
            </
    </body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>