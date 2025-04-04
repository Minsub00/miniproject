function logincheck(){
	if(f.memail.value == ""){
		alert("이메일을 입력해주세요.");
		f.memail.focus();	
	} else if (f.mpass.value == ""){
		alert("비밀번호를 입력해주세요.");
		f.mpass.focus();
	} else {
		f.submit();
	}
}