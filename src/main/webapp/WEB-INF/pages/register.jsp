
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/asset/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/asset/css/util.css">
    <link rel="stylesheet" type="text/css" href="/asset/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form validate-form">
					<span class="login100-form-title p-b-5">
						ToDo List
					</span>
                <span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>


                    <div class="wrap-input100 validate-input" data-validate = "Ad Girin">
                    <input class="input100" type="text"  name="name" id="name">
                    <span class="focus-input100" data-placeholder="Adınız"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Soyad Girin">
                    <input class="input100" type="text"  name="surname" id="surname">
                    <span class="focus-input100" data-placeholder="Soyadınız"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Kullanıcı Adı Girin" onblur="blur()">
                    <input class="input100" type="text"  name="username" id="username">
                    <span class="focus-input100" data-placeholder="Kullanıcı Adı"></span>
                    <div class="form-message" ></div>
                </div>


                <div class="wrap-input100 validate-input" data-validate = "Email Girin">
                    <input class="input100" type="text"  name="email" id="email">
                    <span class="focus-input100" data-placeholder="Email"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Parola Girin">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="pass" id="pass">
                    <span class="focus-input100" data-placeholder="Parola"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Parola Tekrarı Girin">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
                    <input class="input100" type="password" name="pass2" id="pass2">
                    <span class="focus-input100" data-placeholder="Parola Tekrarı"></span>
                </div>

                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn" type="button" id="registerBtn" onclick="addRegister()">
                            Kayıt Ol
                        </button>
                    </div>
                </div>
                <div class="container text-center" id="errorReg" style="display: none"><p>Parolalar eşleşmiyor!</p></div>

                <div class="text-center p-t-30">
                    <a href="login">Giriş Yap</a>
                </div>

                <div class="text-center p-t-30">

                </div>
            </div>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="/asset/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/asset/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/asset/vendor/bootstrap/js/popper.js"></script>
<script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/asset/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/asset/vendor/daterangepicker/moment.min.js"></script>
<script src="/asset/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/asset/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/asset/js/main.js"></script>

<script src="/js/register.js"></script>
</body>
</html>