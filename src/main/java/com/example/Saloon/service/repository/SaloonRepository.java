package com.example.Saloon.service.repository;

import com.example.Saloon.service.modal.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaloonRepository extends JpaRepository<Saloon,Long> {

    Saloon findByOwnerId(Long id);

    @Query("SELECT s FROM Saloon s WHERE " +
            "LOWER(s.city) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")

    List<Saloon> searchSaloons(@Param("keyword")String keyword);

}
