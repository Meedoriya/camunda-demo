package kz.alibi.access.service;

public interface AccessRequestService {
    Long create(Long entityId, String username, String comment);

    void update(Long entityId, String approver, Boolean isApproved);
}
