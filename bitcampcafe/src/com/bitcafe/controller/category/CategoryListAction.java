package com.bitcafe.controller.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcafe.DTO.CategoryDTO;
import com.bitcafe.DTO.MemberDTO;
import com.bitcafe.controller.Action;
import com.bitcafe.service.CategoryService;
import com.bitcafe.util.ForwardAction;

public class CategoryListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 정보
		HttpSession session = request.getSession();
		CategoryService service = CategoryService.getService();
		MemberDTO loginInfo = (MemberDTO) session.getAttribute("memberInfo");
		int member_no = loginInfo.getMember_no();
		ForwardAction forward = new ForwardAction();
		List<CategoryDTO> list = service.categoryList();
		request.setAttribute("list", list);
		request.setAttribute("loginNo", member_no);
		forward.setRedirect(false);
		forward.setPath("/cafe/template/category.jsp?page=cafe/category/categorylist.jsp");
		return forward;
	}

}
