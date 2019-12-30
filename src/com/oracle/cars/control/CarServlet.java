package com.oracle.cars.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cars.model.Car;
import com.oracle.cars.model.CarDAO;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private CarDAO dao=new CarDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("查询显示有的后台方法");
				//1.调用dao方法查询所有的车辆信息
				List<Car> cars=dao.listAll();
				
				System.out.println(cars.size());
				//2.将查询出来的数据存储到request范围内
				request.setAttribute("cars", cars);
				//3.跳转到显示所有车辆的jsp页面上
				request.getRequestDispatcher("carList.jsp").forward(request, response);
				break;
			}
			case "add":
			{
				System.out.println("添加二手车的方法");
				break;
			}
			case "delete":
			{
				System.out.println("删除二手车的方法");
				//1.获取页面超链接传过来的要删除的车辆id
				String carid=request.getParameter("carid");
				
				//2.调用dao的删除方法删除这个车辆信息
				boolean result=dao.deleteCar(Integer.parseInt(carid));
				//3.将删除操作的结果存储到request范围内，然后到页面判断结果提示用户
				request.setAttribute("deleteResult", result);
				
				//4.删除执行完毕，无论成功还是失败都要跳转到列表页面
				request.getRequestDispatcher("CarServlet?method=listAll").forward(request, response);
				break;
			}
			case "update":
			{
				System.out.println("修改二手车的方法");
				break;
			}
		}
	}

}
