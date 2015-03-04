package hotels24.ua;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import performance.test.TestNgTestBase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static hotels24.ua.Content.Title;

public class Footer extends TestNgTestBase
{

    @Test
    public void testFooter()
    {
        driver.get(baseUrl + "/Отдых-в-Карпатах/");
        assertEquals(Title, driver.getTitle());
        ((JavascriptExecutor) driver).executeScript("scrollTo(0,5000)");
        assertTrue(isElementPresent(By.linkText("Для гостиниц")));
        assertEquals("Для гостиниц", driver.findElement(By.linkText("Для гостиниц")).getText());
        assertTrue(isElementPresent(By.linkText("Для юридических лиц")));
        assertEquals("Для юридических лиц", driver.findElement(By.linkText("Для юридических лиц")).getText());
        assertTrue(isElementPresent(By.linkText("О компании")));
        assertEquals("О компании", driver.findElement(By.linkText("О компании")).getText());
        assertTrue(isElementPresent(By.linkText("Публичная оферта")));
        assertEquals("Публичная оферта", driver.findElement(By.linkText("Публичная оферта")).getText());
        assertTrue(isElementPresent(By.linkText("Конфиденциальность")));
        assertEquals("Конфиденциальность", driver.findElement(By.linkText("Конфиденциальность")).getText());
        assertTrue(isElementPresent(By.cssSelector("img.padT15.padB5")));
        String inf = driver.findElement(By.cssSelector("div.footerblock1")).getText();
        if (!inf.isEmpty())   driver.quit(); System.out.println("==>> text in variable is empty");
        assertEquals("Бронируем круглосуточно", driver.findElement(By.cssSelector("div.footerblock1.padT15")).getText());
        assertEquals("0 800 210-017", driver.findElement(By.xpath("//div[@id='id-layout-footer']/div[2]/div/div[2]/div[2]")).getText());
        assertEquals("Мы в социальных сетях:", driver.findElement(By.xpath("//div[@id='id-layout-footer']/div[2]/div/div[2]/div[3]")).getText());
        assertTrue(isElementPresent(By.cssSelector("div.padT5 > a > img")));
        assertTrue(isElementPresent(By.cssSelector("img.padL5")));
        assertTrue(isElementPresent(By.xpath("//div[@id='id-layout-footer']/div[2]/div/div[2]/div[4]/a[3]/img")));
        assertTrue(isElementPresent(By.xpath("//div[@id='id-layout-footer']/div[2]/div/div[2]/div[4]/a[4]/img")));
        assertEquals("Гарантия", driver.findElement(By.cssSelector("div.sprite-ico-footer.footer_garant1 > span")).getText());
        assertTrue(isElementPresent(By.cssSelector("i.ico-footer1.floatL")));
        assertEquals("Hotels24.ua - партнер Ассоциации отелей и апартаментов Украины", driver.findElement(By.cssSelector("div.sprite-ico-footer.footer_garant2")).getText());
        assertTrue(isElementPresent(By.cssSelector("i.ico-footer2.floatL")));
        assertEquals("Гостиницы Украины", driver.findElement(By.cssSelector("li.footer_h")).getText());
        assertTrue(isElementPresent(By.linkText("Гостиницы Луцка")));
        assertTrue(isElementPresent(By.linkText("Гостиницы Запорожья")));
        assertTrue(isElementPresent(By.linkText("Гостиницы Винницы")));
        assertTrue(isElementPresent(By.linkText("Гостиницы Харькова")));
        assertTrue(isElementPresent(By.linkText("Гостиницы Одессы")));
        assertTrue(isElementPresent(By.linkText("Квартиры посуточно Киев")));
        assertTrue(isElementPresent(By.linkText("Все гостиницы Украины")));
    }
}
