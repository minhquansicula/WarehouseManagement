package validator;

import form.ProductForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

/**
 * Basic product validator used from actions or forms.
 */
public class ProductValidator {
    public static ActionErrors validate(ProductForm form) {
        ActionErrors errors = new ActionErrors();
        if (form.getName() == null || form.getName().trim().isEmpty()) {
            errors.add("name", new ActionMessage("error.product.name.required"));
        }
        if (form.getPrice() < 0) {
            errors.add("price", new ActionMessage("error.product.price.invalid"));
        }
        return errors;
    }
}
