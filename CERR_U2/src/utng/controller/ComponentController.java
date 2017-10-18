package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import utng.dom.ComponentDOM;

import utng.model.Component;


/**
 * Servlet implementation class ComponentController
 */
@WebServlet("/ComponentController")
public class ComponentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Component component; //Creamos el objeto
	private List<Component> components; //Lista de componentes
	private ComponentDOM componentDOM; //Modificamos la lista 
	private List<String> ids = new ArrayList<String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComponentController() {
    	super();
		component = new Component(); //Iniciamos los objetos creados arriba
		components = new ArrayList<Component>();
		componentDOM = new ComponentDOM();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {
			component.setUsername(request.getParameter("username"));
			try {
				component.setInstrumentId(Integer.parseInt(request.getParameter("instrumentId")));
				component.setComponentId(Integer.parseInt(request.getParameter("componentId")));
				
				
			} catch (Exception e) {
				component.setInstrumentId(5);
				component.setComponentId(5);
				
			}
			
			if (component.getCompId() == "") {
				String newId = "cmp"+String.format("%05d", 1);
				component.setCompId(newId);
				if(components.size()>0) {
					ids.clear();
					for(Component c: components) {
						ids.add(c.getCompId());
					}
					for(int i=0;i<=ids.size();i++) {
						newId = "cmp"+String.format("%05d", i+1);
						if(!ids.contains(newId)) {
							component.setCompId(newId);
							break;
						}
					}
				}
				
				componentDOM.add(component);
			} else {
				componentDOM.update(component);
			}
			components = componentDOM.getComponents();
			request.setAttribute("components", components);
			request.getRequestDispatcher("component_list.jsp").forward(request, response);
		} else if (request.getParameter("btn_new") != null) {
			component = new Component();
			request.getRequestDispatcher("component_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				String id = request.getParameter("compId");
				component = componentDOM.findById(id);
			}catch(Exception e) {
				component = new Component();
			}
			request.setAttribute("component", component);
			request.getRequestDispatcher("component_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				String id = request.getParameter("compId");
				componentDOM.delete(id);
				components = componentDOM.getComponents();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("components", components);
			request.getRequestDispatcher("component_list.jsp").forward(request, response);
		}else {
			components = componentDOM.getComponents();
			request.setAttribute("components", components);
			request.getRequestDispatcher("component_list.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
