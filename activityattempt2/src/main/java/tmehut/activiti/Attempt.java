package tmehut.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
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
        	ProcessEngine processEngine = ProcessEngineConfiguration
        			   .createStandaloneInMemProcessEngineConfiguration()
        			   .buildProcessEngine();

        	System.out.println("Process Engine Name = " + processEngine.getName());      	
		} catch(NoClassDefFoundError e) {
			System.out.println("Exception: NoClassDefFoundError " + e.getMessage());
		}
		
		System.out.println("Recovered from exception if any");
    }
}
