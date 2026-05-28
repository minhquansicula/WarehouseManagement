package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Dashboard action placeholder — collect stats here.
 */
public class DashboardAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Stub: gather dashboard statistics and put into request attributes
        request.setAttribute("totalProducts", 0);
        request.setAttribute("totalSuppliers", 0);
        request.setAttribute("recentInvoices", 0);
        return mapping.findForward("success");
    }
}
