package kz.alibi.access.delegate;

import kz.alibi.access.config.ProcessVariablesConstants;
import kz.alibi.access.service.AccessRequestService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public UpdateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariablesConstants.ENTITY_ID);
        String approved = (String) delegateExecution.getVariable(ProcessVariablesConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(ProcessVariablesConstants.IS_APPROVED);

        accessRequestService.update(entityId, approved, isApproved);
    }
}
