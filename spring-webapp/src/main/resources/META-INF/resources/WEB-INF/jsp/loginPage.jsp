<html>
<head><title> My first HTML Page - JSP</title></head>
<body><h1>Login page</h1>
<h2>Hi ${name}</h2>
<h2>Hello: ${firstName}</h2></body>
<form method="post">
    <label for="username">Username:</label>
    <input name="username" id="username" type="text"/>
    <label for="password">Password:</label>
    <input name="password" id="password" type="password"/>
    <button type="submit">Login</button>
</form>
</html>


