function page(no, search){
	if (search === "") {
        location.href = "./md_board.do?page=" + no;
    } else {
        location.href = "./md_board.do?page=" + no + "&search=" + search;
    }
}

function board_search(){
	if(f.search.value==""){
		alert("검색어를 입력하세요.");
	} else {
		f.submit();
	}
}