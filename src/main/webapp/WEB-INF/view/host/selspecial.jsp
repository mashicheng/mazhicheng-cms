<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
				
				function add(obj){
					
					 $("#content-wrapper").load("/admin/selsparticle?id="+obj); 	
					
				}
				$(function(){
					
					$("[name=button]").click(function(){
						
						 $("#content-wrapper").load("/admin/insertspecial"); 	
						
					})
					
				})
				function update(obj){
					
					 $("#content-wrapper").load("/admin/updatehx?id="+obj); 	
					
				}

</script>		
</head>
<body>

		<button type="button" name="button"   class="btn btn-info">增加专题</button>
				<table class="table table-bordered table-hover">
				  <tr>
				    <th>专题标题</th>
				    <th>专题文章</th>
				    <th>操作</th>
				  </tr>
				  <c:forEach items="${selcount }" var="s">
				  <tr>
				    <td>${s.title }</td>
				    <td>${s.count }篇</td>
				    <td><a href="javascript:void(0)" onclick="update('${s.id }')" >修改专题</a>&nbsp;&nbsp;<a href="javascript:void(0)"  onclick="add('${s.id }')">增加文章</a></td>
				  </tr>
				  </c:forEach>
				</table>

</body>
</html>