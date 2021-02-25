package com.strzelczyk.Springbootapp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {
}
