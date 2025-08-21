package com.Mamoun.HRFDE.repository;

import com.Mamoun.HRFDE.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoadRepository extends JpaRepository<Load, java.util.UUID> {

    List<Load> findByOriginIgnoreCaseContaining(String origin);
    List<Load> findByDestinationIgnoreCaseContaining(String destination);
    List<Load> findByOriginIgnoreCaseContainingAndDestinationIgnoreCaseContaining(String origin, String destination);
}
