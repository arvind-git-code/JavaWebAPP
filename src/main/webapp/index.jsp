<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="index.css"> 
    <title>User Registration</title>
</head>
<body>
<h1>User Registration</h1>
	<div class="container">
    
    <form action="registerUser" method="post">
        Name: <input class="name" type="text" name="name"><br>
        Mobile Number: <input class="mob" type="text" name="mobileNumber"><br>
        <input type="submit" class="buton" value="Submit">
    </form>
    </div>
</body>
</html>