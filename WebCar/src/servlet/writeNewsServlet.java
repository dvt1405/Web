package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import DAO.NewsDAO;
import DAO.UserDAO;
import model.Category;
import model.News;
import model.User;

/**
 * Servlet implementation class writeNews
 */
@WebServlet("/writeNewsServlet")
public class writeNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String endcoding = request.getCharacterEncoding();
			String title = request.getParameter("title");
			byte[] bt = title.getBytes();
			String value = new String(bt,Charset.forName("UTF-8"));
			String content = new String(request.getParameter("content").getBytes(), Charset.forName("UTF-8"));
			String img = new String(request.getParameter("urlImage").getBytes(), Charset.forName("UTF-8"));
			System.out.println(title+"  "+endcoding);
			System.out.println(value);
			Date now = new Date();
			if(title!=null && content!=null  ) {
				News news = new News();
				CategoryDAO cardao = new CategoryDAO();
				NewsDAO newsdao = new NewsDAO();
				UserDAO userdao = new UserDAO();
				news.setTitle(value);
				news.setContent(content);
				news.setImage(img);
				news.setLastUpdate(now);
				news.setViews(0);
				news.setCategory( (Category)cardao.selectById(1));
				news.setUser((User) userdao.selectById(1));
				newsdao.insert(news);
				userdao.closeConnection();
				newsdao.closeConnection();
				cardao.closeConnection();
				response.sendRedirect("writeNews.jsp");
			}else {
				System.out.println("ERRO!");
			}
		}catch(Exception ex) {
			response.sendRedirect("addProduct.jsp");
			PrintWriter out = response.getWriter();
			out.write("<p>Lỗi thêm sản phẩm </p>");
		}
	}

}
