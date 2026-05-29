package action;

import form.SupplierForm;
import service.SupplierService;
import entity.Supplier;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

/**
 * SupplierAction handles list/form/create/edit/update/delete
 */
public class SupplierAction extends Action {
    private SupplierService service = new SupplierService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String op = request.getParameter("op");
        if (op == null || op.equals("list")) {
            List<Supplier> list = service.listAll();
            request.setAttribute("suppliers", list);
            return mapping.findForward("list");
        } else if (op.equals("form")) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                Supplier s = service.getById(id);
                request.setAttribute("supplier", s);
            }
            return mapping.findForward("form");
        } else if (op.equals("create")) {
            SupplierForm sf = (SupplierForm) form;
            Supplier s = new Supplier();
            s.setName(sf.getName());
            s.setContact(sf.getContact());
            service.create(s);
            return new ActionForward(request.getContextPath() + "/suppliers.do", true);
        } else if (op.equals("edit")) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                Supplier s = service.getById(id);
                request.setAttribute("supplier", s);
            }
            return mapping.findForward("form");
        } else if (op.equals("update")) {
            SupplierForm sf = (SupplierForm) form;
            Supplier s = new Supplier();
            s.setId(sf.getId());
            s.setName(sf.getName());
            s.setContact(sf.getContact());
            service.update(s);
            return new ActionForward(request.getContextPath() + "/suppliers.do", true);
        } else if (op.equals("delete")) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                service.delete(id);
            }
            return new ActionForward(request.getContextPath() + "/suppliers.do", true);
        }
        return mapping.findForward("list");
    }
}
