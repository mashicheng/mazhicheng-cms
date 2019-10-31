<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			$(function(){
				
				$("#add").click(function(){
					
					$("#card").append("<div name='card' class='card' style='width: 20rem;float: left;'><div class='card-body'><input type='file' name='files'  style='height:  40px;border-color: #c0c0c0' class='form-control-sm'><br>描述：<br><textarea style='width: 200px;height: 200px' name='speak'></textarea></div></div>");
					
				})
				$("#push").click(function(){
					
					var formData = new FormData($( "#form" )[0]);
					 $.ajax({
						 type:"post",
						 url:"/My/pushpics",
						 data : formData,
						// 告诉jQuery不要去处理发送的数据
						 processData : false,
						 // 告诉jQuery不要去设置Content-Type请求头
						 contentType : false,
						 success:function(flag){
							 if(flag){
								 alert("发布成功");
								 $(".col-md-9").load("/My/showmyarticle?id="+${sessionScope.user.id });
							 }else{
								 alert("发布失败,试试重新登录后再发布")
							 }
						 }
						 
					 })
					
				})
			})
			

</script>
</head>
<body>
		
			<button type="button" id="add" class="btn btn-warning">增加图片</button>&nbsp;&nbsp;<button type="button" id="push" class="btn btn-info">发布图片</button>
			<form id="form">
			<br><br>	<input type="text" name="title"  style="height: 40px;width:500px;border-color: #c0c0c0;" placeholder="图片标题" class="form-control-sm"><br><br>
			<div id="card" class="card" style="border:  1px solid red">
				<div name="card"  class="card" style="width: 20rem;float: left;">
				  <div class="card-body">
				 	<input type="hidden" name="userId" value="${sessionScope.user.id }">
				    <input type="file" name="files"  style="height:  40px;border-color: #c0c0c0" class="form-control-sm">
				    <br>描述：<br>
				    <textarea style="width: 200px;height: 200px" name="speak">
				    	
				    	
				    </textarea>
				  </div>
				</div>
			</div>
			</form>

</body>
</html>