package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.connectors;

import org.activiti.runtime.api.connector.Connector;
import org.activiti.runtime.api.model.IntegrationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Implementation of Service Task as connector
 */
@Service(value = "helloWorld")
public class HelloWorldConnector implements Connector {
    private Logger logger = LoggerFactory.getLogger(HelloWorldConnector.class);

    public IntegrationContext execute(IntegrationContext integrationContext) {
        logger.info("Some service task logic... [processInstanceId=" + integrationContext.getProcessInstanceId() + "]");

        return integrationContext;
    }
}
