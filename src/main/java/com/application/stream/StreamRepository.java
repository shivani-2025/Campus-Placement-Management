
package com.application.model.stream;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends JpaRepository<Stream, Long> {

	Optional<Stream> findById(Integer id);
    // Spring Data JPA automatically provides methods like:
    // save(), findById(), findAll(), deleteById(), etc.
}