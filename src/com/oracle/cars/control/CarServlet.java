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
				System.out.println("查询显示所有后台方法");
				
				List<Car> cars=dao.listAll();
				
				System.out.println(cars.size());
				
				request.setAttribute("cars", cars);
				
				request.getRequestDispatcher("carList.jsp").forward(request, response);
				break;
			}
			case "add":
			{
				System.out.println("添加二手车方法");
				String pinpaiming=request.getParameter("pinpaiming");
				String xilie=request.getParameter("xilie");
				
				String gonglishu=request.getParameter("gonglishu");
				
				String yanse=request.getParameter("yanse");
				String shoujia=request.getParameter("shoujia");
				Car car=new Car();
				car.setGonglishu(Integer.parseInt(gonglishu));
				car.setPinpaiming(pinpaiming);
				car.setShoujia(Integer.parseInt(shoujia));
				car.setXielie(xilie);
				car.setYanse(yanse);
				
				boolean result=dao.addCar(car);
			    if(result) {
			    	request.getRequestDispatcher("CarServlet?method=lisAll").forward(request,response);
			    }else {
			    	request.getRequestDispatcher("carAdd.jsp?").forward(request,response);
			    }
				
				
				break;
			}
			case "delete":
			{
				System.out.println("删除二手车方法");
				String carid=request.getParameter("carid");
				
				boolean result=dao.deleteCar(Integer.parseInt(carid));
				request.setAttribute("deleteResult", result);
				
				request.getRequestDispatcher("CarServlet?method=listAll").forward(request, response);
				break;
			}
			case "update":
			{
				System.out.println("修改二手车方法");
				break;
			}
		}
	}

}
