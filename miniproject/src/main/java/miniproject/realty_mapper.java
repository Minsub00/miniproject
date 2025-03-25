package miniproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface realty_mapper {
	public int member_join(member_DTO dto);
	member_DTO idcheck(String memail); 
}
