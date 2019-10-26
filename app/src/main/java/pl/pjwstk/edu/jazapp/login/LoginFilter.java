package pl.pjwstk.edu.jazapp.login;

import pl.pjwstk.edu.jazapp.webapp.SessionAllezon;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
class LoginFilter extends HttpFilter {
    @Inject
    private SessionAllezon sesyjka;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        boolean isStaticResource = req.getRequestURI().startsWith("/webapp/");

        if (req.getRequestURI().contains("/login.xhtml") || req.getRequestURI().contains("/register.xhtml") || req.getRequestURI().contains("/index.xhtml") || isStaticResource) {
            chain.doFilter(req, res);
        } else if (!sesyjka.isLoggedIn()) {
            res.sendRedirect("login.xhtml");
        } else chain.doFilter(req, res);

        System.out.println(req.getRequestURI().contains("/login.xhtml"));
        System.out.println(req.getRequestURI().contains("/register.xhtml"));

    }
}