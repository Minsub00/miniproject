package miniproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("reservation_DAO")
public class reservation_DAO implements reservation_mapper {

	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public int reservation_in(reservation_DTO dto) {
	    int count = this.st.selectOne("reservation_check", dto);  // 해당 날짜와 시간에 예약이 이미 있는지 체크
	    
	    if (count > 0) {
	        return -1;
	    }

	    int result = this.st.insert("reservation_in", dto);
	    return result;
	}
	
	@Override
	public List<reservation_DTO> reservation_idcheck(String remail) {
		List<reservation_DTO> result = this.st.selectList("reservation_idcheck",remail);
		return result;
	}
	
	@Override
	public List<reservation_DTO> reservation_list(String remail) {
		List<reservation_DTO> result = this.st.selectList("reservation_list",remail);
		return result;
	}
	
	@Override
	public reservation_DTO reservation_view(String email, String title) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("remail", email);
		data.put("rtitle", title);
		
		reservation_DTO result = this.st.selectOne("reservation_view", data); 
		return result;
	}
	@Override
	public int reservation_del(int index) {
		int result = this.st.delete("reservation_del", index);
		return result;
	}
	
	@Override
	public int check_user_reservation(String email, String title) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("remail", email);
		data.put("rtitle", title);
		
		int result = this.st.selectOne("check_user_reservation", data);
		return result;
	}
	
}
