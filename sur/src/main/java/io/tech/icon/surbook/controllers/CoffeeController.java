package io.tech.icon.surbook.controllers;

import io.tech.icon.surbook.modals.Coffee;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees")
public class CoffeeController
{
    private final List<Coffee> coffees = new ArrayList<>();

    public CoffeeController()
    {
        coffees.add(new Coffee("Café Cereza"));
        coffees.add(new Coffee("Café Ganador"));
        coffees.add(new Coffee("Café Lareño"));
        coffees.add(new Coffee("Café Três Pontas"));
    }

    @GetMapping
    public List<Coffee> getCoffees()
    {
        return coffees;
    }

    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable @NonNull String id)
    {
        return coffees.stream()
                .findAny()
                .filter(c -> c.getId().equals(id));
    }

    @PostMapping
    public Coffee postCoffee(@RequestBody @NonNull Coffee coffee)
    {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable @NonNull String id, @RequestBody @NonNull Coffee coffee)
    {
        int coffeeIndex = -1;

        for (Coffee c : coffees){
            if (c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }

        return (coffeeIndex == -1) ?
                new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
                new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable @NonNull String id)
    {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
