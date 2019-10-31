<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
					
					function button(){
						var id='${selspecial.id}'
							
							$.ajax({
								url:"/admin/addspart",
								type:"post",
								data:{'id':id,'text':$("[name=text]").val()},
								dataType:"json",
								success:function(flag){
									
									if(flag){
										alert("添加成功")
										 $("#content-wrapper").load("/admin/selspecial"); 
										
									}else{
										alert("添加失败")
									}
									
								}
								
							})
					}
					
</script>
</head>
<body>
			
					<h1 align="center">专题文章设置</h1>
			<span style="color:red">专题名称：</span>${selspecial.title }<br>
			<span style="color:red">专题摘要：</span>${selspecial.abstrac }<br>
			<span style="color:red">专题文章：</span>
			<table class="table table-bordered table-hover">
				  <tr>
				    <th>文章ID</th>
				    <th>文章标题</th>
				    <th>文章发布时间</th>
				    <th>操作</th>
				  </tr>
				  <c:forEach items="${selspecial.article }" var="s">
				  <tr>
				    <td>${s.id }</td>
				    <td>${s.title }</td>
				    <td><fmt:formatDate value="${s.created }" pattern="yyyy-MM-dd"/> </td>
				    <td>移除</td>
				  </tr>
				  </c:forEach>
				</table><br>
				
			<input class="form-control-static" type="text" name="text" placeholder="文章ID" />&nbsp;&nbsp;<input class="btn btn-success btn-sm" onclick="button()" name="button" type="button" value="添加">
				
				
</body>	
</html>