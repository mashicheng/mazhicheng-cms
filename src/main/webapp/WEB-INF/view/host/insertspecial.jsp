<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
				<script type="text/javascript">
				
				$(function(){
					
					$("[name=button]").click(function(){
						
						$.ajax({
							url:"/admin/insertspe",
							type:"post",
							data:$("form").serialize(),
							dataType:"json",
							success:function(flag){
								if(flag){
									alert("添加成功")
									 $("#content-wrapper").load("/admin/selspecial");
								}else{
									alert("添加失败")
									 $("h4").text("标题不能为空")
								}
								
							}
							
							
						})
						
					})
					
				})
				
				</script>
</head>
<body>						
						<form>
						<h1 align="center">专题编辑</h1>	
						<div align="center">
						<h4 style="color:red"></h4>
						标题：<input  class="form-control-static" name="title" style="width: 500px;height: 40px" type="text" placeholder="标题" />
						<br><br>摘要：
						<textarea rows="10" style="width: 500px" cols="30"  name="abstrac">
							
						
						</textarea>
						<br>
						<button type="button"  name="button"  class="btn btn-info">添加专题</button>
						</div>
						</form>
</body>
</html>