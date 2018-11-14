<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <spring:form modelAttribute="emptyuser" action="${pageContext.request.contextPath}/succeessfulLogin.htm" method="POST" class="center">
              <table>
               <tr>
                    <td><spring:label path="username">Username:</spring:label></td>
                    <td><spring:input path="username" /></td>
                </tr>
                <tr>
                    <td><spring:label path="password">Password:</spring:label></td>
                    <td><spring:input path="password" /></td>
                </tr>
        
        <input type="checkbox" id="termsChkbx " onchange="isChecked(this, 'sub1')" />
        <input type="submit" name="submit" value="Submit" id="sub1" disabled="disabled" />
              </table>
        </spring:form>
        
    <script>
        
        function isChecked(checkbox, sub1) {
            document.getElementById(sub1).disabled = !checkbox.checked;
        }   
        
    </script> 
    
    </body>
</html>
