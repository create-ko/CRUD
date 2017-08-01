<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RemarkableCRUD</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
.th-left{
	float:left;
}
</style>
</head>
<body>
	<form action="/CRUD/modify" method="post">
		<div class="container">
			<div>
				<h2>게시글 작성</h2>
			</div>
			<div>
				<table>
					<tbody>
						<tr>
							<th>번호</th>
							<th class="th-left"><input type="text" name="bNum" id="bNum" size="70" readonly="readonly" value="${ modify.bNum}"></th>
						</tr>
						<tr>
							<th>제목</th>
							<th class="th-left"><input type="text" name="bTitle" id="bTitle" size="70" value="${ modify.bTitle}"></th>
						</tr>
						<tr>
							<th>작성자</th>
							<th class="th-left"><input type="text" name="bUser_id" id="bUser_id" size="20" value="${ modify.bUser_id}"></th>
						</tr>

						<tr>
							<th>내용</th>
							<th class="th-left"><textarea name="bContents" id="bContents" rows="8" cols="80">${modify.bContents}</textarea></th>
						</tr>
					</tbody>
				</table>
				<div>
					<input type="submit" class="btn btn-default pull-right" id="modify" name="modify" value="수정하기" /> 
					<input type="submit" class="btn btn-default pull-right" id="cancel" name="cancel" value="취소하기" />
				</div>
			</div>


		</div>

	</form>

</body>

</html>