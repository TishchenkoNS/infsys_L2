package com.example.testt;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    public List<Expense> findByItem(String item);


    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Expense e SET e.item = :item, e.amount = :amount WHERE e.id = :id")
    int updateAddress(@Param("id") long id, @Param("item") String item, @Param("amount") Float amount);
}
