<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
				
			
</script>
</head>
<body>	
<br>		
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
				${error }
				<form action="/My/addfavorites" method="post">
				<input type="text" name="text"  class="form-control"  placeholder="标题描述"><br><br>
				<input type="text" name="url"  class="form-control"  placeholder="链接"><br><br>
				<button  style="float: right;" name="button"  class="btn btn-info">点击收藏</button>
				</form>
</body>
</html>