<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<html>
<head>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
</head>
<body>
	<h2>Formulário de cadastro das <i>tasks</i></h2>
	<form action="cadastratask" method="post">
	<h3>Descrição</h3><br />
	<fmt:message key="teste.mensagem" /><br />
	<form:errors path="task.descricao" cssStyle="color:red" /><br />
	<textarea name="descricao" rows="5" cols="100"></textarea><br />
	<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>