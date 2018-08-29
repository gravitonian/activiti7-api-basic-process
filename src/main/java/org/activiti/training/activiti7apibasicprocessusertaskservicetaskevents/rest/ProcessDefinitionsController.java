package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;


import org.activiti.runtime.api.ProcessRuntime;
import org.activiti.runtime.api.model.ProcessDefinition;
import org.activiti.runtime.api.query.Page;
import org.activiti.runtime.api.query.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ReST controller to interact with deployed process definitions
 *
 */
@RestController
public class ProcessDefinitionsController {
    private Logger logger = LoggerFactory.getLogger(ProcessDefinitionsController.class);

    @Autowired
    private ProcessRuntime processRuntime;

    @GetMapping("/process-definitions")
    public List<ProcessDefinition> getProcessDefinitions() {
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());

        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            logger.info("\t > Process definition: " + pd);
        }

        return processDefinitionPage.getContent();
    }
}
