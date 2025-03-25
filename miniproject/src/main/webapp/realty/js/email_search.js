function search(){
	if(f.mname.value == ""){
		alert("이름을 입력해주세요.");
	} else if (f.mphone.value == ""){
		alert("휴대폰 번호를 입력해주세요.")
	} else {
		f.submit();
	}
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("numberInput").addEventListener("input", function () {
        this.value = this.value.replace(/[^0-9]/g, ''); // 숫자만 허용
    });
});