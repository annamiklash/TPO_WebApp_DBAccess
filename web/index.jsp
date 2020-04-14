<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>

<div id="grandparent-container">
    <div id="parent-container">
        <form id='loginForm' action='${pageContext.request.contextPath}/res' method='GET'>

            <div id="username" style="margin-bottom: 5px"> Username: <input type='text'
                                                                            name='username'
                                                                            value="${username}"/>
            </div>
            <div id="password" style="margin-bottom: 5px"> Password: <input type='text'
                                                                            name='password'
                                                                            value="${password}"/>
            </div>

            <div>
                <button style="align: center" type="submit">Log In</button>
            </div>

        </form>
    </div>
</div>
</body>
</html>