<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
 <html>
     <head>
         <meta charset="UTF-8">
         <title>User</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
             rel="stylesheet"
             integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
             crossorigin="anonymous">
     </head>
     <body>
        <p>Are you really want delete this user?</p>
        <p>${user.get("id")} ${user.get("firstName")} ${user.get("lastName")}</p>
        <form action="/users/delete" method="post">
            <input type="hidden" name="id" value=${user.get("id")}>
            <button type="submit">Delete</button>
        </form>
     </body>
 </html>
<!-- END -->
