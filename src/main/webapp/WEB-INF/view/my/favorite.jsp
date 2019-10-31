<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			$(function(){
				
				$("[name=button]").click(function(){
					
					$(".col-md-9").load("/My/addfavorite");
					
				})
			})
</script>
</head>
<body>
				<h1 >我的收藏夹</h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" style="float: right;" name="button"  class="btn btn-info">添加链接</button>
				<br><br>
				<hr style="border-color: red">
				<table>
				<c:forEach items="${self }" var="s">
				
				<div style="width: 1000px;height: 120px;">
						<h3><a href="${s.url }"  target="blank">${s.text }<a/></h3>
						<br>
						<br>
						时间：<fmt:formatDate value="${s.created }" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;<a>删除</a>
				</div>	
						<hr>
					
					
				</c:forEach>
				</table>
</body>
</html>