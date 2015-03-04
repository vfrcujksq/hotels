package hotels24.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import performance.test.TestNgTestBase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static hotels24.ua.Content.Title;

public class Header extends TestNgTestBase 
{

//    String Title = "Отдых в Карпатах 2015 - Отели, цены, фото, отзывы на Hotels24.ua";
    private final String ks = "067 510-15-04";
    private final String life = "093 170-01-46";
    private final String mts = "050 337-26-32";
    private final String ukrtelecom = "0 44 364-2000";
    private final String general = "0 800 210-017";

    @Test
    public void testHeader() throws InterruptedException 
    {
        driver.get(baseUrl + "/Отдых-в-Карпатах/");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Гостиницы мира")));
        assertEquals(Title, driver.getTitle());
        assertEquals("Українці знають правду про українські готелі!", driver.findElement(By.cssSelector("h6.hotel-slogan")).getText());
        assertEquals("Гостиницы мира", driver.findElement(By.linkText("Гостиницы мира")).getText());
        assertEquals("Гостиницы Украины", driver.findElement(By.cssSelector("span.underline")).getText());
        assertEquals("О нас", driver.findElement(By.linkText("О нас")).getText());
        assertEquals("Помощь", driver.findElement(By.linkText("Помощь")).getText());
        assertEquals("Для юр. лиц", driver.findElement(By.linkText("Для юр. лиц")).getText());
        assertEquals("Гостиницы", driver.findElement(By.cssSelector("span.brcrumbs-link-left")).getText());
        assertTrue(isElementPresent(By.cssSelector("a.fast_book_button > span")));
        assertEquals("Перезвоните мне", driver.findElement(By.cssSelector("a.fast_book_button > span")).getText());
        assertEquals("Hotels24ua", driver.findElement(By.xpath("//body[@id='body']/div[9]/div/div[2]/div[4]/div/ul/li[2]/a/span")).getText());
        driver.findElement(By.id("ks")).click();
        assertEquals(ks, driver.findElement(By.cssSelector("span.tel-num.current-operator")).getText());
        driver.findElement(By.id("life")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("span.tel-num.current-operator"), life));
        assertEquals(life, driver.findElement(By.cssSelector("span.tel-num.current-operator")).getText());
        driver.findElement(By.id("mts")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("span.tel-num.current-operator"), mts));
        assertEquals(mts, driver.findElement(By.cssSelector("span.tel-num.current-operator")).getText());
        driver.findElement(By.id("ukrtelecom")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("span.tel-num.current-operator"), ukrtelecom));
        assertEquals(ukrtelecom, driver.findElement(By.cssSelector("span.tel-num.current-operator")).getText());
        assertEquals(general, driver.findElement(By.xpath("//body[@id='body']/div[9]/div/div[2]/div[4]/div/div[2]/div[2]/span[2]")).getText());
    }
}
