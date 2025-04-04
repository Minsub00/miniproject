package miniproject;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface md_mapper {
	List<md_DTO> md_view();
}
