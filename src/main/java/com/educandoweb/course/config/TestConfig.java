package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null, "Maria Brow", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order order = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.PAID, user);
		Order order2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
		Order order3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user);

		userRepository.saveAll(Arrays.asList(user, user2));
		orderRepository.saveAll(Arrays.asList(order, order2, order3));

	}

}
