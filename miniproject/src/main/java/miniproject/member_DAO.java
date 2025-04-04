package miniproject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("member_DAO")
public class member_DAO implements member_mapper{
	
	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public int member_join(member_DTO dto) {
		int result = this.st.insert("member_join", dto);
		return result;
	}
	
	@Override
	public member_DTO idcheck(String memail) {
		member_DTO idsearch = this.st.selectOne("idcheck", memail);
		return idsearch;
	}
	
	@Override
	public member_DTO login(String memail) {
		member_DTO getuser = this.st.selectOne("login", memail); 
		return getuser;
	}
	
	@Override
	public member_DTO emailSearch(String mname, String mphone) {
		Map<String, String> search = new HashMap<String, String>();
		search.put("mname", mname);
		search.put("mphone", mphone);		
		
		member_DTO result = this.st.selectOne("emailSearch", search);
		
		return result;
	}
	
	@Override
	public member_DTO passwdSearch(String memail, String mphone) {
		Map<String, String> search = new HashMap<String, String>();
		search.put("memail", memail);
		search.put("mphone", mphone);
		
		member_DTO result = this.st.selectOne("passwdSearch", search);
		
		return result;
	}
	
	@Override
	public int passwdChange(member_DTO dto) {
		int result = this.st.update("passwdChange", dto);
		return result;
	}
}
