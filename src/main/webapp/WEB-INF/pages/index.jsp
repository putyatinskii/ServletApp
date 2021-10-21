<html>
<body>
<div align="center">
<h1>Добавление студентов</h1>
<%@ page contentType="text/html;charset=utf-8" %>
<form action="add-student" method="post">
    <table>
		<tr>
			<td>ФИО студента</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>Средний балл</td>
			<td><input type="text" name="mark" /></td>
		</tr>
		<tr>
			<td>Знание блокчейна</td>
			<td><input type="checkbox" name="blockchain" value="blockchain"></td>
		</tr>
	</table>
    <input type="submit" value="Добавить" />
</form>
<form action="list-of-students" method="get">
		<label for="isBlockchain">Показать только знатоков блокчейна</label>
        <input type="checkbox" name="isBlockchain" value="isBlockchain">
        <label for="isGenius">Показать только отличников</label>
        <input type="checkbox" name="isGenius" value="isGenius">
        <input type="submit" value="Показать список студентов" />
</form>
</div>
</body>
</html>