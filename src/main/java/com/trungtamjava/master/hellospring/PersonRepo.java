package com.trungtamjava.master.hellospring;

import com.trungtamjava.master.hellospring.controller.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo
        extends JpaRepository<Person, Integer> {
    @Query("select person from Person person where person.age >= :min and person.age <= :max")
    List<Person> search(@Param("min") int min, @Param("max") int max);

    //where name =
    List<Person> findByName(String name);

    @Query("select person from Person person where person.age >= :min and person.age <= :max")

    //phan trang
    Page<Person> search(@Param("min") int min, @Param("max") int max, Pageable page);
    List<Person> findByName(String name, Pageable page);


}
