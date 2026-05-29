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

    public ProductDTO getById(int id) throws Exception {
        return dao.getById(id);
    }

    public int create(ProductDTO p) throws Exception {
        return dao.insert(p);
    }

    public void update(ProductDTO p) throws Exception {
        dao.update(p);
    }

    public void delete(int id) throws Exception {
        dao.delete(id);
    }
}
