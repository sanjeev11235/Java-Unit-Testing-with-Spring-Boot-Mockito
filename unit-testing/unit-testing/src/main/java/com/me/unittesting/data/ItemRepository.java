package com.me.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.me.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
