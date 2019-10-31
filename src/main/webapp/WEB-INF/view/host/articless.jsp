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
                                                                                                                                       

</head>

<body>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="form-control-static"  value="${string }" type="text" name="string" placeholder="查询" />
		<select class="form-control-sm" name="hits">
			<option value="0">未审</option>
			<option value="1">已审</option>
			<option value="2">驳回</option>
		</select>
		
		
		&nbsp;&nbsp;<input class="btn btn-success btn-sm" name="button" type="button" value="查询">
	<br>
	
	<table class="table table-bordered table-hover" style="text-align: center;font-weight: bolder;" >
		<tr>
			<td>序号</td>
			<td>文章标题</td>
			<td>文章标签</td>
			<td>作者</td>
			<td>昵称</td>
			<td>发布时间</td>
			<td>文章状态</td>
			<td>点击量</td>
			<td>是否热门</td>
		</tr>

		<c:forEach items="${aselect }" var="a" varStatus="index">
		
			<tr>
				<td>${a.id }</td>
				<td><a href="javascript:void(0)" name="tit" value="${a.id }">${a.title }<a/></td>
				<td>${a.uniqueName}</td>
				<td>${a.user.username }</td>
				<td>${a.user.nickname }</td>
				<td>
				<fmt:formatDate value="${a.created }" pattern="yyyy-MM-ss"/>
				</td>
				<td>
				<c:if test="${a.status==1 }">
				已审
				</c:if>
				<c:if test="${a.status==0 }">
				未审
				</c:if>
				<c:if test="${a.status==2 }">
				驳回
				</c:if>
				</td>
				<td>${a.hits }</td>
				<td><c:if test="${a.hot==1 }">
					<button  type="button" class="btn btn-success" onclick="hot('${a.id}',this)">是</button>
					</c:if>
					<c:if test="${a.hot==0 }">
					<button   type="button" class="btn btn-danger" onclick="hot('${a.id}',this)">否</button>
					</c:if></td>
			</tr>

		</c:forEach>
	</table>	
	<div>${page }</div>
</body>
		<script type="text/javascript">
			$(function(){
				
				$("[name=button]").click(function(){
					
					 $("#content-wrapper").load("/admin/sel_article?string="+$("[name=string]").val()+"&hits="+$("[name=hits]").val()); 
					
				})
				$(".page-link").click(function(){
					
					 $("#content-wrapper").load($(this).attr("data"));
					
				})
				$("[name=tit]").click(function(){
					
					 $("#content-wrapper").load("/admin/sel_status?id="+$(this).attr("value")); 
					
				})
			})
			function hot(id,obj){
				var ho= $(obj).text()=="是"?0:1;
			
				$.ajax({
					url:"/admin/updatehot",
					type:"post",
					data:{'id':id,'hot':ho},
					dataType:"json",
					success:function(flag){
						if(flag){
							ho==1?$(obj).text("是"):$(obj).text("否");
							ho==1?$(obj).attr("class","btn btn-success"):$(obj).attr("class","btn btn-danger")
						}else{
							alert("数据失败");
						}
					
					}
					
				})
			}
		</script>
</html>