package form;

import org.apache.struts.action.ActionForm;

public class SupplierForm extends ActionForm {
    private int id;
    private String name;
    private String contact;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
