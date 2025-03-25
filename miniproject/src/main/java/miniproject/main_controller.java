package miniproject;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class main_controller extends md5 {

	@Resource(name = "member_DAO")
	private member_DAO dao;

	@Resource(name = "md5")
	private md5 md5pwd;

	PrintWriter pw = null;

	@PostMapping("/realty/join_ok.do")
	public String join_ok(member_DTO dto, Model m) {
		
		String pwd = "";
		try {
			pwd = md5_code(dto.getMpass());
		} catch (Exception e) {
			System.out.println(e);
		}
		dto.setMpass(pwd);
		int result = this.dao.member_join(dto);
		String msg = "";
		if (result > 0) {
			msg = "alert('가입이 완료되었습니다.');" + "location.href='./index.jsp';";
		}
		m.addAttribute("msg", msg);
		
		return "realty/load";
		
	}

	@GetMapping("/idcheck.do")
	public String idcheck(String memail, HttpServletResponse response) {
		int result = 0;
		try {
			this.pw = response.getWriter();
			member_DTO idsearch = this.dao.idcheck(memail);
			if (idsearch != null) {
				result = 1;
			} else {
				result = 0;
			}
			
			this.pw.write(String.valueOf(result));
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			this.pw.close();
		}
		return null;
	}
	
	@PostMapping("/realty/email_searchok.do")
	public String emailSearch() {
		return null;
	}
}
