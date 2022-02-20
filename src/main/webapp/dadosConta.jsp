<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 18/02/2022
  Time: 09:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dados da conta</title>
    <link rel="stylesheet" href="styleDadosConta.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;700&display=swap" rel="stylesheet">
</head>
<body>
    <div>
        <h2>Nome do cliente: </h2> <span><%=request.getAttribute("nome")%></span>
        </div>
    </div>
    <div>
        <h2>Email: </h2> <span><%=request.getAttribute("email")%></span>
    </div>
    <div>
        <h2>Senha: </h2>
        <div class="password">
            <div class="targe">Passe o mouse para ver a senha</div>
            <span><%=request.getAttribute("senha")%></span>
        </div>
    </div>
    <div>
        <h2>Telefone: </h2> <span><%=request.getAttribute("telefone")%></span>
    </div>
</body>
</html>
