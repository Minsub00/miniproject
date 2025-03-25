package miniproject;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("member_DAO")
public class member_DAO implements realty_mapper{
	
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
}
