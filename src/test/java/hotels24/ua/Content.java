package hotels24.ua;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import performance.test.TestNgTestBase;

public class Content extends TestNgTestBase
{

    public static String Title = "Отдых в Карпатах 2015 - Отели, цены, фото, отзывы на Hotels24.ua";
    private String height;
    private String width;

    @Test
    public void testContent()
    {
        driver.manage().deleteAllCookies();
        driver.get(baseUrl + "/Отдых-в-Карпатах/");
        assertEquals(Title, driver.getTitle());
        //Проверка чек-бокса "до 150 грн (29 отелей)" 
        assertEquals(null, driver.findElement(By.id("priceRange_a")).getAttribute("checked"));
        driver.findElement(By.id("priceRange_a")).click();
        assertEquals("true", driver.findElement(By.id("priceRange_a")).getAttribute("checked"));
        driver.findElement(By.id("priceRange_a")).click();
        /// тест одной из гостиниц
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("serch-res-hotel-name"), "Частная усадьба Гук"));
        assertEquals("Частная усадьба Гук", driver.findElement(By.id("serch-res-hotel-name")).getText());
        assertTrue(isElementPresent(By.cssSelector("#booking-btn > span")));
        assertEquals("от 500 грн", driver.findElement(By.id("booking-btn")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='paginatorElement_4346']/div/div[2]/div[2]")));
        assertTrue(isElementPresent(By.cssSelector("p.hotel-description-trim")));
        assertEquals("Размещение с животными", driver.findElement(By.xpath("//div[@id='paginatorElement_4346']/div/div[2]/div[3]/span[4]")).getText());
        ///Фото
        driver.findElement(By.id("hotel_img_4346")).click();
        height = driver.findElement(By.id("hotel_img_4346")).getCssValue("height");
        width = driver.findElement(By.id("hotel_img_4346")).getCssValue("width");
        System.out.printf("height = %s ***** width = %s\n", height, width);
        if ("120px".equals(height) && "160px".equals(width))
        {
            System.out.println("=>> success size picture");
        } else
        {
            System.out.println("=>> fail size picture");
            driver.close();
        }
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9229/922910/922910md.jpg')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9229/922915/922915md.jpg')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9226/922687/922687md.jpg')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9229/922913/922913md.jpg')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9229/922912/922912md.jpg')]")).click();
        driver.findElement(By.xpath("//img[contains(@src,'http://img.hotels24.ua/photos/partner_hotel/facility/92/9229/922914/922914md.jpg')]")).click();
        driver.findElement(By.cssSelector("a.close-butt.closeSlideshow")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paginator-btn")));
        ((JavascriptExecutor) driver).executeScript("scrollTo(0,5000)");
        assertTrue(isElementPresent(By.id("paginator-btn")));
    }

}
