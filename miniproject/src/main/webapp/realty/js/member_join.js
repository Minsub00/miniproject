var idchecked = 0;

function join() {
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;


	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;


	if (f.memail.value == "") {
		alert("이메일 주소를 입력해주세요.")
		f.meamil.focus();
		return;
	} else if (f.mpass.value == "") {
		alert("비밀번호를 입력해주세요.")
		f.mpass.focus();
		return;
	} else if (pass1 != pass2) {
		alert("비밀번호가 일치하지 않습니다.");
		f.mpass.focus;
		return;
	} else if (!passPattern.test(f.mpass.value)) {
		alert("비밀번호는 10~16자(영문,숫자,특수 문자 조합)로 입력해주세요.")
		f.mpass.focus();
		return;
	} else if (f.mname.value == "") {
		alert("이름을 입력해주세요.");
		f.mname.focus();
		return;
	} else if (f.mphone.value == "") {
		alert("휴대폰 번호를 입력해주세요.");
		f.mphone.focus();
		return;
	} else if (!check1.checked || !check2.checked || !check3.checked) {
		alert("필수 동의사항에 동의해주세요.");
		return;
	} else if (idchecked == 0) {
		alert("중복확인을 해주세요.");
	} else {
		f.submit();
	}



}

var check1 = document.getElementById("check1");
var check2 = document.getElementById("check2");
var check3 = document.getElementById("check3");

var allCheck = document.getElementById("all_check");

document.getElementById("all_check").addEventListener("change", function() {
	check1.checked = this.checked;
	check2.checked = this.checked;
	check3.checked = this.checked;
});


function updateAllCheck() {
	allCheck.checked = check1.checked && check2.checked && check3.checked;
}


document.getElementById("check1").addEventListener("change", updateAllCheck);
document.getElementById("check2").addEventListener("change", updateAllCheck);
document.getElementById("check3").addEventListener("change", updateAllCheck);


window.onload = function() {
	var http = new XMLHttpRequest;
	http.open("GET", "./agree1.txt", false);
	http.send(); // 통신 실행
	document.getElementById("text1").innerHTML = http.response;

	http.open("GET", "./agree2.txt", false);
	http.send();
	document.getElementById("text2").innerHTML = http.response;

	document.getElementById("numberInput").addEventListener("input", function() {
		this.value = this.value.replace(/[^0-9]/g, ''); // 숫자만 허용
	});
}



function mailcheck() {
	var email = document.getElementById('memail').value;
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if (!emailPattern.test(email)) {
		alert("올바른 이메일 주소를 입력해주세요.");
	} else {
		var http2, result;
		http2 = new XMLHttpRequest();
		http2.onreadystatechange = function() {
			if (http2.readyState == 4 && http2.status == 200) {
				var result = http2.responseText.trim();  // 서버에서 받은 result 값
				if (result == 1) {
					alert("아이디가 이미 존재합니다.");
				} else {
					alert("사용 가능한 아이디입니다.");
					idchecked = 1;
					
                    document.getElementById('memail').setAttribute("readonly", true);
                    
                    document.getElementById("check_btn").setAttribute("disabled", true);
				}
			}
			console.log(result);
		}
		http2.open("get", "/idcheck.do?memail=" + email, true);
		http2.send();
	}
}