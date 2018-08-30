package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.rest;

import org.activiti.runtime.api.TaskAdminRuntime;
import org.activiti.runtime.api.TaskRuntime;
import org.activiti.runtime.api.model.ProcessInstance;
import org.activiti.runtime.api.model.Task;
import org.activiti.runtime.api.model.builders.ProcessPayloadBuilder;
import org.activiti.runtime.api.model.builders.TaskPayloadBuilder;
import org.activiti.runtime.api.query.Page;
import org.activiti.runtime.api.query.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @Autowired
    private TaskAdminRuntime taskAdminRuntime;

    @GetMapping("/my-tasks")
    public List<Task> getMyTasks() {
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        logger.info("> My Available Tasks: " + tasks.getTotalItems());

        for (Task task : tasks.getContent()) {
            logger.info("\t > My User Task: " + task);
        }

        return tasks.getContent();
    }

    /**
     * Need to be logged in as admin to use this call
     */
    @GetMapping("/all-tasks")
    public List<Task> getAllTasks() {
        Page<Task> tasks = taskAdminRuntime.tasks(Pageable.of(0, 10));
        logger.info("> All Available Tasks: " + tasks.getTotalItems());

        for (Task task : tasks.getContent()) {
            logger.info("\t > User Task: " + task);
        }

        return tasks.getContent();
    }

    @RequestMapping("/complete-task")
    public String completeTask(@RequestParam(value="taskId") String taskId) {
        taskRuntime.complete(TaskPayloadBuilder.complete()
                .withTaskId(taskId).build());
        logger.info(">>> Completed Task: " + taskId);

        return "Completed Task: " + taskId;
    }

}
