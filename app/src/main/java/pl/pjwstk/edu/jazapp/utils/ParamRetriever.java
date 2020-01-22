package pl.pjwstk.edu.jazapp.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ApplicationScoped
public class ParamRetriever {
    @Inject
    private HttpServletRequest request;

    public boolean contains(String paramKey) {
        return request.getParameter(paramKey) != null;
    }

    public Long getLong(String paramKey) throws NumberFormatException {
        var paramValue = request.getParameter(paramKey);
        return Long.parseLong(paramValue);
    }
}
