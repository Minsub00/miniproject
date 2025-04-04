package miniproject;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class view_controller {
	
	@Resource(name="type_DAO")
	private type_DAO t_dao;

	@Resource(name="reservation_DAO")
	private reservation_DAO r_dao;
	
	@Resource(name="md_DAO")
	private md_DAO m_dao;
	
	@Resource(name="board_DAO")
	private board_DAO b_dao;
	
	@GetMapping("/realty/index.do")
	public String index(Model m) {
		List<type_DTO> data = this.t_dao.show_index();
		List<md_DTO> data2 = this.m_dao.md_view();
		m.addAttribute("data2",data2);
		m.addAttribute("data",data);
		return null;
	}
	
	@GetMapping("/realty/join/member_join.do")
	public String member_join() {
		return null;
	}
	
	@GetMapping("/realty/login/login.do")
	public String login() {
		return null;
	}
	
	@GetMapping("/realty/search/email_search.do")
	public String email_search() {
		return null;
	}
	@GetMapping("/realty/search/passwd_search.do")
	public String passwd_search() {
		return null;
	}
	
	@GetMapping("/realty/counsel/counsel.do")
	public String counsel(HttpSession session, Model m) {
	    String memail = (String) session.getAttribute("memail");
	    String mname = (String) session.getAttribute("mname");
	    String mphone = (String) session.getAttribute("mphone");

	    if (memail != null && mname != null && mphone != null) {
	        m.addAttribute("memail", memail);
	        m.addAttribute("mname", mname);
	        m.addAttribute("mphone", mphone);
	    } else {
	        m.addAttribute("msg", "alert('로그인이 필요한 시스템입니다. 로그인 해주세요.'); location.href='/realty/login/login.do';");
	    }
		return null;
	}
	
	@GetMapping(value = "/realty/week_tails/week_tails.do", produces = "text/plain;charset=UTF-8")
	public String week_tails(HttpSession session, @RequestParam(defaultValue = "1", required = false)int index, Model m) {
		String memail = (String) session.getAttribute("memail");
		List<type_DTO> tails = this.t_dao.show_tails(index);
		System.out.println(tails.get(0).bunyang_title);
		
		m.addAttribute("tails", tails);
		int check_reservation = this.r_dao.check_user_reservation(memail, tails.get(0).bunyang_title);
		if(check_reservation > 0) {
			m.addAttribute("check", 1);
		}
		return null;
	}
	
	
	@GetMapping("/realty/reservation/reservation.do")
	public String reservation(HttpSession session, @RequestParam(defaultValue = "1", required = false)String title, Model m) {
	    String memail = (String) session.getAttribute("memail");
	    String mname = (String) session.getAttribute("mname");
	    String mphone = (String) session.getAttribute("mphone");
	    
	    if (memail != null && mname != null && mphone != null) {
	        m.addAttribute("memail", memail);
	        m.addAttribute("mname", mname);
	        m.addAttribute("mphone", mphone);
	    } else {
	        m.addAttribute("msg2", "alert('로그인이 필요한 시스템입니다. 로그인 해주세요.'); location.href='/realty/login/login.do';");
	    }
	    
		String result = this.t_dao.show_title(title);
		String msg = "";
		
		if(result == null) {
			msg = "alert('분양정보가 올바르지 않습니다.'); history.go(-1);";
		}
		m.addAttribute("msg",msg);
		m.addAttribute("title", result);

		
		return null;
	}
	
	
	@GetMapping("/realty/reservation/reservation_check.do")
	public String reservation_check(HttpSession session,String title, Model m) {
		String msg = "";
		String memail = (String) session.getAttribute("memail");
		if(memail == null) {
			msg = "alert('로그인이 필요한 시스템입니다.'); location.href='/realty/login/login.do';";
			m.addAttribute("msg", msg);
		} else {
			reservation_DTO data = this.r_dao.reservation_view(memail, title);
			m.addAttribute("data", data);
		}
		return null;
	}
	
	@GetMapping("/realty/md_board/md_board.do")
	public String md_board(Model m ,@RequestParam(defaultValue = "", required = false)String search,
			@RequestParam(defaultValue = "1", required = false)Integer page) {
		List<board_DTO> all = null;
		int total = 0;
		
		int userpage = 0;
		
		if(page == 1) {
			userpage = 0;
		} else {
			userpage = (page - 1) * 10;
		}
		
		m.addAttribute("userpage",userpage);
		
		if(search.equals("")) {
			total = this.b_dao.board_total();
			all = this.b_dao.board_list(page);
		} else {
			all = this.b_dao.search_board(search);
			total = all.size();
		}
		m.addAttribute("total",total);
		m.addAttribute("search",search);
		m.addAttribute("all",all);
		return null;
	}
	
	@GetMapping("/realty/md_board/md_board_view.do")
	public String board_view(String title, String index, Model m) {
		this.b_dao.update_view(index);
		List<board_DTO> result = this.b_dao.board_view(title, index);
		m.addAttribute("result",result);
		return null;
	}
	
	@GetMapping("/realty/md_board/md_board_write.do")
	public String board_write() {
		return null;
	}
	
	@GetMapping("/realty/reservation/reservation_list.do")
	public String reservation_list(HttpSession session, Model m) {
		String msg = "";
		String memail = (String) session.getAttribute("memail");
		if(memail == null || memail.isEmpty()) {
			msg = "alert('로그인이 필요한 시스템입니다.'); location.href='/realty/login/login.do';";
			m.addAttribute("msg", msg);
		} else {
			List<reservation_DTO> result = this.r_dao.reservation_list(memail);
			m.addAttribute("result", result);
		}
		return null;
	}
}
