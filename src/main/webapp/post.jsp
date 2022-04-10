
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
<div class="form-floating">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-3">
                <form action="/post" method="post">
                    <br>
                    <input type="text" name="text" required placeholder="text">
                    <br>
                    <button type="submit" class="btn btn-dark">doNewPost</button>
                </form>

<%--                 <c:if test="${post != null}">--%>
                <form action="/updatePost" method="post"><%-- update --%>
                    <br>
                    <input type="text" name="text" required placeholder="text">
                    <input type="number" name="idPost" required placeholder="idPost">
                    <br>
                    <button type="submit" class="btn btn-dark">EditPost</button>
                </form>

                <form action="/deletePost" method="post"><%-- delete --%>
                    <br>
                    <input type="number" name="idPost" required placeholder="idPost">
                    <br>
                    <button type="submit" class="btn btn-dark">deletePost</button>
                </form>
<%--                 </c:if>--%>

                <%
                    if (request.getAttribute("textPost") != null)  {
                %>
                <div class="alert alert-success" role="alert">
                    <%       out.print (request.getAttribute("textPost"));  %>
                </div>
                <% }
                %>
            </div>
        </div>
    </div>

</div>

</body>
</html>
