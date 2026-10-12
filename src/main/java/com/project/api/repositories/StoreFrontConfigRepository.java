package com.project.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreFrontConfigRepository {
	
	@Query("""
            SELECT CASE WHEN COUNT(u) > 0
            THEN TRUE
            ELSE FALSE
            END
            FROM StoreFrontConfig sfc WHERE sfc.storeApiKey = :hash
        """)
	Boolean existsByKeyHashAndActiveTrue(String hash);
}
