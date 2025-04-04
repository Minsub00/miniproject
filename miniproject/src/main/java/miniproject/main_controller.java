package miniproject;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class main_controller extends md5 {
	private int result = 0;
	private String msg, pwd = "";

	@Resource(name = "member_DAO")
	private member_DAO dao;
	
	@Resource(name="counsel_DAO")
	private counsel_DAO c_dao;
	
	@Resource(name="reservation_DAO")
	private reservation_DAO r_dao;
	
	@Resource(name="board_DAO")
	private board_DAO b_dao;
	
	@Resource(name="rename_file")
	private rename_file rfile;
	
	PrintWriter pw = null;

	@PostMapping("/realty/join/join_ok.do")
	public String join_ok(member_DTO dto, Model m) {
		try {
			pwd = md5_code(dto.getMpass());
		} catch (Exception e) {
			System.out.println(e);
		}
		dto.setMpass(pwd);
		result = this.dao.member_join(dto);
		String msg = "";
		if (result > 0) {
			msg = "alert('가입이 완료되었습니다.');" + "location.href='/realty/login/login.do';";
		}
		m.addAttribute("msg", msg);

		return "realty/load";

	}

	@GetMapping("/join/idcheck.do")
	public String idcheck(String memail, HttpServletResponse response) {
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

	@PostMapping("/realty/search/email_searchok.do")
	public String emailSearch(member_DTO dto, Model m) {
		member_DTO data = this.dao.emailSearch(dto.getMname(), dto.getMphone());
		if (data == null) {
			msg = "확인된 가입정보가 없습니다.";
		} else {
			msg = data.getMemail();
		}
		m.addAttribute("msg", msg);
		return "realty/search/search_myinfo";
	}

	@PostMapping("/realty/search/passwd_searchok.do")
	public String passwdSearch(member_DTO dto, Model m, HttpSession session) {
		member_DTO data = this.dao.passwdSearch(dto.getMemail(), dto.getMphone());
		String url = "";
		if (data == null) {
			msg = "alert('확인된 가입정보가 없습니다.');" + "history.go(-1);";
			url = "realty/load";
		} else {
			session.setAttribute("pwd_email", data.getMemail());
			session.setAttribute("pwd_name", data.getMname());
			msg = "alert('회원정보가 확인되었습니다.');";
			url = "/WEB-INF/pwchange/search_mypass";
		}
		m.addAttribute("msg", msg);

		return url;
	}

	@PostMapping("/realty/search/passwd_changeok.do")
	public String passwdChange(member_DTO dto, Model m, HttpSession session) {
		String pwd_email = (String) session.getAttribute("pwd_email");
		String pwd_name = (String) session.getAttribute("pwd_name");

		if (pwd_email == null || pwd_name == null) {
			msg = "alert('올바른 접근이 아닙니다.');" + "history.go(-1);";
		} else {
			dto.setMemail(pwd_email);
			dto.setMname(pwd_name);
			String pwd = "";
			try {
				pwd = md5_code(dto.getMpass());
			} catch (Exception e) {
				System.out.println(e);
			}
			dto.setMpass(pwd);
			result = this.dao.passwdChange(dto);
			if (result > 0) {
				session.removeAttribute("pwd_email");
				session.removeAttribute("pwd_name");
				msg = "alert('비밀번호가 변경되었습니다.');" + "location.href='../index.jsp';";
			}
		}
		m.addAttribute("msg", msg);

		return "realty/load";
	}

	@PostMapping("/realty/login/loginok.do")
	public String loginok(member_DTO dto, Model m,HttpServletRequest request ,HttpSession session) throws Exception {
	    if (session != null) {
	        session.invalidate();
	    }
		
		member_DTO getuser = this.dao.login(dto.getMemail());
		pwd = md5_code(dto.getMpass());
		
		if (getuser == null || !pwd.equals(getuser.getMpass())) {
			msg = "alert('아이디 또는 비밀번호를 확인해주세요.');" + "history.go(-1)";
		} else {
			session = request.getSession(true);
			session.setAttribute("memail", getuser.getMemail());
			session.setAttribute("mname", getuser.getMname());
			session.setAttribute("mphone", getuser.getMphone());
			msg = "location.href='../index.do';";
		}
		m.addAttribute("msg", msg);
		return "realty/load";
	}
	
	@GetMapping("/realty/logout")
	public String logout(HttpSession session, Model m) {
	    session.invalidate(); // 세션 전체 삭제
	    String msg = "alert('로그아웃되었습니다.'); location.href='/realty/index.do';";
	    m.addAttribute("msg", msg);
	    return "realty/load";
	}
	
	@PostMapping("/realty/counsel/counselok.do")
	public String counselok(counsel_DTO c_dto, Model m) {
		result = c_dao.counsel_reg(c_dto);
		String msg = "";
		if (result > 0) {
			msg = "alert('담당자가 확인 후 해당 상담일시에 맞춰서 연락 드립니다.');" 
					+ "location.href='/realty/index.do';";
		} else {
			msg = "alert('다시 시도해주세요');" + "history.go(-1);";
		}
		m.addAttribute("msg", msg);
		return "realty/load";
	}
	
	@PostMapping("/realty/reservation/reservationok.do")
	public String reservationok(reservation_DTO dto, Model m) {
	    int result = this.r_dao.reservation_in(dto);

	    if (result > 0) {
	        msg = "alert('예약이 완료되었습니다.');";
	        m.addAttribute("data", dto);
	        return "realty/reservation/reservation_check";
	    } else if (result == -1) {
	        msg = "alert('이미 예약 중인 시간입니다.'); history.go(-1);";
	        m.addAttribute("msg", msg);
	        return "realty/load";
	    }

	    return "realty/load";
	}
	
	@PostMapping("/realty/md_board/md_writeok.do")
	public String md_writeok(board_DTO dto, MultipartFile bfile, HttpServletRequest request, Model m) throws Exception {
		String file_new = null;
		
		if(bfile.getSize() > 0) {
			String originalFilename = bfile.getOriginalFilename();
	        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

	        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png");

	        if (!allowedExtensions.contains(fileExtension)) {
	            m.addAttribute("msg", "alert('이미지 파일만 업로드 가능합니다.'); history.go(-1);");
	            return "realty/load";
	        }
			String url = request.getServletContext().getRealPath("/upload/");
			System.out.println(url);
			
			file_new = this.rfile.rename(originalFilename);
			
			dto.setBfile_url("/upload/"+file_new);
			dto.setBfile_new(file_new);
			dto.setBfile_ori(originalFilename);
			FileCopyUtils.copy(bfile.getBytes(), new File(url + file_new));
		}
		result = this.b_dao.board_write(dto);
		if(result > 0) {
			msg = "alert('게시글 등록이 완료되었습니다.'); location.href='./md_board.do';";
		} else {
			msg = "alert('error'); + history.go(-1);";
		}
		m.addAttribute("msg",msg);
		return "realty/load";
	}
	
	@GetMapping("/realty/reservation/reservation_cancel.do")
	public String reservation_cancel(int index, Model m) {
		int result = this.r_dao.reservation_del(index);
		if(result > 0) {
			msg = "alert('예약이 취소되었습니다.'); location.href='./reservation_list.do';";
		}
		else {
			msg = "alert('예약정보가 올바르지 않습니다.'); history.go(-1);";
		}
		m.addAttribute("msg", msg);
		return "realty/load";
	}
}
