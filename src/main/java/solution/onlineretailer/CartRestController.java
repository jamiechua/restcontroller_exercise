package solution.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CartRestController {

    @Autowired
    private Map<Integer, Item> catalog;

    @Autowired
    private CartService cartservice;

    @GetMapping("/getAll")
    public List<Item> getAllItems(){
        Map<Integer, Integer> cartitems = cartservice.getAllItemsInCart();
        List<Item> items = new ArrayList<Item>();
        for(var id:cartitems.keySet()){
            items.add(catalog.get(id));
        }
        return items;
    }

    @GetMapping("/cartCost")
    public double getCartCost(){
        double cost = cartservice.calculateCartCost();
        return cost;
    }

    @GetMapping("/quantityForItem/{itemId}")
    public int getQuantityForItem(@PathVariable int itemId){
        Map<Integer, Integer> cartitems = cartservice.getAllItemsInCart();
        if(cartitems.get(itemId)==null){
            return 0;
        }
        return cartitems.get(itemId);
    }

    @ModelAttribute("newItems")
    public List<Item> populateCart() {
        List<Item> offices = new ArrayList<Item>();
        offices.add(new Item(8, "England", 3));
        offices.add(new Item(9, "France",  7));
        offices.add(new Item(10,"USA",     8));
        offices.add(new Item(11,"Norway",  9));
        offices.add(new Item(12,"Wales",   11));
        return offices;
    }

    @GetMapping("/office")
    public Item populateCart(
            @RequestParam(value="index", required=false, defaultValue="0") int index,
            ModelMap model) {
        List<Item> offices = (List<Item>) model.get("newItems");
        if (index < 0 || index >= offices.size())
            index = 0;

        return offices.get(index);
    }

}
