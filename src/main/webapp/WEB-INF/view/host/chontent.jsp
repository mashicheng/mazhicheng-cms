<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/rely/css/bootstrap.min.css" />
<title>${content.title }</title>
		<script type="text/javascript">
		$(function(){
		
			
			$("[name=button]").click(function(){
				
				$("#content-wrapper").load("/admin/sel_article");
				
			})
			$("[name=sh]").click(function(){
				var id='${content.id}';
				$.ajax({
					url:"/admin/updcontent",
					type:"post",
					data:{'id':id,'stat':$(this).val()},
					dataType:"json",
					success:function(flag){
						
						if(flag){
							alert("操作成功");
							$("#content-wrapper").load("/admin/sel_article");
						}else{
							alert("操作失败")
						}
						
					}
					
				})
				
			})
			
			
		})
		</script>
</head>
<body>			
			<div class="container">
			<button type="button" name="sh" value="1" class="btn btn-success">已审通过</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" name="sh" value="2" c class="btn btn-danger">驳回</button>
			<button type="button" name="button" style="float: right;"  class="btn btn-info">待审返回</button>
  						<dl>
  							<dt>
  								<h2 align="center">${content.title }</h2>
  							</dt>
  							<dd>${content.user.username }&nbsp;<fmt:formatDate value="${content.created }"/>&nbsp;&nbsp;标签：${content.uniqueName}</dd>
  							<dd>${content.content }</dd>
  						
  						</dl>
  			</div>
</body>
</html>