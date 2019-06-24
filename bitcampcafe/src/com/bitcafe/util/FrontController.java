package com.bitcafe.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcafe.controller.Action;

/**
 * Servlet implementation class Front
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = { @WebInitParam(name = "init", value = "/WEB-INF/prop.properties") })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}
	private Hashtable<String, Action> ht = new Hashtable<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		String initial = config.getInitParameter("init");
		Properties prop = new Properties();
		FileReader fr = null;
		try {
			String path = config.getServletContext().getRealPath(initial);
			prop.load(new FileReader(path));
			Enumeration<Object> enu = prop.keys();
			while (enu.hasMoreElements()) {
				String key = (String) enu.nextElement();
				String value = (String) prop.get(key);
				Class c = Class.forName(value);
				Action act = (Action) c.newInstance();
				ht.put(key, act);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			System.out.println(e);
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		req(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		req(request, response);
	}
	private void req(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlpath = request.getServletPath();
		Action act = ht.get(urlpath);
		ForwardAction forward = act.execute(request, response);
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher disp = request.getRequestDispatcher(forward.getPath());
				disp.forward(request, response);
			}
		}
	}
}
