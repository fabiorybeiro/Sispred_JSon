package br.usjt.arqdesis.sispred.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.usjt.arqdesis.sispred.model.Usuario;

@WebFilter("/*") //Esse Filtro é utilizado em todos os controllers "/*"
public class LogFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("logado");
	
		if(usuario == null){
			System.out.println(req.getParameter("command"));
		} else {
			System.out.println(usuario.getUsername()+ " -> " + req.getParameter("command"));
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
