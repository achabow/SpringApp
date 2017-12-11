<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Image
</h1>

<c:url var="addAction"  value="/image/add"></c:url>

<form:form action="${addAction}" commandName="image">
<table>
	<c:if test="${!empty image.fileName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="fileName">
				<spring:message text="Title"/>
			</form:label>
		</td>
		<td>
			<form:input path="fileName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="fileDescription">
				<spring:message text="Opis"/>
			</form:label>
		</td>
		<td>
			<form:input path="fileDescription" />
		</td> 
	</tr>
	<tr>
		<form:label path="fileDescription">
         <td>
         
         <input type="file" name="file_data" size="50"/>
        
         </td>
         </form:label>
     </tr>
     	<tr>
		<td colspan="2">
			<c:if test="${!empty image.fileName}">
				<input type="submit"
					value="<spring:message text="Edit Image"/>" />
			</c:if>
			<c:if test="${empty image.fileName}">
				<input type="submit"
					value="<spring:message text="Add Image"/>" />
			</c:if>
		</td>
	</tr>
</table>
</form:form>
<br>
<h3>Images list</h3>
<c:if test="${!empty listImages}">
	<table class=tg>
	<tr>
		<th width="80">Image ID</th>
		<th width="120">Image Name</th>
		<th width="120">Image Description</th>
		<th width ="80">Image Data</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listImages}" var="image">
	<tr>
		<td>${image.id}</td>
		<td>${image.fileName}</td>
		<td>${image.fileDescription}</td>
		<td>${image.fileData}</td>
		<td><a href="<c:url value='/edit/${image.id}' />" >Edit</a></td>
		<td><a href="<c:url value='/remove/image/${image.id}' />" >Delete</a></td>
	</tr>	
	</c:forEach>
	</table>
</c:if>
</body>
</html>