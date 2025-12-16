
package com.application.model.stream;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stream") // Maps to the SQL table name
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Corresponds to INT PRIMARY KEY AUTO_INCREMENT

    // Corresponds to VARCHAR(50) NOT NULL
    // In JPA, the NOT NULL constraint is enforced by the database, 
    // but you might use validation annotations (like @NotBlank) for application-level checks.
    private String streamName;

    // --- Constructors ---

    public Stream() {
    }

    public Stream(String streamName) {
        this.streamName = streamName;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

	
	}
