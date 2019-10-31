<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员后台</title>
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入  css -->
<link rel="stylesheet" href="/rely/css/bootstrap.min.css">
<!-- 后台页面样式模板 -->
<link rel="stylesheet" href="/rely/css/sb-admin.css">
<link rel="stylesheet" href="/rely/css/all.min.css">
<style type="text/css">
 body{
	  background:url("/rely/images/baby-blue-sky-carefree-1166990.jpg");
		height:100%;
		width:100%;
		overflow: hidden;		
		background-size:cover;
  }
</style>                                                                                                                                        
<script type="text/javascript">
	 	$(function(){
			$("[name=button]").click(function(){
				 $("#content-wrapper").load("/admin/sel_users?username="+$("[name=username]").val()); 
			})
			
			$(".page-link").click(function(){
				
				$("#content-wrapper").load($(this).attr("data")); 
				
			})
		}) 
		
		function update(id,log){		
			
			var lock=$(log).text()=="正常"?0:1;
		
			$.ajax({
				url:"/admin/updatelocked",
				type:"post",
				data:{'id':id,'locked':lock},
				dataType:"json",
				success:function(flag){
					
					if(flag){
						$(log).text(lock==0?"停用":"正常");
						lock==1 ?$(log).attr("class","btn btn-success") :$(log).attr("class","btn btn-danger")
					}else{
						alert("操作失败")
					}
					
				}
				
			})
		}
</script>
</head>

<body>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="form-control-static" value="${username }" type="text" name="username" placeholder="查询用户" />&nbsp;&nbsp;<input class="btn btn-success btn-sm" name="button" type="button" value="查询">
<br>
	<table class="table table-bordered table-hover" style="text-align: center;font-weight: bolder;" >
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>昵称</td>
			<td>生日</td>
			<td>状态</td>
			<td>角色</td>
			<td>注册日期</td>
			<td>修改日期</td>
		</tr>

		<c:forEach items="${select }" var="u" varStatus="index">
			<tr>
				<td>${index.index+1 }</td>
				<td>${u.username }</td>
				<td>${u.nickname }</td>
				<td><fmt:formatDate value="${u.birthday }" pattern="yyyy-MM-ss"/></td>
				<td>
					<c:if test="${u.locked==1 }">
					<button  type="button" class="btn btn-success" onclick="update('${u.id}',this)">正常</button>
					</c:if>
					<c:if test="${u.locked==0 }">
					<button   type="button" class="btn btn-danger" onclick="update('${u.id}',this)">停用</button>
					</c:if>
				
				</td>
				<td>${u.role }</td>
				<td><fmt:formatDate value="${u.created }" pattern="yyyy-MM-ss"/></td>
				<td><fmt:formatDate value="${u.updated}" pattern="yyyy-MM-ss"/></td>
			</tr>

		</c:forEach>
	</table>
	
	<div>${page }</div>

</body>
</html>