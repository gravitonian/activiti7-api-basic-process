/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
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
