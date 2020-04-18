<html>
<head>
    <title>My web application</title>
</head>
<body>
<h2>Hello, this is the start page</h2>

<br>
  <form action="user" method="post"></form> // все input отправятся на метод post
        <input type="text" name="action" value="create" hidden> // поле action значение create будет спрятано
        <input type="text" size="40" name="login" placeholder="Input login" required> // required - без ввода этих полей submite не нажмется
<br>
        <input type="password" size="40" name="password" placeholder="Input password" required>
<br>
        <input type="submit"> // отправляет все поля на servlet user
</body>
</html>
