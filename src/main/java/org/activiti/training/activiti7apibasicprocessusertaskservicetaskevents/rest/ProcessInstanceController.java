package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;

import org.activiti.runtime.api.ProcessRuntime;
import org.activiti.runtime.api.model.ProcessInstance;
import org.activiti.runtime.api.model.ProcessInstanceMeta;
import org.activiti.runtime.api.query.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ReST controller to get some info about a process instance
 *
 */
@RestController
public class ProcessInstanceController {
    private Logger logger = LoggerFactory.getLogger(ProcessInstanceController.class);

    @Autowired
    private ProcessRuntime processRuntime;

    @GetMapping("/process-instances")
    public List<ProcessInstance> getProcessInstances() {
        List<ProcessInstance> processInstances =
                processRuntime.processInstances(Pageable.of(0, 10)).getContent();

        return processInstances;
    }

    @GetMapping("/process-instance-meta")
    public ProcessInstanceMeta getProcessInstanceMeta(@RequestParam(value="processInstanceId") String processInstanceId) {
        ProcessInstanceMeta processInstanceMeta = processRuntime.processInstanceMeta(processInstanceId);

        return processInstanceMeta;
    }
}
