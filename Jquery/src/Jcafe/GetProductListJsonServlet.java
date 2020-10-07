package Jcafe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


@WebServlet("/GetProductListJsonServlet")
public class GetProductListJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetProductListJsonServlet() {
        super();
      
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ProductDAO dao = new ProductDAO();
		List<ProductVO> list = dao.getProductList();
		response.getWriter().append(JSONArray.fromObject(list).toString());//response.getWriter()는 페이지에 찍어내는 역활을 하고 append뒤에는 추가할 내용을 추가한다.
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
