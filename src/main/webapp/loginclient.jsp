<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="Css/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
 <div class="split left">
<div class="container">
 <div class="frame">
       <div class="nav">
          <ul class="links">
            <li class="signin-active"><a class="btn">Sign in</a></li>

          </ul>
        </div>
        <div >
           <div class="form-signin">
           <form action="<%=request.getContextPath()%>/login" method="post" >
            <label for="fname">First Name</label>
            <input class="form-styling" type="text" name="username" placeholder="username"/>

            <label for="password">Password</label>
            <input class="form-styling" type="text" name="password" placeholder="password"/>

            <input type="checkbox" id="checkbox"/>
            <label for="checkbox" ><span class="ui"></span>Keep me signed in</label>


            <button  type="submit" class="btn-signin">
                Sign in
            </button>

          </form>
          </div>
          </div>
<div  class="success">
            <svg width="270" height="270" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                 viewBox="0 0 60 60" id="check" ng-class="checked ? 'checked' : ''">
              <path fill="#ffffff" d="M40.61,23.03L26.67,36.97L13.495,23.788c-1.146-1.147-1.359-2.936-0.504-4.314
                    c3.894-6.28,11.169-10.243,19.283-9.348c9.258,1.021,16.694,8.542,17.622,17.81c1.232,12.295-8.683,22.607-20.849,22.042
                    c-9.9-0.46-18.128-8.344-18.972-18.218c-0.292-3.416,0.276-6.673,1.51-9.578" />
              <div class="successtext">
                <p> Thanks for signing up! Check your email for confirmation.</p>
              </div>
            </div>
        </div>

        <div class="forgot">
          <a href="#">Forgot your password?</a>
        </div>
</div>


</div>
 <script>
    $(function() {
	$(".btn").click(function() {
    $(".frame").toggleClass("frame-long");
    $(".signup-inactive").toggleClass("signup-active");
    $(".signin-active").toggleClass("signin-inactive");
    $(this).removeClass("idle").addClass("active");
	});
});

$(function() {
	$(".btn-signup").click(function() {
  $(".nav").toggleClass("nav-up");
  $(".form-signup-left").toggleClass("form-signup-down");
  $(".success").toggleClass("success-left");
  $(".frame").toggleClass("frame-short");
	});
});

$(function() {
	$(".btn-signin").click(function() {
  $(".btn-animate").toggleClass("btn-animate-grow");
  $(".welcome").toggleClass("welcome-left");
  $(".cover-photo").toggleClass("cover-photo-down");
  $(".frame").toggleClass("frame-short");
  $(".profile-photo").toggleClass("profile-photo-down");
  $(".btn-goback").toggleClass("btn-goback-up");
  $(".forgot").toggleClass("forgot-fade");
	});
});
</script>

<script src="home.js"></script>

</body>
</html>