package kz.alibi.access.service.impl;

import java.util.Optional;
import kz.alibi.access.model.AccessRequest;
import kz.alibi.access.repository.AccessRequestRepository;
import kz.alibi.access.service.AccessRequestService;
import org.springframework.stereotype.Service;

@Service
public class AccessRequestServiceImpl implements AccessRequestService {

    private final AccessRequestRepository accessRequestRepository;

    public AccessRequestServiceImpl(AccessRequestRepository accessRequestRepository) {
        this.accessRequestRepository = accessRequestRepository;
    }

    @Override
    public Long create(Long entityId, String username, String comment) {
        AccessRequest accessRequest = new AccessRequest();
        accessRequest.setEntityId(entityId);
        accessRequest.setUsername(username);
        accessRequest.setComment(comment);

        return accessRequestRepository.saveAndFlush(accessRequest).getId();
    }

    @Override
    public void update(Long entityId, String approver, Boolean isApproved) {
        Optional<AccessRequest> accessRequestOptional = accessRequestRepository.findByEntityId(entityId);
        if (accessRequestOptional.isPresent()) {
            AccessRequest accessRequest = accessRequestOptional.get();
            accessRequest.setApprover(approver);
            accessRequest.setIsApproved(isApproved);
            accessRequestRepository.saveAndFlush(accessRequest);
        }
    }
}
