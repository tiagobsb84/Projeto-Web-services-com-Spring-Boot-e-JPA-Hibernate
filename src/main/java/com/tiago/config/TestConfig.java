package com.tiago.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiago.entities.Category;
import com.tiago.entities.OrdemItem;
import com.tiago.entities.Order;
import com.tiago.entities.Payment;
import com.tiago.entities.Product;
import com.tiago.entities.User;
import com.tiago.entities.enums.OrderStatus;
import com.tiago.repositories.CategoryRepository;
import com.tiago.repositories.OrdemItemRepository;
import com.tiago.repositories.OrderRepository;
import com.tiago.repositories.ProductsRepository;
import com.tiago.repositories.UserRepository;

@Configuration
@Profile("products")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrdemItemRepository ordemItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productsRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productsRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAGO, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrdemItem oi1 = new OrdemItem(o1, p1, 2, p1.getPrice()); 
		OrdemItem oi2 = new OrdemItem(o1, p3, 1, p3.getPrice()); 
		OrdemItem oi3 = new OrdemItem(o2, p3, 2, p3.getPrice()); 
		OrdemItem oi4 = new OrdemItem(o3, p5, 2, p5.getPrice()); 
		
		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T20:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
	}
}
