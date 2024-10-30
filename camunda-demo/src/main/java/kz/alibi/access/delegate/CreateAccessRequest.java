package kz.alibi.access.delegate;

import kz.alibi.access.config.ProcessVariablesConstants;
import kz.alibi.access.service.AccessRequestService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateAccessRequest implements JavaDelegate {

    private final AccessRequestService accessRequestService;

    public CreateAccessRequest(AccessRequestService accessRequestService) {
        this.accessRequestService = accessRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable(ProcessVariablesConstants.USERNAME);
        String comment = (String) delegateExecution.getVariable(ProcessVariablesConstants.COMMENT);
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariablesConstants.ENTITY_ID);

        Long id = accessRequestService.create(entityId, username, comment);

        delegateExecution.setVariable(ProcessVariablesConstants.ID, id);
    }
}
