<%-- 
    Document   : showorders
    Created on : 23-03-2019, 20:26:29
    Author     : Obaydah Mohamad
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Order"%>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/LegoHus");
    }else{
        ArrayList<Order> orders = user.getOrders();
        request.setAttribute("orders", orders);
    }
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<jsp:include page='/online/navbar.jsp'></jsp:include>
    <body>
        <div class="container-fluid h-100">
            <div class="row justify-content-center">
                <div class="col-md-8 pt30">
                    <div class="default-box">
                        <div class="default-box-title" style="padding-bottom: 0px;"><i style="color: #6db6ff;" class="fas fa-list-alt"></i> <span style="padding-left: 16px;">Dine ordre</span></div>
                        
                    </div>
                </div>

                <div class="col-md-8 pt30 pb30">
                <c:choose>
                    <c:when test="${fn:length(orders) gt 0}">
                    <table class="table showorders-table">
                        <thead class="showorders-thead">
                            
                            <tr>
                                <th class="showorders-th">Ordrenummer</th>
                                <th class="showorders-th">Dato</th>
                                <th class="showorders-th">H&oslash;jde</th>
                                <th class="showorders-th">Bredde</th>
                                <th class="showorders-th">L&aelig;ngde</th>
                                <th class="showorders-th">Status</th>    
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${orders}" var="o">
                                <tr class="showorders-tr">
                                    <td>${o.id}</td>
                                    <td>${o.datePlaced}</td>
                                    <td>${o.height}</td>
                                    <td>${o.width}</td>
                                    <td>${o.length}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${o.dateShipped==null}"><span class="badge badge-pill badge-light">Ikke afsendt</span></c:when>
                                            <c:otherwise><span class="badge badge-pill badge-primary">Afsendt</span></c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="text-right">
                                        <a class="btn btn-primary" href="/LegoHus/FrontController?command=showorder&order_id=${o.id}" role="button" style="border-radius: 2px; font-weight: 600; font-size: .8rem; padding: 0px 5px;">
                                            SE 
                                            <i class="fas fa-arrow-right" style="padding-left: 10px;"></i>
                                        </a>
                                    </td>
                                    
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    </c:when>
                    <c:otherwise><div class="text-center">Ingen ordre</div></c:otherwise>
                </c:choose>
                </div>

            </div>
        </div>
    </body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>
