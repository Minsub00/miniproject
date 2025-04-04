function counsel() {


	var checkboxes = document.getElementsByName('ctype1');
	var ctype1Checked = false;

	var checkboxes2 = document.getElementsByName('ctype2');
	var ctype2Checked = false;

	for (let i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			ctype1Checked = true;
			break; 
		}
	}

	for (var i = 0; i < checkboxes2.length; i++) {
		if (checkboxes2[i].checked) {
			ctype2Checked = true;
			break; 
		}
	}

	if (!ctype1Checked) {
		alert('임대형태를 체크해주세요.');
	} else if (!ctype2Checked) {
		alert('주거형태를 체크해주세요.');
	} else if (f.cdate.value === "") {
		alert('상담일시를 선택해주세요.');
	} else if (f.ctext.value == "") {
		alert('상담내용을 입력해주세요.');
	} else {
		const today = new Date();
		const selectedDate = new Date(f.cdate.value);

		if (selectedDate <= today) {
			alert('상담일시는 오늘 이후로 설정해야 합니다.');
		} else {
			f.submit();
		}

	}
	
	console.log(f.cdate.value);
}