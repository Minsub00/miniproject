package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("md_DAO")
public class md_DAO implements md_mapper {
	
	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public List<md_DTO> md_view() {
		List<md_DTO> result = this.st.selectList("md_view");
		return result;
	}
}
