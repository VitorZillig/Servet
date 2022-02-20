<%--
  Created by IntelliJ IDEA.
  User: vitor
  Date: 18/02/2022
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de cliente</title>
    <link rel="stylesheet" href="styleCadastro.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;700&display=swap" rel="stylesheet">
</head>
<body>
    <h1>CADASTRO</h1>
    <form action="dadosConta" method="post">
        <div class="field">
            <label for="nome">Nome </label>
            <input type="text" placeholder="Nome" name="nome" id="nome"/>
        </div>
        <div class="field">
            <label for="email">Email </label>
            <input type="email" placeholder="Email" name="email" id="email">
        </div>
        <div class="field">
            <label for="senha">Senha </label>
            <input type="password" placeholder="Senha" name="senha" id="senha">

        </div>
        <div class="field">
            <label for="telefone">Telefone </label>
            <input type="tel" placeholder="Telefone" name="telefone" id="telefone">
        </div>
        <button>Cadastrar</button>

    </form>
</body>
</html>
