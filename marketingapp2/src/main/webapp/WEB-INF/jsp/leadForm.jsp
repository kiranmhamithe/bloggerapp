<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <body>
        <h2>Lead Form</h2>
        <form action="/saveLead" method="post" modelAttribute="lead">
            First Name: <input type="text" name="firstName" /><br />
            Last Name: <input type="text" name="lastName" /><br />
            Email: <input type="text" name="email" /><br />
            Mobile: <input type="text" name="mobile" /><br />
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
