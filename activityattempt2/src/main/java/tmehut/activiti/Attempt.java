package tmehut.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * Hello world!
 *
 */
public class Attempt 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! updated 8" );
        try{
			//System.out.println(ProcessEngines.class.getName());
			//System.out.println(ProcessEngines.getDefaultProcessEngine().getName());
        	ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		} catch(NoClassDefFoundError e) {
			System.out.println("Exception: NoClassDefFoundError " + e.getMessage());
		}
		
		System.out.println("Recovered from exception");
    }
}
