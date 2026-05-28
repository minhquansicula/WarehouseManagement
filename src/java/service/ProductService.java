package service;

import dao.ProductDAO;
import dto.ProductDTO;
import java.util.List;

/**
 * Service layer for products - wraps DAO calls and implements business rules.
 */
public class ProductService {
    private ProductDAO dao = new ProductDAO();

    public List<ProductDTO> listProducts(int page, int pageSize) throws Exception {
        int offset = (page - 1) * pageSize;
        return dao.listProducts(offset, pageSize);
    }

    public int countAll() throws Exception {
        return dao.countAll();
    }
}
