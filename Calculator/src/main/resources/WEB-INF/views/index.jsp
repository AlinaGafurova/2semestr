<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html> 
<head>
    <title>Calculator</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/validatescript.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.js"></script>
</head>
<body class="main container">
<div class="row cent">
    <div class="col-md-3">
        <sf:form name="myForm" action="calc" method="post" modelAttribute="calc">
            <h1 id="field_name">Calculator</h1>
            <sf:input class="inp" type="text" path="digit" placeholder="Enter value"/>
            <%--<sf:label path="operation">${calculator.operation}</sf:label>--%>
            <div>
               <p>${digit}</p>
            </div>
            <div>
                <p>${operation}</p>
            </div>
            <c:if test="${message != null}">
                <p>${message}</p>
            </c:if>
            <div id="butts">
                <input class="butt" type="submit" name ="oper" value ="+">
                <input class="butt" type="submit" name ="oper" value ="-">
                <input class="butt" type="submit" name ="oper" value ="*">
                <input class="butt" type="submit" name ="oper" value ="/">
                <input class="butt" type="submit" name ="oper" value ="=">
            </div>
        </sf:form>
    </div>
</div>
</body>
</html>

