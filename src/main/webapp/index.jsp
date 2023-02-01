<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>session manager - page 1</title>
</head>
<body>

<form method="post" action="index">
    <h1>La redirection est:</h1>
    <br>
    <h1><%=((String) request.getSession().getAttribute("message"))%></h1>
    <button><%=((String) request.getSession().getAttribute("deactivate"))%></button>
</form>

</body>
</html>