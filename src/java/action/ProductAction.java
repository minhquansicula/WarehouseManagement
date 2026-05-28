package action;

import form.ProductForm;
import dto.ProductDTO;
import service.ProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

/**
 * Simple ProductAction demonstrating list and form flows.
 * It uses a request parameter `op` to choose the operation: list, form.
 */
public class ProductAction extends Action {
    private ProductService service = new ProductService();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String op = request.getParameter("op");
        if (op == null || op.equals("list")) {
            int page = 1;
            int pageSize = 10;
            try { page = Integer.parseInt(request.getParameter("page")); } catch (Exception e) { }
            List<ProductDTO> list = service.listProducts(page, pageSize);
            int total = service.countAll();
            request.setAttribute("products", list);
            request.setAttribute("total", total);
            request.setAttribute("page", page);
            request.setAttribute("pageSize", pageSize);
            return mapping.findForward("list");
        } else if (op.equals("form")) {
            // show add/edit form
            return mapping.findForward("form");
        }
        return mapping.findForward("list");
    }
}
