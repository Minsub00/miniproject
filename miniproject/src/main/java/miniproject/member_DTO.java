package miniproject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class member_DTO {
	private int midx;
	private String memail, mpass, mname, mphone, join_date;
	private String magree = "N";
	
}
