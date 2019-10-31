<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>
		<div>
					<div id="carouselExampleCaptions" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<c:forEach items="${sel}" var="a" varStatus="i">
								<li data-target="#carouselExampleCaptions"
									data-slide-to="${i.index }" class="${i.index==0?"active":"" }"></li>
							</c:forEach>
						</ol>
						<div class="carousel-inner">

							<c:forEach items="${sel}" var="a" varStatus="i">
								<div class="carousel-item ${i.index==0?"active":"" }">
									<img src="/pic/${a.file}" alt="..." width="1000px"
										height="1000px">
									<div class="carousel-caption d-none d-md-block">
										<h5>${a.speak }</h5>

									</div>
								</div>
							</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>



				</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>