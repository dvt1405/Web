package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BrandDAO;
import DAO.CarDAO;
import DAO.UserDAO;
import model.Brand;
import model.Car;
import model.User;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProductServlet")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			float price = Float.parseFloat(request.getParameter("price"));
			String img = request.getParameter("urlImage");
			Date now = new Date();
			if(name!=null && price!=0  ) {
				Car car = new Car();
				CarDAO cardao = new CarDAO();
				BrandDAO branddao = new BrandDAO();
				UserDAO userdao = new UserDAO();
				car.setName(name);
				car.setDescription(description);
				car.setPrice(price);
				car.setImage(img);
				car.setLastUpdate(now);
				car.setViews(0);
				car.setBrand((Brand) branddao.selectById(1));
				car.setUser((User) userdao.selectById(1));
				cardao.insert(car);
				userdao.closeConnection();
				branddao.closeConnection();
				cardao.closeConnection();
				response.sendRedirect("addProduct.jsp");
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
