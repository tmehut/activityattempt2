package tmehut.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
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
		} catch(NoClassDefFoundError e) {
			System.out.println("Exception: NoClassDefFoundError " + e.getMessage());
		}
		
		System.out.println("Recovered from exception if any");
   }
}
