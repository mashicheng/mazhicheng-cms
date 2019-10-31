<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${sel.title }</title>

<link rel="stylesheet" type="text/css"
	href="/rely/css/bootstrap.min.css" />
</head>
<body>		
				
				<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
				<div class="container" >
		
		<dl>
			<!-- 标题 -->
			<dt>
				<h2 align="center">${sel.title }</h2>
			</dt>
			<!-- 内容 -->
			<dd>${sel.user.username } &nbsp; <fmt:formatDate value="${sel.created }" pattern="yyyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;标签：${sel.uniqueName}</dd>
			<dd>${sel.content }</dd>

		</dl>
	
		

	</div>
		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>