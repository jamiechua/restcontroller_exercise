package solution.onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // Get profile-specific properties.
        ResourcesBean resourcesBean = context.getBean(ResourcesBean.class);
        System.out.println("Profile-specific properties: " + resourcesBean);
    }

    @Bean
    @Scope("application")
    public Map<Integer, Item> catalog() {
        Map<Integer, Item> items = new HashMap<>();
        items.put(0, new Item(0, "Apple Mac Book Pro", 2499.99));
        items.put(1, new Item(1, "32GB San Disk", 15.99));
        items.put(2, new Item(2, "OLED 64in TV", 1800.99));
        items.put(3, new Item(3, "Wireless Mouse", 10.59));
        items.put(4, new Item(4, "Virtual Reality HeadSet", 200.59));
        items.put(5, new Item(5, "Sat Nav", 159.99));
        return items;
    }
}
