function email_search() {
	if (f.mname.value == "") {
		alert("이름을 입력해주세요.");
		f.mname.focus();
	} else if (f.mphone.value == "") {
		alert("휴대폰 번호를 입력해주세요.")
		f.mphone.focus();
	} else {
		f.submit();
	}
}

function passwd_search() {
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if (f.memail.value == "") {
		alert("이메일을 입력해주세요.");
		f.memail.focus();
	} else if (f.mphone.value == "") {
		alert("휴대폰 번호를 입력해주세요.")
		f.mphone.focus();
	} else {
		if(!emailPattern.test(f.memail.value)){
			alert("올바른 이메일을 입력해주세요.");
		} else {
			f.submit();
		}
	}
}

document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("numberInput").addEventListener("input", function() {
		this.value = this.value.replace(/[^0-9]/g, ''); // 숫자만 허용
	});
});