<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CMS热点新闻</title>

	
</head>
<body>		
			<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
			<div class="" style="margin-left: 250px;margin-right: 200px;">
			
					
			<div class="row">
			<!-- 左边 -->
			<div class="col-md-2" >
			<span style="font: bolder;font-size: 50px">CMS系统</span>
			<button type="button" value="" id="hots" name="button" onclick="leftbutton(this)" class="list-group-item btn btn-primary btn-lg list-group-item-action" date="${art.channelId}"  style="${art.channelId==null?"background-color: #c0c0c0;color:white":""}">热门</button>
			<c:forEach items="${left }" var="l">
			<div class="list-group">
			  <button type="button"  name="button"  value="${l.id}" onclick="leftbutton(this)" class="list-group-item btn btn-primary btn-lg list-group-item-action" style="${art.channelId==l.id ? "background-color: #c0c0c0;color:white":""}">${l.name }</button>
			</div>
			</c:forEach>
			
			</div>
			<!-- 中间 -->
			<div id="list" class="col-md-7 split min_h_500">
			<!-- 轮播图 -->
			<div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
			
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      <img src="/pic/1.jpg" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="/pic/2.jpg" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="/pic/3.jpg" class="d-block w-100" alt="...">
					    </div>
					  </div>
					  <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
					<br><br>
					<div ">
					<ul id="c" class="nav nav-tabs">
						<li id="p"  class='nav-item' name="categoryId" onclick="heng(this)" value="" style="${art.categoryId==null?"background-color: #c0c0c0;":""}"><a href="/index/goindex?categoryId=${h.id }&channelId=${art.channelId}" class='nav-link'>全部</a></li>
					<c:forEach items="${heng }" var="h">
					 	<li  class='nav-item' name="categoryId" onclick="heng(this)" value="${h.id }" style="${art.categoryId==h.id ?"background-color: #c0c0c0;":""}"><a href="/index/goindex?categoryId=${h.id }&channelId=${art.channelId}" class='nav-link'>${h.name }</a></li>
					</c:forEach>  
					</ul>
					
					<!-- 文章列表 -->
					<ul class="list-unstyled">
					<c:forEach items="${ selall}" var="s">
					  <li class="media">
					    <img src="/pic/${s.picture }" class="mr-3" style="width: 160px;height: 150px" alt="...">
					    <div class="media-body">
					      <h2 class="mt-0 mb-1"><a href="/index/sel_artblob?id=${s.id }" target='blank'>${s.title }</a></h2>
					      <strong>${s.user.username }</strong>&nbsp;&nbsp;发布时间:<fmt:formatDate value="${s.created }" pattern="yyyy-MM-dd"/>&nbsp;&nbsp;标签：${s.uniqueName}
					    </div>
					  </li>
					  <br>
					 </c:forEach>
					</ul>
					<div>${page }</div>
					</div>
			
			</div>
			<!-- 右边 -->
			<div class=" split min_h_500" id="index">
			<div class="card bg-light mb-4" style="max-width: 350px;">
						  <div class="card-header"><strong>24小时热文</strong></div>
						  <div class="card-body">
						
							 <ul  id="me" class="list-unstyled">
							 <c:forEach items="${hot24 }" var="h">
								 <li class='media'>
								 	<img style="width: 80px;height: 80px" src="/pic/${h.picture }" class="mr-3" alt="...">
									 <div class='media-body'>
										 <a href="/index/sel_artblob?id=${h.id }" style="text-decoration:none;color:black;" target="blank">${h.title }<a/>
									 </div>
								 </li>
								 <hr>
							</c:forEach>
							 </ul>
						  
						</div>
			</div>
			<div class="card bg-light mb-4" style="max-width: 350px;">
						  <div class="card-header"><strong>最新文章</strong></div>
						  <div class="card-body">
						
						<ul  id="newcontent" class='list-unstyled'>
						 <c:forEach items="${newhot }" var="h">
								 <li class='media'>
								 	<img style="width: 80px;height: 80px" src="/pic/${h.picture }" class="mr-3" alt="...">
									 <div class='media-body'>
										 <a href="/index/sel_artblob?id=${h.id }" style="text-decoration:none;color:black;" target="blank">${h.title }<a/>
									 </div>
								 </li>
								 <hr>
							</c:forEach>
						</ul>
							
						  
						</div>
			</div>
			<div class="card bg-light mb-4" style="max-width: 350px;">
						  <div class="card-header"><strong>精彩图集</strong></div>
						  <div class="card-body">
						
						<ul  id="newcontent" class='list-unstyled'>
						 <c:forEach items="${selpics }" var="h">
								 <li class='media'>
								 	<img style="width: 80px;height: 80px" src="/pic/${h.picture }" class="mr-3" alt="...">
									 <div class='media-body'>
										 <a href="/index/sel_artblob?id=${h.id }" style="text-decoration:none;color:black;" target="blank">${h.title }<a/>
									 </div>
								 </li>
								 <hr>
							</c:forEach>
						</ul>
							
						  
						</div>
			</div>
			
			<div class="card bg-light mb-4" style="max-width: 350px;">
						  <div class="card-header"><strong>精彩图集</strong></div>
						  <div class="card-body">
						
						<ul  id="newcontent" class='list-unstyled'>
						 <c:forEach items="${selspecial }" var="h">
								 <h1 style="color:red">${h.title }</h1>
							<h4>${h.abstrac }</h4><br>
							<ul>
								<c:forEach items="${h.article }" var="s" varStatus="count">
								<li><a href="/index/sel_artblob?id=${s.id }" target="blank">${s.title }</a></li>
								</c:forEach>
							</ul>
							
								 
								 
								 
							</c:forEach>
						</ul>
							
						  
						</div>
			</div>
			
			
			</div>
			<jsp:include page="/WEB-INF/view/common/footer.jsp"></jsp:include>
			
</body>
<script type="text/javascript">
			
			function leftbutton(obj){	
				
				location="/index/goindex?channelId="+$(obj).val();
				
			}
			$(function(){
				
				$(".page-link").click(function(){
					
					location=$(this).attr("data");
					
				})
				
			})
</script>
</html>