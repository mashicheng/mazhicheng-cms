<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
					
					
			
</script>
</head>
<body>	
				<form action="/My/up" method="post">        
				<div align="center">
				<input type="hidden" value="${user.id }" name="id">
				昵称：<input type="text" name="username" value="${user.username }"  class="form-control-sm"  ><br><br>
				生日：<input type="text" name="birthday" value='<fmt:formatDate value="${user.birthday }" pattern='yyyy-MM-dd' />'  class="form-control-sm"  ><br><br>
				
				性别：<input type="radio" name="gender" value="1" ${user.gender==1?'checked':'' } class="form-control-sm"  >男
					<input type="radio" name="gender" value="0" ${user.gender==0?'checked':'' } class="form-control-sm"  >女<br><br>
				手机：<input type="text" name="mobile" value="${user.mobile}"  class="form-control-sm"  ><br><br>
				邮箱：<input type="text"  name="mail" value="${user.mail}" class="form-control-sm"  ><br><br>
				地址：<input type="text" name="address"   value="${user.address}" class="form-control-sm"  ><br><br>
				星座：<input type="text" name="constellation"  value="${user.constellation}"  class="form-control-sm"  ><br><br>
				座右铭：<textarea rows="10" style="width: 250px" cols="30"  name="motto">
							${user.motto}
						</textarea>
				<button class="btn btn-success btn-sm">提交</button>
				</div>
				</form>
</body>
</html>