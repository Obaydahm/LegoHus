<%-- 
    Document   : neworder
    Created on : 22-03-2019, 10:11:29
    Author     : Obaydah Mohamad
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/LegoHus");
    }
    System.out.println(request.getAttribute("error"));
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<jsp:include page='/online/navbar.jsp'></jsp:include>
    <body>
        <div class="container-fluid h-100"  style="padding-bottom: 30px;">
            <div class="row justify-content-center">

                <div class="col-md-4 pt30">
                    <div class="default-box">
                        <div class="default-box-title">
                            <i class="fas fa-plus-circle" style="color: #6db6ff;"></i>
                            <span style="padding-left: 14px;">Ordre</span>
                        </div>
                        
                        <c:if test="${error != null}">
                            <div class="alert alert-warning" role="alert" style="font-size: .7rem; margin-top: 1rem; font-family: 'Poppins', sans-serif;">
                                ${error}
                            </div>
                            <% request.removeAttribute("error"); %>
                        </c:if>
                        
                        <form action="/LegoHus/FrontController" method="POST" class="clearfix">
                            <small class="form-text text-muted text-right">Minimum 4</small>
                            <input type="text" class="form-control input-field" name="height" placeholder="H&oslash;jde">
                            
                            <small class="form-text text-muted text-right">Minimum 4</small>
                            <input type="text" class="form-control input-field" name="width" placeholder="Bredde">
                            
                            <small class="form-text text-muted text-right">Minimum 4</small>
                            <input type="text" class="form-control input-field" name="length" placeholder="L&aelig;ngde">
                            
                            <input type="hidden" name="command" value="createorder">
                            <button type="submit" class="btn btn-primary" style="padding: 5px 10px; margin-top: 10px; float: right;">
                                Placer ordre 
                                <i class="fas fa-arrow-right" style="padding-left: 10px;"></i>
                            </button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>
