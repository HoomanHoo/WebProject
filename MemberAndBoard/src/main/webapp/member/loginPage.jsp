<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="textSet.jsp"%>
<script src="${project}script.js"></script>
<form method="post" action="loginpro.net" name="loginForm" onsubmit="return loginCheck()">
	<table>
		<tr>
			<th colspan="2">${strLogin}</th>
		</tr>
		<tr>
			<th>${strId}</th>
			<td><input type="text" name="id" maxlength="15"></td>
		</tr>
		<tr>
			<th>${strPasswd}</th>
			<td><input type="password" name="passwd" maxlength="30"></td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location='register.net'">
			</th>
		</tr>
	</table>
</form>
