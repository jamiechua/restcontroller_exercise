package solution.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CartController {

	@Autowired
	private Map<Integer, Item> catalog;
	
	@Autowired
	private CartService service;
	
    @RequestMapping("/")
    public String showCatalog() {
        return "catalog";
    }

    @RequestMapping("/addItemToCart")
    public String addItemToCart(Model model, @RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
        if (id != null && quantity != null) {
	    	service.addItemToCart(id, quantity);
	    	model.addAttribute("message", 
	    			            String.format("Added to cart: %s [x%d]", catalog.get(id).getDescription(), quantity));
        }
        return "catalog";
    }

    @RequestMapping("/showCart")
    public String showCart(Model model) {
    	model.addAttribute("cart", service.getAllItemsInCart());  
    	model.addAttribute("cartCost", String.format("£%.2f", service.calculateCartCost()));
    	model.addAttribute("salesTax", String.format("£%.2f", service.calculateSalesTax()));
    	model.addAttribute("deliveryCharge", String.format("£%.2f", service.calculateDeliveryCharge()));
    	return "cart";
    }

    @RequestMapping("/removeItemFromCart")
    public String removeItemFromCart(Model model, @RequestParam("id") Integer id) {
        if (id != null) {
	    	service.removeItemFromCart(id);
        }
        return showCart(model);
    }
}