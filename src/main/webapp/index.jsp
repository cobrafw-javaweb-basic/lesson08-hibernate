<%@include file="/views/common/common.jsp"%>
<c:set var="pageTitle" value="Maven Sample Project" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/views/common/head.jsp"%>
</head>
<body>
	<div class="container">
		<jsp:include page="/views/common/header.jsp">
			<jsp:param name="current" value="index" />
		</jsp:include>

		<div class="content row">
			<div class="col-12 page-content">
				<h1 class="page-title">${pageTitle}</h1>
				<p>
					In this lesson, we will work with:
				</p>
				<ul>
					<li>
						<a href="<c:url value="/list-categories" />">Manage Categories</a>
					</li>
				</ul>
			</div>
		</div>

		<jsp:include page="/views/common/footer.jsp">
			<jsp:param name="current" value="index" />
		</jsp:include>
	</div>
</body>
</html>