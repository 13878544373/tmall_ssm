<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function() {

        $("#addForm").submit(function() {
            if (checkEmpty("name", "属性名称"))
                return true;
            return false;
        });
    });
</script>

<title>属性管理</title>


<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="${pageContext.request.contextPath}/admin_category_list/1">所有分类</a></li>
		<li><a href="admin_property_list?cid=${c.id}">${c.name}</a></li>
		<li class="active">属性管理</li>
	</ol>



	<div class="listDataTableDiv">
		<table
				class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
			<tr class="success">
				<th>ID</th>
				<th>属性名称</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${ps}" var="p">

				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td><a href="${pageContext.request.contextPath}/admin_property_edit?id=${p.id}"><span
							class="glyphicon glyphicon-edit"></span></a></td>
					<td><a deleteLink="true"
						   href="${pageContext.request.contextPath}/admin_property_delete?id=${p.id}&cid=${c.id}"><span
							class="glyphicon glyphicon-trash"></span></a></td>

				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<ul class="pagination pagination-sm">
		<li><a href="${pageContext.request.contextPath}/admin_property_list?cid=${cid}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
		<li><a href="${pageContext.request.contextPath}/admin_property_list?cid=${cid}">上一页</a>&nbsp;&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/admin_property_list?cid=${cid}">下一页</a>&nbsp;&nbsp;</li>
		<li><a href="${pageContext.request.contextPath}/admin_property_list?cid=${cid}" aria-label="Next">&raquo;</a></li>
	</ul>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增属性</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_property_add">
				<table class="addTable">
					<tr>
						<td>属性名称</td>
						<td><input id="name" name="name" type="text"
								   class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="cid" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/admin/adminFooter.jsp"%>
