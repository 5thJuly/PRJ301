<%-- 
    Document   : login
    Created on : 31-05-2023, 14:24:11
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        Input your information:
        <form action="MainController" method="POST" id="form">
           UserID<input type="text" name="userID" required=""/></br>
           Password<input type="password" name="password" required=""/></br>
           <div class="g-recaptcha" data-sitekey="6LfJIPcmAAAAACmx3nbFVcNMrZ_ljTVg14vQs0BT"></div>
           <div id="error" style="color:red"></div>
           <input value="Login" name="action" hidden=""/>
           <input type="submit" value="Login"/>
           <input type="reset" value="Reset">
       </form>
        
        ${requestScope.ERROR}
        
        </br></br><a href="MainController?action=CreatePage">Create user</a>
        <a href="MainController?action=ShoppingPage">Shopping Time</a></br></br>
        
           
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
            window.onload = function (){
                let isValid = false;
                const form = document.getElementById("form");
                const error = document.getElementById("error");
				
                form.addEventListener("submit", function (event){
                    event.preventDefault();
                    const response = grecaptcha.getResponse();
                    if (response){
                        form.submit();
                    } else {
                        error.innerHTML = "Please check";
                    }
                });
            };
        </script>
    </body>
</html>
