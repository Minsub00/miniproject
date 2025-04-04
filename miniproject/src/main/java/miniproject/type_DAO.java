package miniproject;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("type_DAO")
public class type_DAO implements type_mapper {
	
	@Resource(name="template")
	public SqlSessionTemplate st;
	
	@Override
	public List<type_DTO> show_tails(int index) {
		List<type_DTO> tails = this.st.selectList("show_tails", index);
		return tails; 
	}
	
	@Override
	public String show_title(String title) {
		String result = this.st.selectOne("show_title",title);
		return result;
	}
	@Override
	public List<type_DTO> show_index() {
		List<type_DTO> result = this.st.selectList("show_index");
		return result;
	}
}
