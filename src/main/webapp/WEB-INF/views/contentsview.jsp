<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RemarkableCRUD</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<form action="/CRUD/contents" method="post">
	<div class="container">
	<input type="hidden" name="bNum" value="${contents.bNum }">
	<input type="hidden" name="bNum" value="${contents.bNum }">
		<table class="table">
			<tr>
				<td>번호</td>
				<td>${contents.bNum}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${contents.bHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td> ${contents.bUser_id}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${contents.bTitle}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="8" cols="80" name="bContents" readonly="readonly">${contents.bContents}</textarea></td>
			</tr>
			<tr>
				<td>댓글</td>
				<td><textarea row="2" cols = "80" name="bReply" id="bReply" ></textarea>
				<input type="submit" id="contents_reply" name="contents_reply" value="댓글달기" ></td>
			</tr>
			<c:forEach var="row" items="${reply}">
				<tr>
					<td>${row.re_Date }</td>
					<td>${row.re_Contents } 
					<a href="${path}/CRUD/delete?re_Num=${row.re_Num}&bNum=${contents.bNum}">삭제</a>
					</td>
					
				</tr>
			
			
			</c:forEach>
			
			
	</table>
				<input type="submit" class="btn btn-default pull-right" id="contents_modify" name="contents_modify" value="수정하기"  >
				<input type="submit" class="btn btn-default pull-right" id="contents_delete" name="contents_delete" value="삭제하기" >
				<input type="submit" class="btn btn-default pull-right" id="contents_reset" name="contents_reset" value="목록으로" >
				
				</div>
	</form>
</body>
</html>