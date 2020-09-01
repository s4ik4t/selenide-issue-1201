package sample;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.slf4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.slf4j.LoggerFactory.getLogger;

@Listeners({ SoftAsserts.class})
public class SoftAssertDemoTest {
    static Logger logger = getLogger(SoftAssertDemoTest.class);
    @BeforeMethod(alwaysRun=true)
    public void setUp() {
        Configuration.assertionMode = SOFT;
    }
    @Test
    public void test1() {
        open("https://www.google.com");
        logger.info("opening url...");
        $("div.text").should(visible).click();
        $("div#u").should(visible).click();
    }

}
