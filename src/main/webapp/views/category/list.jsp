<%@include file="/views/common/common.jsp"%>
<c:set var="pageTitle" value="List Categories" scope="page"></c:set>
<!DOCTYPE html>
<html>
<head>
	<%@include file="/views/common/head.jsp"%>
</head>
<body>
	<div class="container">
		<jsp:include page="/views/common/header.jsp">
			<jsp:param name="current" value="Categories" />
		</jsp:include>

		<div class="content">
			<h1 class="page-title">${pageTitle}</h1>

			<div>
				<p><a href="<c:url value="/add-category" />" class="btn btn-primary">Create new category</a></p>
			</div>

			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${listCategories}">
						<tr>
							<td>${category.id}</td>
							<td><strong>${category.name}</strong></td>
							<td>
								<a href="<c:url value="/edit-category?id=${category.id}" />">Edit</a>
								<a href="<c:url value="/delete-category?id=${category.id}" />">Delete</a>
							</td>
						</tr>
						<c:forEach var="subCategory" items="${category.categories}">
							<tr>
								<td>${subCategory.id}</td>
								<td>- ${subCategory.name}</td>
								<td>
									<a href="<c:url value="/edit-category?id=${subCategory.id}" />">Edit</a>
									<a href="<c:url value="/delete-category?id=${subCategory.id}" />">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<jsp:include page="/views/common/footer.jsp">
			<jsp:param name="current" value="Categories" />
		</jsp:include>
	</div>
</body>
</html>