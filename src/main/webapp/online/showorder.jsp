<%-- 
    Document   : showorder
    Created on : 24-03-2019, 00:06:54
    Author     : Obaydah Mohamad
--%>
<%@page import="java.util.HashMap"%>
<%@page import="Data.Bricks"%>
<%@page import="Data.House"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.Order"%>
<%@page import="Data.User"%>
<%
    HashMap<String, Integer> sideW = null;
    HashMap<String, Integer> sideL = null;  
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/LegoHus");
    }else{
        Order order = (Order) request.getAttribute("order");
        if(order == null){
            RequestDispatcher rd = request.getRequestDispatcher("/FrontController?command=showorders");
            rd.forward(request, response);
        }
        request.setAttribute("house", order.getHouse());
        request.setAttribute("bricks", order.getHouse().getAllBricks());
        request.setAttribute("SideW", order.getHouse().getSideW());
        request.setAttribute("SideL", order.getHouse().getSideL());
        
        sideW = order.getHouse().getSideW();
        sideL = order.getHouse().getSideL();   
    }
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<jsp:include page='/online/navbar.jsp'></jsp:include>
    <body>
        <div class="container-fluid h-100">
            <div class="row justify-content-center">
                <div class="col-md-6 pt30">
                    <div class="default-box">
                        <div class="default-box-title clearfix">
                            <c:if test="${user.admin eq 1 && empty order.dateShipped}">
                                <div class="float-right">

                                    <a class="btn btn-primary" href="/LegoHus/FrontController?command=adminmarkshipped&order_id=${order.id}" role="button" style="border-radius: 2px; font-weight: 600; font-size: .8rem; padding: 0px 5px;">
                                     Marker som afsendt
                                    </a>
                                </div>
                            </c:if>
                            <div style="letter-spacing: 1px; color: #c0c0c0; font-weight: 400; padding-bottom: 5px;">Ordre</div>
                            #${order.id}
                            
                        </div>

                        <div class="container-fluid" style="font-family: 'Poppins', sans-serif;">
                            <div class="row default-box" style="color: #c0c0c0; font-size: .8rem;">
                                <div class="col-4 text-center"><i class="fas fa-box-open text-warning" style="font-size: 3rem;"></i><div>${order.datePlaced}</div></div>
                                <div class="col-4 text-center"><i class="fas fa-arrow-right" style="font-size: 3rem;"></i></div>
                                <div class="col-4 text-center">
                                    <c:choose>
                                        <c:when test="${not empty order.dateShipped}">
                                            <i class="fas fa-truck text-primary" style="font-size: 3rem;"></i><div>${order.dateShipped}</div>
                                        </c:when>
                                        <c:otherwise><i class="fas fa-truck" style="font-size: 3rem;"></i></c:otherwise>
                                    </c:choose>
                                        
                                </div>
                                <div class="col-12 default-box text-center" style="margin-top: 10px; padding: 8px;">
                                    <c:choose>
                                        <c:when test="${not empty order.dateShipped}"><span class="text-primary">Afsendt</span></c:when>
                                        <c:otherwise>Ikke afsendt</c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="row default-box" style="margin-top: -1px; color: #212121;">
                                <div class="col-4 text-center">
                                    <div>${order.height}</div>
                                    <div style="font-weight: 600;">H&oslash;jde</div>
                                </div>
                                <div class="col-4 text-center">
                                    <div>${order.width}</div>
                                    <div style="font-weight: 600;">Bredde</div>
                                </div>
                                <div class="col-4 text-center">
                                    <div>${order.length}</div>
                                    <div style="font-weight: 600;">L&aelig;ngde</div>
                                </div>
                            </div>
                        </div>

                        <table class="table table-striped" style="font-family: 'Poppins', sans-serif; margin-top: -1px;">
                            <thead>
                                <tr class="neworder-tr">
                                    <th scope="col"></th>
                                    <th scope="col">2x4</th>
                                    <th scope="col">2x2</th>
                                    <th scope="col">1x2</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="neworder-tr">
                                    <th scope="row">Side 1 <small class="muted">(L&aelig;ngde)</small></th>
                                    <td><%= sideL.get("4") / 2 %></td>
                                    <td><%= sideL.get("2") / 2 %></td>
                                    <td><%= sideL.get("1") / 2 %></td>
                                </tr>
                                <tr class="neworder-tr">
                                    <th scope="row">Side 2 <small class="muted">(Bredde)</small></th>
                                    <td><%= sideW.get("4") / 2 %></td>
                                    <td><%= sideW.get("2") / 2 %></td>
                                    <td><%= sideW.get("1") / 2 %></td>
                                </tr>
                                <tr class="neworder-tr">
                                    <th scope="row">Side 3 <small class="muted">(L&aelig;ngde)</small></th>
                                    <td><%= sideL.get("4") / 2 %></td>
                                    <td><%= sideL.get("2") / 2 %></td>
                                    <td><%= sideL.get("1") / 2 %></td>
                                </tr>
                                <tr class="neworder-tr">
                                    <th scope="row">Side 4 <small class="muted">(Bredde)</small></th>
                                    <td><%= sideW.get("4") / 2 %></td>
                                    <td><%= sideW.get("2") / 2 %></td>
                                    <td><%= sideW.get("1") / 2 %></td>
                                </tr>
                                <tr class="neworder-tr last-tr">
                                    <th scope="row">I alt</th>
                                    <td>${bricks.four}</td>
                                    <td>${bricks.two}</td>
                                    <td>${bricks.one}</td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>
