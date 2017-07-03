<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body {
            padding-top:70px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a href="" class="navbar-brand">WeiBo</a>
            </div>
            <ul class="nav navbar-nav pull-right">
                <li><a href="/reg">注册</a></li>
                <li class="active"><a href="">登录</a></li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                用户登录
            </div>
            <div class="panel-body">
            	<c:if test="${param.code == 1001 }">
            		<div class="alert alert-success">账户注册成功,请登录</div>
            	</c:if>
            	<c:if test="${param.code == 1002 }">
            		<div class="alert alert-danger">账号或密码错误</div>
            	</c:if>
            	<c:if test="${param.code == 1003 }">
            		<div class="alert alert-danger">请登录后继续操作</div>
            	</c:if>
                <form action="/userlogin" method="post">
                    <div class="form-group">
                        <label>账号</label>
                        <input type="text" name="user.username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" name="user.password" class="form-control">
                    </div>
                    <button class="btn btn-success">登录</button>
                    <a href="/reg">注册</a>
                </form>
            </div>
        </div>
    </div>
</body>
</html>