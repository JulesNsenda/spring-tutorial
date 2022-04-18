package io.tech.icon.surbook;

import io.tech.icon.surbook.modals.Coffee;
import io.tech.icon.surbook.repositories.CoffeeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataLoader
{
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository)
    {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData()
    {
        List<Coffee> coffees = new ArrayList<>();

        coffees.add(new Coffee("Café Cereza"));
        coffees.add(new Coffee("Café Ganador"));
        coffees.add(new Coffee("Café Lareño"));
        coffees.add(new Coffee("Café Três Pontas"));

        this.coffeeRepository.saveAll(coffees);
    }
}
