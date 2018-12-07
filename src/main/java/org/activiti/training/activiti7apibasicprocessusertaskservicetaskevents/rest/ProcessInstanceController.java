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
import org.activiti.api.process.model.ProcessInstanceMeta;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Pageable;
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
