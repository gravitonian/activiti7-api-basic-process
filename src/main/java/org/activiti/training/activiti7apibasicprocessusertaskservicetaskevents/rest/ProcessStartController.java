package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;

import org.activiti.runtime.api.ProcessRuntime;
import org.activiti.runtime.api.model.ProcessInstance;
import org.activiti.runtime.api.model.builders.ProcessPayloadBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ReST controller to start processes
 *
 */
@RestController
public class ProcessStartController {
    private Logger logger = LoggerFactory.getLogger(ProcessStartController.class);

    @Autowired
    private ProcessRuntime processRuntime;

    @RequestMapping("/start-process")
    public ProcessInstance startProcess(
            @RequestParam(value="processDefinitionKey", defaultValue="SampleProcess") String processDefinitionKey) {
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey(processDefinitionKey)
                .withProcessInstanceName("Sample Process: " + new Date())
                .withVariable("someProcessVar", "someProcVarValue")
                .build());
        logger.info(">>> Created Process Instance: " + processInstance);

        return processInstance;
    }
}
