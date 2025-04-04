package miniproject;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface type_mapper {
	List<type_DTO> show_tails(int index);
	String show_title(String title);
	List<type_DTO> show_index();
}
