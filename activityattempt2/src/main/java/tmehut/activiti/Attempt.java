package tmehut.activiti;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.log4j.BasicConfigurator;

/**
 * Attempt
 * 
 */
public class Attempt 
{
    public static void main( String[] args )
    {
    	//configure log4j
    	BasicConfigurator.configure();
        
    	try{
        	
    		/* Creating default standalone ProcessEngine without using activiti.cfg.xml file */
    		//ProcessEngine processEngine = ProcessEngineConfiguration
        	//		   .createStandaloneInMemProcessEngineConfiguration()
        	//		   .buildProcessEngine();
        	
    		
    		/* The easiest way to obtain a ProcessEngine, is to use the org.activiti.engine.ProcessEngines class:
    		 * ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine()
			 * This will look for an activiti.cfg.xml file on the classpath and construct an engine based on the configuration 
			 * in that file. The following snippet shows an example configuration. The following sections will give a detailed 
			 * overview of the configuration properties.
			 */    		
    		 ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    		 System.out.println("Process Engine Name = " + processEngine.getName());
    		
    		 //Deploying process from the definition file repository/diagrams/myProcess.bpmn20.xml
    		 RepositoryService repositoryService = processEngine.getRepositoryService();
    		 DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
    		 deploymentBuilder.addClasspathResource("diagrams/myProcess.bpmn20.xml");
    		 deploymentBuilder.deploy();
    		 
    		 //Starting the deployed process instance by key <process id="my-process">
    		 RuntimeService runtimeService = processEngine.getRuntimeService();
    		 ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("my-process");
    		    		 
    		 //Working with tasks
    		 TaskService taskService = processEngine.getTaskService();
    		 try {
    			 
    			 //get active task
        		 Task task = taskService.createTaskQuery().active().singleResult();
        		 System.out.println(task.getName());
        		 System.out.println(task.getId());
        		 
        		 System.out.println("task asignee = " + task.getAssignee());
        		 
        		 taskService.complete(task.getId());
        		 task = taskService.createTaskQuery().active().singleResult();
        		 System.out.println(task.getName());
        		 
        		 //runtimeService.suspendProcessInstanceById(processInstance.getId());
        		 
				
			} catch (NullPointerException e) {
				// TODO: handle exception
				System.out.println("TMEHUT: NullPointerException");
			} catch (ActivitiException e) {
				// TODO: handle exception
				System.out.println("TMEHUT: ActivityException - more than 1 tasks fullfills the defined criteria");
			}
    		 
    		       	
		} catch(NoClassDefFoundError e) {
			System.out.println("Exception: NoClassDefFoundError " + e.getMessage());
		}
		
		System.out.println("END");
   }
}
