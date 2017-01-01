package util;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotRule extends TestWatcher {

  private WebDriver driver;

  @Override
  protected void failed(Throwable e, Description description) {
    File scrFile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(scrFile, new File(description.getMethodName() + ".png"));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    System.out.println("Test sucessceded " + description.getMethodName());
  }

  @Override
  protected void succeeded(Description description) {
    System.out.println("Test sucessceded " + description.getMethodName());
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }
}