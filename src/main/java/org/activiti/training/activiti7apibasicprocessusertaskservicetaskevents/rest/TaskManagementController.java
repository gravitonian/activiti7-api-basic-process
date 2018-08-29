package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;

import org.activiti.runtime.api.TaskRuntime;
import org.activiti.runtime.api.model.Task;
import org.activiti.runtime.api.query.Page;
import org.activiti.runtime.api.query.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ReST controller to manage user tasks
 *
 */
@RestController
public class TaskManagementController {
    private Logger logger = LoggerFactory.getLogger(TaskManagementController.class);

    @Autowired
    private TaskRuntime taskRuntime;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        logger.info("> Available Tasks: " + tasks.getTotalItems());

        for (Task task : tasks.getContent()) {
            logger.info("\t > User Task: " + task);
        }

        return tasks.getContent();
    }
}
