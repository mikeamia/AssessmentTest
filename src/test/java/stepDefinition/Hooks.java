package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    public static Scenario myScenario;

    @Before
    public void before(Scenario sc){
        System.out.println("=======================================");
        System.out.println("============ Test Started =============");
        System.out.println("=======================================");
        System.out.println("Tag         : "+getTagFromScenario(sc));
        System.out.println("Scenario    : "+sc.getName());
        System.out.println("=======================================");
    }

    @After
    public void after(Scenario sc) {
        if (sc.isFailed()) {
            sc.embed(((TakesScreenshot) StepDefinition.driver).getScreenshotAs(OutputType.BYTES), "image/png");
            System.out.println("=======================================");
            System.out.println("========= Test Failed =========");
            System.out.println("=======================================");
            System.out.println("");
        } else {
            System.out.println("=======================================");
            System.out.println("========= Test SUCCESS =========");
            System.out.println("=======================================");
            System.out.println("");
            StepDefinition.driver.quit();
        }
        if ( StepDefinition.driver != null) {
        }
    }

    public String getTagFromScenario(Scenario sc) {
        String tag = null;
        tag = sc.getSourceTagNames().toString().replaceAll("[(\\W)]", "").replaceAll("[(a-z , A-Z)]", "");
        return tag;
    }

    public String getStatusScenario(Scenario sc) {
        String status = null;
        status = sc.getStatus();
        return status;
    }
}
