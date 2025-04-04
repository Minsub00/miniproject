function writeok(){
	var content = CKEDITOR.instances.board_text.getData().trim();
	if(f.btitle.value == ""){
		alert("제목을 입력해주세요.");
	} else if(content == ""){
		alert("내용을 입력해주세요.")
	} else {
		f.submit();
	}

}