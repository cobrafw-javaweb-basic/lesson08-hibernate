<%@ include file="/views/common/common.jsp"%>
<c:if test="${param.current == 'index'}">
	<div class="list-group">
		<a href="<c:url value="/views/el/index.jsp" />" class="list-group-item list-group-item-action">Expression Language</a>
		<a href="<c:url value="/views/jstl/index.jsp" />" class="list-group-item list-group-item-action">Java Standard Tag Lib</a>
	</div>
</c:if>
<c:if test="${param.current == 'el'}">
	<div class="list-group">
		<a href="<c:url value="/views/el/index.jsp" />" class="list-group-item list-group-item-action">Expression Language</a>
		<a href="<c:url value="/views/el/basicExpression.jsp" />" class="list-group-item list-group-item-action">EL - Basic Expression</a>
		<a href="<c:url value="/views/el/calculatorSample.jsp" />" class="list-group-item list-group-item-action">EL - Calculator Sample</a>
		<a href="<c:url value="/views/el/sessionScope.jsp" />" class="list-group-item list-group-item-action">EL - Session Scope Sample</a>
	</div>
</c:if>
<c:if test="${param.current == 'jstl'}">
	<div class="list-group">
		<a href="<c:url value="/views/jstl/index.jsp" />" class="list-group-item list-group-item-action">JSTL - Index</a>
		<a href="<c:url value="/views/jstl/jstlCore.jsp" />" class="list-group-item list-group-item-action">JSTL - Core</a>
		<a href="<c:url value="/views/jstl/jstlSql.jsp" />" class="list-group-item list-group-item-action">JSTL - SQL</a>
	</div>
</c:if>
<c:if test="${param.current == 'error'}">
	<div class="list-group">
		<a href="javascript:history.back();" class="list-group-item list-group-item-action">Go back</a>
	</div>
</c:if>