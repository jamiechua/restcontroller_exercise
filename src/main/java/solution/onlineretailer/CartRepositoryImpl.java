package solution.onlineretailer;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Component
@SessionScope
public class CartRepositoryImpl implements CartRepository {

	// Map of item IDs and quantities.
	private Map<Integer, Integer> cart = new HashMap<>();
	
	public void add(int itemId, int quantity) {
		Integer existingQuantity = cart.get(itemId);
		if (existingQuantity != null) {
			quantity += existingQuantity;			
		}
		cart.put(itemId,  quantity);
	}
	
	public void remove(int itemId) {
		cart.remove(itemId);
	}
	
	public Map<Integer, Integer> getAll() {
		return cart;
	}
}
