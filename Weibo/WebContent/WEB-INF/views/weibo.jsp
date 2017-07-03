<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
                <li><a href="">欢迎您，${curr_user.username}</a></li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-body">
                <form action="/send" method="post">
                    <div class="form-group">
                        <label>你有什么新鲜事</label>
                        <textarea name="message.message" id="" class="form-control"></textarea>
                    </div>
                    <button class="btn btn-primary">发布</button>
                </form>
            </div>
        </div>

		<c:forEach items="${messageList }" var="msg">
	        <div class="panel panel-default">
	            <div class="panel-body">
	                <div class="media">
	                    <div class="media-left">
	                        <img src="img/1.jpg" width="64" alt="" class="media-object img-circle">
	                    </div>
	                    <div class="media-body">
	                        <h5 class="media-heading">${msg.user.username }</h5> 
	                        <p>${msg.message }</p>
	                        <span class="text-muted">发布于<fmt:formatDate value="${msg.createTime}" pattern="yyy:MM:dd HH:mm:ss" /></span>
	                    </div>
	                </div>
	            </div>
	        </div>
        </c:forEach>


    </div>
</body>
</html>