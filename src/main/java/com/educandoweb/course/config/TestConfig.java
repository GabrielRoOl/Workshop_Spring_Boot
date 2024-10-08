package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category category = new Category(null, "Electronic");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");

		Product product = new Product(null, "the lord of the rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,
				"");
		Product product2 = new Product(null, "smart tv", "nulla eu imperdiet purus.", 2190.0, "");
		Product product3 = new Product(null, "macbook pro", "nam eleifend maximus tortor", 1250.0, "");
		Product product4 = new Product(null, "pc gamer", "donec aliquet odio", 1200.0, "");
		Product product5 = new Product(null, "rails for dummies", "cras fringilla", 100.99, "");

		User user = new User(null, "Maria Brow", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order order = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.PAID, user);
		Order order2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user);

		userRepository.saveAll(Arrays.asList(user, user2));
		orderRepository.saveAll(Arrays.asList(order, order2, order3));
		categoryRepository.saveAll(Arrays.asList(category, category2, category3));
		productRepository.saveAll(Arrays.asList(product, product2, product3, product4, product5));

	}

}
