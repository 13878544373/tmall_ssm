

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<script>
	function change() {
		var num = $("#num").val();
		location.href = "../list/" + num;
	}
</script>
<nav>
	<ul class="pagination pagination-sm">
		<li><a href="${pageContext.request.contextPath}/admin_category_list/1" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
		<li><a href="${pageContext.request.contextPath}/admin_category_list/${sp-1 }">上一页</a>&nbsp;&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/admin_category_list/${sp+1 }">下一页</a>&nbsp;&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/admin_category_list/${pageCounts }" aria-label="Next">&raquo;</a></li>
	</ul>
</nav>