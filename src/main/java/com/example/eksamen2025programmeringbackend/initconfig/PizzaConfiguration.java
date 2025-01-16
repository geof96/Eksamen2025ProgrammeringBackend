package com.example.eksamen2025programmeringbackend.initconfig;

import com.example.eksamen2025programmeringbackend.model.Pizza;
import com.example.eksamen2025programmeringbackend.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PizzaConfiguration implements CommandLineRunner {

    @Autowired
    PizzaRepository pizzaRepository;

    @Override
    public void run(String... args) throws Exception {
if (pizzaRepository.count() == 0 || pizzaRepository.count()<=5){
    Pizza pizza1 = new Pizza();
    pizza1.setPizzaTitel("Margherita");
    pizza1.setPizzaPris(60);
    pizzaRepository.save(pizza1);

    Pizza pizza2 = new Pizza();
    pizza2.setPizzaTitel("Pepperoni");
    pizza2.setPizzaPris(80);
    pizzaRepository.save(pizza2);

    Pizza pizza3 = new Pizza();
    pizza3.setPizzaTitel("Vegetarian");
    pizza3.setPizzaPris(75);
    pizzaRepository.save(pizza3);

    Pizza pizza4 = new Pizza();
    pizza4.setPizzaTitel("BBQ Chicken");
    pizza4.setPizzaPris(85);
    pizzaRepository.save(pizza4);

    Pizza pizza5 = new Pizza();
    pizza5.setPizzaTitel("Hawaiian");
    pizza5.setPizzaPris(70);
    pizzaRepository.save(pizza5);

}
    }
}
