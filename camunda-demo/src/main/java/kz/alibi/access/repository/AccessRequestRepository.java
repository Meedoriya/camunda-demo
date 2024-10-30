package kz.alibi.access.repository;

import java.util.Optional;
import kz.alibi.access.model.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    Optional<AccessRequest> findByEntityId(Long entityId);
}
