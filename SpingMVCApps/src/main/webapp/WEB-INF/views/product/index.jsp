<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
</head>
<body>

    <h3>Add New Product</h3>
    <s:form method="post" modelAttribute="product"
        action="${pageContext.request.contextPath }/product/save">
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <s:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>Price</td>
                <td>
                    <s:input type="number" step="0.01" path="price"/>
                </td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td>
                    <s:input type="number" path="quantity"/>
                </td>
            </tr>
            <tr>
                <td>Description</td>
                <td>
                    <s:textarea path="description" cols="20" rows="5"/>
                </td>
            </tr>
            <tr>
                <td>Status</td>
                <td>
                    <s:checkbox path="status"/>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </s:form>

</body>
</html>