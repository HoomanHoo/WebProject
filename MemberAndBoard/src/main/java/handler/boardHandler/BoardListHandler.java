package handler.boardHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MabDBBean;
import bean.MabDataPostBean;
import handler.CommandHandler;

public class BoardListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String passwd = (String)session.getAttribute("passwd");
		MabDBBean dao = MabDBBean.getInstance();
		int checkId = dao.checkLogin(id, passwd);
		String url = null;
		
		if(checkId == 1) {
			ArrayList<MabDataPostBean> dtos = dao.getList();
	
			request.setAttribute("dtos", dtos);
			url = "/board/boardList.jsp";
		}
		else if(checkId == -5){
			request.setAttribute("checkId",  checkId);
			url = "/member/errorPage.jsp";
		}
		
		return url;
	}

}
