package miniproject;


import java.util.List;



import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface board_mapper {
	List<board_DTO> board_list (Integer page);
	List<board_DTO> search_board(String search);
	List<board_DTO> board_view(String title, String idx);
	int update_view(String idx);
	int board_total();
	int board_write(board_DTO dto);
}
