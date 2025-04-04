function reservation() {
	if (f.rdate.value == "") {
		alert("방문날짜를 선택해주세요.");
	} else if (f.rtime.value == "") {
		alert("방문시간을 선택해주세요.");
	} else {
		var today = new Date();
		var selectedDate = new Date(f.rdate.value);

		today.setHours(0, 0, 0, 0);
		selectedDate.setHours(0, 0, 0, 0);
		if (selectedDate < today) {
			alert('상담일시는 오늘 이후로 설정해야 합니다.');
		} else {
			var now = new Date();
			var selectedTime = f.rtime.value; 
			var selectedHour = parseInt(selectedTime.split(":")[0]); 
			
			if (selectedDate.getTime() === today.getTime() && now.getHours() >= selectedHour) {
				alert('선택하신 시간은 예매가 종료되었습니다.');
			} else {
				f.submit();
			}
		}
	}
}

