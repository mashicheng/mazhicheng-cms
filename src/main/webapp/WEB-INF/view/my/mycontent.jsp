<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${content.title }</title>
<link rel="stylesheet" type="text/css"
	href="/rely/css/bootstrap.min.css" />
<script type="text/javascript">
				$(function(){
					var id='${content.user.id }'
					$("[type=button]").click(function(){
						
						$(".col-md-9").load("/My/showmyarticle?id="+id);
						
					})
					
					
				})


</script>
</head>
<body>
  						
  						<div class="container">
  						
  						<button type="button" style="float: right;"  class="btn btn-info">返回</button>
  						<dl>
  							<dt>
  								<h2 align="center">${sel.title }</h2>
  							</dt>
  							<dd>${sel.user.username }&nbsp;<fmt:formatDate value="${sel.created }"/>&nbsp;&nbsp;标签：${sel.uniqueName}</dd>
  							<dd>${sel.content }</dd>
  						
  						</dl>
  						</div>
</body>
</html>