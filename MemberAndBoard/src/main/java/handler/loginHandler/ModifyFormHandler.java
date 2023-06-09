package handler.loginHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import bean.MabDataLoginBean;
import handler.CommandHandler;

public class ModifyFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String url = null;
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int checkId = dao.checkLogin(id, passwd);
		MabDataLoginBean dto = new MabDataLoginBean();
		dto = dao.getInfo(id);
		id = dto.getId();
		String name = dto.getName();
		String license = dto.getLicense();
		if(checkId == 1) {
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("license", license);
			url = "/member/modifyForm.jsp";
		}
		else {
			request.setAttribute("checkId", checkId);
			url = "/member/errorPage.jsp";
		}
		
		return url;
	}

}
