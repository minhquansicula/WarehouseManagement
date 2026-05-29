package service;

import dao.SupplierDAO;
import entity.Supplier;
import java.util.List;

public class SupplierService {
    private SupplierDAO dao = new SupplierDAO();

    public List<Supplier> listAll() throws Exception {
        return dao.listAll();
    }

    public Supplier getById(int id) throws Exception {
        return dao.getById(id);
    }

    public int create(Supplier s) throws Exception {
        return dao.insert(s);
    }

    public void update(Supplier s) throws Exception {
        dao.update(s);
    }

    public void delete(int id) throws Exception {
        dao.delete(id);
    }
}
