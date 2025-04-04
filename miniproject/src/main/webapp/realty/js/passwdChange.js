

function pwdchange() {
	var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;
	
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	
	if (f.mpass.value == "") {
		alert("비밀번호를 입력해주세요.")
		f.mpass.focus();
	} else if (pass1 != pass2) {
		alert("비밀번호가 일치하지 않습니다.");
		f.mpass.focus;
	} else if (!passPattern.test(f.mpass.value)) {
		alert("비밀번호는 10~16자(영문,숫자,특수 문자 조합)로 입력해주세요.")
		f.mpass.focus();
	} else {
		f.submit();
	}
}