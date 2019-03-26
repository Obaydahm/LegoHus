<<<<<<< HEAD
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null || user.getAdmin() != 0) {
        response.sendRedirect("/LegoHus");
    }
    request.setAttribute("user", user);
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/LegoHus/online" style="font-family: 'lego';">LEGO<span style="color: #ffc107;">HUS</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${user.admin eq 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="/LegoHus/FrontController?command=adminshoworders">Ordre</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item ">
                        <a class="nav-link" href="/LegoHus/online/neworder.jsp">Ny ordre</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LegoHus/FrontController?command=showorders">Ordre</a>
                    </li>
                    
                </c:otherwise>
            </c:choose>
            <li class="nav-item">
                <a class="nav-link" href="/LegoHus/FrontController?command=logout">Log ud</a>
            </li>
        </ul>
    </div>
=======
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null || user.getAdmin() != 0) {
        response.sendRedirect("/LegoHus");
    }
    request.setAttribute("user", user);
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/LegoHus/online" style="font-family: 'lego';">LEGO<span style="color: #ffc107;">HUS</span></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${user.admin eq 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="/LegoHus/FrontController?command=adminshoworders">Ordre</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item ">
                        <a class="nav-link" href="/LegoHus/online/neworder.jsp">Ny ordre</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/LegoHus/FrontController?command=showorders">Ordre</a>
                    </li>
                    
                </c:otherwise>
            </c:choose>
            <li class="nav-item">
                <a class="nav-link" href="/LegoHus/FrontController?command=logout">Log ud</a>
            </li>
        </ul>
    </div>
>>>>>>> newbranch
</nav>