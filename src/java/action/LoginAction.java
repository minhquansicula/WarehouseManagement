package action;

import form.LoginForm;
import dao.UserDAO;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

    @Override
    public ActionForward execute(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        LoginForm lf = (LoginForm) form;

        String username = lf.getUsername();
        String password = lf.getPassword();

        try {
            UserDAO dao = new UserDAO();
            User user = dao.authenticate(username, password);

            if (user != null) {
                request.getSession().setAttribute("currentUser", user.getUsername());
                request.getSession().setAttribute("currentUserRole", user.getRole());
                request.getSession().setAttribute("currentUserId", user.getId());
                return mapping.findForward("success");
            } else {
                request.setAttribute("loginError", "Invalid username or password");
                return mapping.findForward("input");
            }

        } catch (Exception e) {
            request.setAttribute("loginError", "Login failed: " + e.getMessage());
            return mapping.findForward("input");
        }
    }
}