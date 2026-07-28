package rei18;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderSurvlet
 */
@WebServlet("/OrderSurvlet")
public class OrderSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSurvlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		ServletContext app = request.getServletContext();
		MenuBean mb = (MenuBean) app.getAttribute("staticMenu");
		HttpSession session = request.getSession();
		
		try {
		OrderBean ob = (OrderBean)session.getAttribute("currentOrder");
		
			if(ob==null) {
				ob = new OrderBean();
				session.setAttribute("currentOrder", ob);
			}
		ob.addOrder(request.getParameter("name"),Integer.parseInt(request.getParameter("count")), mb);
		
		}catch(NumberFormatException e) {
			System.out.println("数量の入力が不正です。"+e.getMessage());
			e.printStackTrace();
		}catch(NullPointerException e) {
			System.out.println("参照先のメニューが存在しません"+e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("何らかの例外が発生しました"+e.getMessage());
			e.printStackTrace();
		}
		
		RequestDispatcher rd = app.getRequestDispatcher("/jsp/response.jsp");
		rd.forward(request, response);
	}
}
