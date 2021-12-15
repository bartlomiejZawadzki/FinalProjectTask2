package Pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenShotFormPage extends BasePage {

    public ScreenShotFormPage (WebDriver driver) {
        super(driver);
    }

    public void takeScreenshot() {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C://tmp//FullPageScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
