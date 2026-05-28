package form;

import org.apache.struts.action.ActionForm;

/**
 * Product form for add/edit operations.
 */
public class ProductForm extends ActionForm {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int supplierId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
}
