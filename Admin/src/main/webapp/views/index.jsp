
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.jumbotron {
    padding:70px 30px 70px 30px;
    margin:0px auto;
    background: #9575CD ;
    color:floralwhite;
}
</style>
<body style="text-align:center;">


    <p><header class="jumbotron">
        <div class="container">
            <div class="row row-header">
                <div class="col-12 col-sm-6">
                    <h1>Admin Portal</h1>
                </div>
                <div class="col-12 col-sm">
                </div>
            </div>
        </div>
    </header> </p>
     
       
       
       <form action="admin/processlogin" method="post">
            <p><label for="username">Username:</label><br>
			<input type="email" name="email" /> <br> </p>
			<p><label for="password">Password:</label><br>
			<input type="password" name="password" /> <br> </p>
			<p><input type="submit" value="Log In" /> <br></p>
	</form> 
	
	
	
</body>
</html>