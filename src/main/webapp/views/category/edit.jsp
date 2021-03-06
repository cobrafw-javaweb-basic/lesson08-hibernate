<%@include file="/views/common/common.jsp"%>
<c:set var="pageTitle" value="Add Category" scope="page"></c:set>
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

			<form action="<c:url value="/edit-category" />" method="post">
				<input type="hidden" name="id" value="${category.id}" />
				<input type="hidden" name="sortNo" value="${category.sortNo}" />
				<div class="row">
					<div class="col-md">
						<div class="form-group">
							<label for="name">Name:</label>
							<input type="text" class="form-control" name="name" id="name" placeholder="Category name" value="${category.name}">
						</div>
					</div>
					<div class="col-md">
						<div class="form-group">
							<label for="fatherId">Father Category:</label>
							<select class="form-control" name="fatherId" id="fatherId">
								<option value="0">--------------------------------</option>
								<c:forEach var="father" items="${listCategories}">
									<c:if test="${father.id == category.fatherId}">
										<option value="${father.id}" selected="selected">${father.name}</option>
									</c:if>
									<c:if test="${father.id != category.fatherId}">
										<option value="${father.id}">${father.name}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<button type="reset" class="btn btn-warning">Reset</button>
					<a href="<c:url value="/list-categories" />" class="btn btn-danger">Back</a>
				</div>

			</form>
		</div>

		<jsp:include page="/views/common/footer.jsp">
			<jsp:param name="current" value="Categories" />
		</jsp:include>
	</div>
</body>
</html>