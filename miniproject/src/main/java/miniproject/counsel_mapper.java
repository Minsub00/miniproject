package miniproject;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface counsel_mapper {
	public int counsel_reg(counsel_DTO dto);
}
