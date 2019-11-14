import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lvtt
 * @date Created in 2019/11/13 22:43
 * @description 拉钩爬虫类
 * @version 1.0
 */
public class LagouSearcher {
    public static void main(String[] args) {
        //设置 webdriver 路径
        System.setProperty("webdriver.chrome.driver",
                LagouSearcher.class.getClassLoader().getResource
                        ("chromedriver.exe").getPath());
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.lagou.com/zhaopin/Java/?labelWords=label");
        clickOption(webDriver, "工作经验", "应届毕业生");
        clickOption(webDriver, "学历要求", "本科");
        clickOption(webDriver, "融资阶段", "天使轮");
        clickOption(webDriver, "公司规模", "15-50人");
        clickOption(webDriver, "行业领域", "移动互联网");
    }

    private static void clickOption(WebDriver webDriver, String optionName, String optionParam) {
        WebElement chromeElement = webDriver.findElement(By.xpath
                ("//li[@class='multi-chosen']//span[contains(text(), '" + optionName + "')" +
                        "]"));
        WebElement optionElement = chromeElement.findElement(By.xpath
                ("../a[contains(text(), '" + optionParam + "')" +
                        "]"));

        optionElement.click();
    }
}
