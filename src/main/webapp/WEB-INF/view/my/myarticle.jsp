<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			$(function(){
				
				$("[name=hrefa]").click(function(){
					
					
					$(".col-md-9").load($(this).attr("data")+"?id="+$(this).attr("value"));
					
				})
				
				$("#sel_tit").click(function(){
					var id=${sessionScope.user.id };
					$(".col-md-9").load("/My/showmyarticle?id="+id+"&tit="+$(".form-control-sm").val());
					
				})
				$(".page-link").click(function(){
						
					var id=${sessionScope.user.id };
					$(".col-md-9").load($(this).attr("data"));
						
				})
				
				
			})
			function update(obj){
				$(".col-md-9").load("/My/myupdateart?id="+$(obj).val());
			}
			function delet(obj){
				
				if(confirm("是否删除？")){
					$(".col-md-9").load("/My/mydelete?id="+$(obj).val());
				}
				
			}
			
</script>
</head>
<body>
			
				 <div class="form-group">
				    <form>
				    <input type="text" value="${tit }" style="height:  40px" class="form-control-sm"  placeholder="文章标题">&nbsp;&nbsp;&nbsp;&nbsp;
				    <button type="button" id="sel_tit" class="btn btn-info">搜索</button>
				    </form>
				  </div>
				<br>
				<div class="table-responsive">
				  <table class="table">
				    <tr>
				    <th>序号</th>
					<th>文章标题</th>
					<th>文章标签</th>
					<th>作者</th>
					<th>昵称</th>
					<th>发布时间</th>
					<th>文章状态</th>
					<th>点击量</th>
					<th>是否热门</th>
					<th>操作</th>
				  	</tr>
				  	<c:forEach items="${sel }" var="s" varStatus="count">
				  	<tr>
				  		<td>${count.count }</td>
				  		<td><a data="/My/selmycontent" name="hrefa" value="${s.id }" href="javascript:void(0)">${s.title }<a/></td>
				  		<td>${s.uniqueName}</td>
				  		<td>${s.user.username }</td>
				  		<td>${s.user.nickname }</td>
				  		<td><fmt:formatDate value="${s.created }" pattern="yyyy-MM-dd"/></td>
				  		<td>
				  		<c:if test="${s.status==0 }">
				  		未审
				  		</c:if>
				  		<c:if test="${s.status==1 }">
				  		已审
				  		</c:if>
				  		<c:if test="${s.status==2 }">
				  		驳回
				  		</c:if>
				  		</td>
				  		<td>${s.hits }</td>
				  		<td>${s.hot==1?"热门":"非热门" }</td>
				  		<td><button type="button" onclick="update(this)" value="${s.id }" class="btn btn-info">修改</button>
				  			<button type="button" onclick="delet(this)" value="${s.id }" class="btn btn-danger">删除</button>
				  		</td>
				  	</tr>
				  	
				  	</c:forEach>
				  </table>
				</div>	
			<div>${page }</div>	
</body>
</html>