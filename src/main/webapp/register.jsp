<%-- 
    Document   : register
    Created on : 24-03-2019, 20:08:12
    Author     : Obaydah Mohamad
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user != null) {
        response.sendRedirect("/LegoHus/online");
    }
%>
<jsp:include page='/jsp/head.jsp'></jsp:include>
<link rel="stylesheet" type="text/css" href="/LegoHus/css/login.css">
<body>
    <div class="container-fluid h-100">
        <div class="row justify-content-center h-100">

            <div class="col-md-5 col-lg-3 align-self-center">
                <div class="login-box">
                    <div class="text-center" style="padding-bottom: 35px;">
                        <svg height="70px" viewBox="0 0 512 512" width="70px" xmlns="http://www.w3.org/2000/svg">
                            <path d="m512 256c0 141.386719-114.613281 256-256 256s-256-114.613281-256-256 
                                  114.613281-256 256-256 256 114.613281 256 256zm0 0" fill="#714c2f"/>
                            <path d="m511.109375 234.691406-111.46875-111.46875-.25.25-17.125-17.125-33.6875 
                                  33.683594-33.683594-33.683594-42.078125 42.078125-42.078125-42.078125-33.6875 
                                  33.6875-33.6875-33.6875-34.648437 34.644532 118.203125 118.203124-134.535157 
                                  134.535157 116.882813 116.882812c8.789063.914063 17.707031 1.386719 26.734375 
                                  1.386719 141.386719 0 256-114.613281 256-256 0-7.175781-.308594-14.28125-.890625-21.308594zm0 0" 
                                  fill="#523522"/>
                            <path d="m112.339844 325.757812v67.902344h67.902344l16.832031-34.230468-16.832031-33.671876-36.300782-16.832031zm0 0" 
                                  fill="#64e1dc"/>
                            <path d="m331.757812 325.757812-16.832031 33.671876 16.832031 34.230468h67.902344v-67.902344l-36.859375-16.832031zm0 0" 
                                  fill="#00c8c8"/>
                            <path d="m331.757812 325.757812v67.902344h-151.515624v-67.902344l75.757812-15.152343 8.417969-1.679688zm0 0" 
                                  fill="#ffda2d"/><path d="m264.417969 308.925781 67.339843 16.832031v67.902344h-75.757812v-83.054687zm0 0" 
                                  fill="#fdbf00"/>
                            <path d="m399.660156 258.417969-61.0625-16.835938-82.597656 16.835938-16.835938 36.828125 16.835938 30.511718h143.660156zm0 0" 
                                  fill="#ff641a"/><path d="m112.339844 258.417969v67.339843h143.660156v-67.339843l-79.441406-16.835938zm0 0" fill="#ff641a"/>
                            <path d="m112.339844 191.074219v67.34375h67.902344l16.832031-33.671875-16.832031-33.671875-36.300782-16.832031zm0 0" fill="#ffda2d"/>
                            <path d="m331.757812 191.074219-16.832031 33.671875 16.832031 33.671875h67.902344v-67.34375l-36.859375-16.832031zm0 0" fill="#fdbf00"/>
                            <path d="m331.757812 191.074219v67.34375h-151.515624v-67.34375l75.757812-15.148438 8.417969-1.683593zm0 0" fill="#64e1dc"/>
                            <path d="m331.757812 191.074219v67.34375h-75.757812v-82.492188l8.417969-1.683593zm0 0" fill="#00c8c8"/>
                            <g fill="#ff641a">
                                <path d="m256 191.074219-16.835938-25.25 16.835938-42.648438h25.253906v-16.835937h33.671875v16.835937h33.667969v-16.835937h33.671875v16.835937h17.394531v67.898438zm0 0"/>
                                <path d="m112.339844 191.074219v-67.898438h17.394531v-16.835937h33.671875v16.835937h33.667969v-16.835937h33.671875v16.835937h25.253906v67.898438zm0 0"/>
                            </g>
                        </svg>
                    </div>
                    <div class="box-title"><i class="fas fa-user-plus" style="color: #6db6ff;"></i><span style="padding-left: 16px;">Opret dig som kunde</span></div>

                    <c:if test="${error != null}">
                        <div class="alert alert-warning" role="alert" style="font-size: .7rem; margin-top: 1rem; font-family: 'Poppins', sans-serif;">
                            ${error}
                        </div>
                        <% request.removeAttribute("error"); %>
                    </c:if>
                    <form action="/LegoHus/FrontController" Method="POST">
                        <input type="text" class="form-control" name="username" placeholder="Brugernavn">
                        <input type="password" class="form-control" name="password" placeholder="Adgangskode">
                        <input type="password" class="form-control" name="passwordagain" placeholder="Adgangskode igen">
                        <input style="font-family: 'Poppins', sans-serif;  font-weight: 600;" type="submit" class="btn btn-primary" value="Opret bruger">
                        <input type="hidden" name="command" value="createuser">
                    </form>
                    <div class="create-link">
                        <a href="/LegoHus" class="">Tilbage til log ind</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>
<jsp:include page='/jsp/foot.jsp'></jsp:include>
