<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.jumbotron {
    padding:70px 30px 70px 30px;
    margin:40px auto;
    background: black ;
    color: white;
    font-family: "Verdana";
}


input[type=text], input[type=password], input[type=number], input[type=email], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 50px;
  box-sizing: border-box;
  font-family: "Verdana";
  font-size: 16px;
}

input[type=submit] {
  width: 30%;
  background-color: white;
  color: black;
  padding: 14px 20px;
  margin: 8px 0;
  border: 3px solid #f2b636;
  border-radius: 50px;
  cursor: pointer;
  font-family: "Verdana";
  font-size: 16px;
}

input[type=submit]:hover {
  background-color: #f2b636;
}

#form{
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px 400px;
  font-family: "Verdana";
  font-size: 16px;
}


</style>
<body style="text-align:center;">


    <p><header class="jumbotron">
        <div class="container">
            <div class="row row-header">
                <div class="col-12 col-sm-6">
                    <h1>Doctor Registration</h1>
                </div>
                <div class="col-12 col-sm">
                </div>
            </div>
        </div>
    </header> </p>
     
       
     <div id = "form">
      <form action="processregister" method="post">
      <label for="name">Username</label>
    <input type="text"  name="name" placeholder="Enter Name">

    <label for="password">Password</label>
    <input type="password"  name="password" placeholder="Enter Password">
     
     <label for="email">Email</label>
    <input type="email"  name="email" placeholder="Enter E-mail">

    <label for="category" placeholder="Select Speciality">Category</label>
    <select id="category" name="category">
      <option value="physician">Physician</option>
      <option value="cardiologist">Cardiologist</option>
      <option value="neurologist">Neurologist</option>
      <option value="pathologist">Pathologist</option>
    </select>
    
    <label for="gender" placeholder="Select Gender">Gender</label>
    <select id="gender" name="country" >
      <option value="male">Male</option>
      <option value="female">Female</option>
    </select>
    
    <label for="mobile">Mobile Number</label>
    <input type="number"  name="mobile" placeholder="Enter Mobile Number">
    
    <label for="fees">Fees</label>
    <input type="number"  name="fees" placeholder="Enter Fees">
			
			<input type="submit" value="Register" /> <br>
	</form>
	</div>
	
	
	
</body>
</html>