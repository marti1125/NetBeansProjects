package controller;

import cliente.bean.ClienteBeanLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteController extends HttpServlet {

	@EJB
	ClienteBeanLocal bean;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String alias = request.getServletPath();
		if (alias.equals("/consultarClienteApellido")) {
			consultarClienteApellido(request, response);
		}else if (alias.equals("/registrarCliente")) {
            registrarCliente(request, response);
        }


	}

	private void consultarClienteApellido(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		try {
			String apellido = request.getParameter("apellido");
			List lista = bean.consultarClienteApellido(apellido);
			request.setAttribute("lista", lista);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("consultar.jsp");
		rd.forward(request, response);
	}

        private void registrarCliente(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		try {
                    cliente.bean.ClienteBean cliente = new  cliente.bean.ClienteBean ();
                    cliente.registrarCliente(request.getParameter("DIS_ID").substring(0, 1));
                    cliente.registrarCliente(request.getParameter("CLI_NOMBRE"));
                    cliente.registrarCliente(request.getParameter("CLI_APELLIDO"));
                    cliente.registrarCliente(request.getParameter("CLI_INGRESOS"));
                    cliente.registrarCliente(request.getParameter("CLI_EDAD"));
                    cliente.registrarCliente(request.getParameter("CLI_SEXO"));
		



		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("registrar.jsp");
		rd.forward(request, response);
	}




}

