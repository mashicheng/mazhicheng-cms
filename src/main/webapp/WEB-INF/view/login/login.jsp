<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>欢迎登陆</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
	<br>
	<div class="container">
		<div class="row passport_bg">

			<div class="col-md-6">
					<br><br><br><br>	
				<div class="card" style="width: 18rem;">
				
				  <div class="card-body">
				  <p style="color:red">${error }</p>
				  <form id="form" action="/rep/gologin" method="post">
				 <label for="a">用户名：</label>
				 	<input id="a" class="form-control" name="username" value="${repname }" type="text" /><br>
				 <label for="b">密码： </label>
					<input id="b" class="form-control"  type="password" name="password"/><br>
				 
				   <button name="yes"   class="btn btn-success">登陆</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <button name="not" type="button" class="btn btn-info">注册</button>
				 </form>
				  </div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="passport_r">
					<h3>最新加入的用户：</h3>
					<p align="center">
						<img src="/rely/images/guest.jpg" alt="..."
							class="rounded-circle img-thumbnail" /> &nbsp;&nbsp;&nbsp;&nbsp;
						<img src="/rely/images/guest1.jpg" alt="..."
							class="rounded-circle img-thumbnail" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<div>
		<br /> <br />
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
<script type="text/javascript">
			$(function(){
				
				
				$("#form").validate({
					rules:{
						username:{
							required:true
						},password:{
							rangelength:[2,5],
							required:true,	
						}
					},messages:{
						username:{
							required:"用户名不能为空"
						},password:{
							rangelength:"长度为2-5",
							required:"密码不能为空",	
						}
					}
					
					
				})
				$("[name=not]").click(function(){
					
					location="/rep";
					
				})
			})
		
</script>

</html>