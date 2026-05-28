package action;

import form.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Simple login action demonstrating authentication and session setup.
 */
public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm lf = (LoginForm) form;
        String username = lf.getUsername();
        String password = lf.getPassword();

        // TODO: replace with real authentication via UserDAO and hashed passwords
        if ("admin".equals(username) && "admin".equals(password)) {
            request.getSession().setAttribute("currentUser", username);
            return mapping.findForward("success");
        } else {
            request.setAttribute("loginError", "Invalid username or password");
            return mapping.findForward("input");
        }
    }
}
