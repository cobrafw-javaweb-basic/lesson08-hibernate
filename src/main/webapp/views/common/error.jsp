<%@ include file="/views/common/common.jsp"%>
<%@ page isErrorPage="true"%>
<c:set var="pageTitle" value="Error Page" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@include file="head.jsp"%>
	<title>Lesson 05 - System Error Page</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/views/common/header.jsp">
			<jsp:param name="current" value="error" />
		</jsp:include>

		<div class="content row">
			<div class="col-9 page-content">
				<h1 class="page-title">OOOPS! Something wrong.</h1>
				<p><%= exception.toString() %></p>
			</div>
			<div class="col-3 page-sidebar">
				<jsp:include page="/views/common/sidebar.jsp">
					<jsp:param name="current" value="error" />
				</jsp:include>
			</div>
		</div>

		<jsp:include page="/views/common/footer.jsp">
			<jsp:param name="current" value="error" />
		</jsp:include>
	</div>
</body>
</html>