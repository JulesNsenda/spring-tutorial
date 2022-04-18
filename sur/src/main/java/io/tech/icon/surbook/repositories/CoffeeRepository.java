package io.tech.icon.surbook.repositories;

import io.tech.icon.surbook.modals.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository
        extends CrudRepository<Coffee, String>
{
}
