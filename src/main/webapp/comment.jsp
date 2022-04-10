
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Comment</title>
    <jsp:include page="_header.jsp"/>
</head>
<body>
<div class="form-floating">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-3">
                <form action="/comment" method="post">
                    <br>
                    <input type="number" name="idPost" required placeholder="idPost">
                    <input type="text" name="text" required placeholder="text">
                    <br>
                    <button type="submit" class="btn btn-dark">new Comment</button>
                </form>

<%--                 <c:if test="${post != null}">--%>
                <form action="/updateComment" method="post"><%-- update --%>
                    <br>
                    <input type="number" name="idPost" required placeholder="idPost">
                    <input type="number" name="idComment" required placeholder="idComment">
                    <input type="text" name="text" required placeholder="text">
                    <br>
                    <button type="submit" class="btn btn-dark">editCommentPost</button>
                </form>

                <form action="/deleteComment" method="post"><%-- delete --%>
                    <br>
                    <input type="number" name="idPost" required placeholder="idPost">
                    <input type="number" name="idComment" required placeholder="idComment">
                    <br>
                    <button type="submit" class="btn btn-dark">deleteCommentPost</button>
                </form>

<%--                <form action="/like" method="post">&lt;%&ndash; like &ndash;%&gt;--%>
<%--                    <br>--%>
<%--                    <input type="number" name="idPost" required placeholder="idPost">--%>
<%--                    <br>--%>
<%--                    <button type="submit" class="btn btn-dark">likePost</button>--%>
<%--                </form>--%>
<%--                 </c:if>--%>

                <%
                    if (request.getAttribute("textComment") != null)  {
                %>
                <div class="alert alert-success" role="alert">
                    <%       out.print (request.getAttribute("textComment"));  %>
                </div>
                <% }
                %>
            </div>
        </div>
    </div>

</div>

</body>
</html>

