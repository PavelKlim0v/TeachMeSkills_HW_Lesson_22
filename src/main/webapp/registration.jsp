<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="_header.jsp"/>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">

            <form action="/registration" method="post">
                <br>
                <input type="text" name="name" required placeholder="name">
                <input type="text" name="password" required placeholder="password">
                <input type="text" name="login" required placeholder="login">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="ADMIN">
                    <label class="form-check-label" for="ADMIN">
                        ADMIN
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role" id="USER" checked>
                    <label class="form-check-label" for="USER">
                        USER
                    </label>
                </div>
                <br>
                <button type="submit" class="btn btn-dark">Registration</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
