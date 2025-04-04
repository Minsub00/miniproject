package miniproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface member_mapper {
	public int member_join(member_DTO dto);
	member_DTO idcheck(String memail); 
	member_DTO emailSearch(String mname, String mphone);
	member_DTO passwdSearch(String memail, String mphone);
	int passwdChange(member_DTO dto);
	member_DTO login(String memail);
}
