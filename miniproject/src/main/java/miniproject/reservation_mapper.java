package miniproject;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface reservation_mapper {
	int reservation_in(reservation_DTO dto);
	reservation_DTO reservation_view(String email, String title);
	List<reservation_DTO> reservation_idcheck(String remail);
	List<reservation_DTO> reservation_list(String remail);
	int reservation_del(int index);
	int check_user_reservation(String email, String title);
}
