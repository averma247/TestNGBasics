package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	WebDriver driver;
	
	public static String takeSnapShot(WebDriver driver) throws IOException {
		System.out.println("Method performs screenshot actions");
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String destinationScreenShotFilePath = System.getProperty("user.dir") + "/Screenshots/Screenshots_" + dateName + ".png";
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(destinationScreenShotFilePath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        return destinationScreenShotFilePath;

	}

}
