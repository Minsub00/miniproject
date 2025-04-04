package miniproject;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("board_DAO")
public class board_DAO implements board_mapper {
	
	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public int board_write(board_DTO dto) {
		int result = this.st.insert("board_write",dto);
		return result;
	}
	
	@Override
	public List<board_DTO> board_list(Integer page) {
		Integer page_ea = 10;
		Map<String, Integer> data = new HashMap<String, Integer>();
		int spage = (page - 1) * page_ea;
		data.put("spage", spage);
		data.put("epage", page_ea);
		List<board_DTO> all = this.st.selectList("board_list", data);
		return all;
	}
	@Override
	public int board_total() {
		int result = this.st.selectOne("board_total");
		return result;
	}
	@Override
	public List<board_DTO> search_board(String search) {
		List<board_DTO> all = this.st.selectList("board_search", search);
		return all;
	}
	@Override
	public List<board_DTO> board_view(String title, String idx) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("btitle", title);
		data.put("bidx", idx);
		List<board_DTO> result = this.st.selectList("board_view",data);
		return result;
	}
	
	@Override
	public int update_view(String idx) {
		int result = this.st.update("update_view",idx);
		return result;
	}
}
