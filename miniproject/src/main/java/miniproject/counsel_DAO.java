package miniproject;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("counsel_DAO")
public class counsel_DAO implements counsel_mapper {

	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public int counsel_reg(counsel_DTO dto) {
		int result = this.st.insert("counsel_reg", dto);
		return result;
	}
	
}
