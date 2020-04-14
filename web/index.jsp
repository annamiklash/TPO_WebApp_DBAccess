<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>

<div id="grandparent-container">
    <div id="parent-container">
        <h1 style="color: crimson">Log in to see your resources</h1>
        <form id='loginForm' action='${pageContext.request.contextPath}/login' method='post'>

            <div id="username" style="margin-bottom: 5px"> Username: <input type='text'
                                                                            name='username'
                                                                            value="${username}"/>
            </div>
            <div id="password" style="margin-bottom: 5px"> Password: <input type='text'
                                                                            name='password'
                                                                            value="${password}"/>
            </div>

            <div>
                <button class="loginButton" style="align: center" type="submit">Log In</button>
            </div>

        </form>
    </div>
</div>
</body>
</html>