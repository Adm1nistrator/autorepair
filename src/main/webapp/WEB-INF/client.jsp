<%@page import="autorepair.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="clientDao" type="autorepair.ClientDao" scope="request"/>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Contact</title>

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href=".././css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src=".././js/jquery-2.2.0.min.js"></script>
    <script type="text/javascript" src=".././js/materialize.min.js"></script>
    <script type="text/javascript" src=".././js/jquery.maskedinput.js"></script>

    <script type="text/javascript">
        jQuery(function ($) {
            $("#telephone").mask("+7(999) 999-9999");
        });
    </script>
</head>

<body>

<div class="container">
    <h1>Добавление нового клиента</h1>

    <form class="form-inline" method="POST" action="client.html">

        <div class="row">
            <div class="input-field col s6">
                <label for="first_name">Имя</label>
                <input type="text" name="firstName" class="form-control" id="first_name" placeholder="Введите имя">
            </div>

            <div class="input-field col s6">
                <label for="last_name">Фамилия</label>
                <input type="text" name="lastName" class="form-control" id="last_name" placeholder="Введите Фамилию">
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <label for="telephone">Номер телефона</label>
                <input type="tel" id="telephone" name="telephoneNumber" placeholder="Введите номер телефона:">
            </div>

            <div class="input-field col s6">
                <label for="email">Email</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="Введите e-mail адрес:">
            </div>
        </div>

        <button class="btn waves-effect waves-light" type="submit" name="action">Добавить
            <i class="material-icons right">send</i>
        </button>

    </form>

    <hr>
    <ol>
        <% for (Client client : clientDao.getAllClient()) { %>
        <li><%= client %>
        </li>
        <% } %>
    </ol>
    <hr>

</div>
</body>
</html>