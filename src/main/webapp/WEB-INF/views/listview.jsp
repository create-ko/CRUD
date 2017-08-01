<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RemarkableCRUD</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<form action="/CRUD/form" method="post">
	<div class="container">
	
				
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성시간</th>
					<th>닉네임</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="row" items="${list}">
					<tr>
						<td>${row.bNum}</td>
						<td><a href="/CRUD/contentsview?bNum=${row.bNum}">${row.bTitle}</a></td>
						<td>${row.bDate}</td>
						<td>${row.bUser_id}</td>
						<td>${row.bHit}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

			<c:if test="${pages.start_num != 1}">
				<a href="/CRUD/${pages.start_num - 1 }">이전</a>
			</c:if>
			<c:forEach var="i" begin="${pages.start_num }" end="${pages.end_num }">
			<a href="/CRUD/${i}" > ${i}</a>
			</c:forEach>
			
			<c:if test="${true }">
				<a href="/CRUD/${pages.end_num +1 }">다음</a>
			</c:if>
			
			
		<input type="submit" class="btn btn-default pull-right" id="writeview" name="writeview" value="글쓰기" />


</div>
	</form>
	
</body>

</html>