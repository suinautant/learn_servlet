<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서테이블 입력</h1>
	<form action="/insert.dp" method="post">
		<div>
			<label for="deptno">부서 번호 : </label>
			<input type="text" name="deptno" />
		</div>
		<div>
			<label for="dname">부서 이름 : </label>
			<input type="text" name="dname" />
		</div>
		<div>
			<label for="loc">부서 위치 : </label>
			<input type="text" name="loc" />
		</div>
		<input type="submit" /> &nbsp;<input type="reset" />
	</form>

</body>
</html>