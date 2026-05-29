package action;

import form.ProductForm;
import dto.ProductDTO;
import service.ProductService;
import service.SupplierService;
import entity.Supplier;
import java.util.ArrayList;
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
    private SupplierService supplierService = new SupplierService();

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
            try {
                // load suppliers for dropdown
                java.util.List<Supplier> suppliers = supplierService.listAll();
                request.setAttribute("suppliers", suppliers);
            } catch (Exception e) {
                request.setAttribute("suppliers", new ArrayList<Supplier>());
            }
            String idStr = request.getParameter("id");
            if (idStr != null) {
                try {
                    int id = Integer.parseInt(idStr);
                    ProductDTO dto = service.getById(id);
                    request.setAttribute("product", dto);
                } catch (Exception e) {
                    // ignore
                }
            }
            return mapping.findForward("form");
        } else if (op.equals("create")) {
            ProductForm pf = (ProductForm) form;
            ProductDTO dto = new ProductDTO();
            dto.setName(pf.getName());
            dto.setPrice(pf.getPrice());
            dto.setStock(pf.getStock());
            dto.setSupplierId(pf.getSupplierId());
            service.create(dto);
            return new ActionForward(request.getContextPath() + "/products.do", true);
        } else if (op.equals("edit")) {
            // show edit form
            try {
                java.util.List<Supplier> suppliers = supplierService.listAll();
                request.setAttribute("suppliers", suppliers);
            } catch (Exception e) {
                request.setAttribute("suppliers", new ArrayList<Supplier>());
            }
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                ProductDTO dto = service.getById(id);
                request.setAttribute("product", dto);
            }
            return mapping.findForward("form");
        } else if (op.equals("update")) {
            ProductForm pf = (ProductForm) form;
            ProductDTO dto = new ProductDTO();
            dto.setId(pf.getId());
            dto.setName(pf.getName());
            dto.setPrice(pf.getPrice());
            dto.setStock(pf.getStock());
            dto.setSupplierId(pf.getSupplierId());
            service.update(dto);
            return new ActionForward(request.getContextPath() + "/products.do", true);
        } else if (op.equals("delete")) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                service.delete(id);
            }
            return new ActionForward(request.getContextPath() + "/products.do", true);
        }
        return mapping.findForward("list");
    }
}
