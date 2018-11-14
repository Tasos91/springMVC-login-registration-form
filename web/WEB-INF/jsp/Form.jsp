<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>

<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
                var allowsubmit = false;
        $(function(){
            $('#password_confirm').keyup(function(e){
               
                var pass = $('#password').val();
                var confpass = $(this).val();
                if(pass == confpass){
                    
                    $('.error').text('');
                    allowsubmit = true;
                }else{
                    
                    $('.error').text('Password not match!');
                    allowsubmit = false;
                }
            });
            
           
            $('#checking').submit(function(){
            
                var pass = $('#password').val();
                var confpass = $('#password_confirm').val();
 
                
                if(pass == confpass){
                           allowsubmit = true;
                }
                if(allowsubmit){
                    return true;
                }else{
                    return false;
                }
            });
        });    
                    
        </script>
    </head>
    <body>
        <h3>Welcome, Enter The User Details</h3>
        <spring:form modelAttribute="emptyuser" id="checking" action="${pageContext.request.contextPath}/formhandling.htm" method="POST">
             <table>
                <tr>
                    <td><spring:label path="firstname">Name:</spring:label></td>
                    <td><spring:input path="firstname" /></td>
                </tr>
                <tr>
                    <td><spring:label path="surname">Last Name:</spring:label></td>
                    <td><spring:input path="surname" /></td>
                </tr>
                <tr>
                    <td><spring:label path="username">Username:</spring:label></td>
                    <td><spring:input path="username" /></td>
                </tr>
                <tr>
                    <td><spring:label path="password">Password:</spring:label></td>
                    <td><spring:input path="password" id="password" /></td>
                </tr>
                <tr>
                    <td><spring:label path="password_confirm">Confirm Password:</spring:label></td>
                    <td><spring:input path="password_confirm" id="password_confirm" /></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                    </td>
                </tr>
            </table>
        </spring:form>
    </body>
</html>
