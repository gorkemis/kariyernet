import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Success Login")
    public static void basariliKayit(){
        driver.get(Utils.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebForm webForm = new WebForm(driver);
        webForm.uyeOl();
        webForm.isimGirisi();
        webForm.soyisimGirisi();
        webForm.mailGirisi();
        webForm.sifreGirisi();
        webForm.hizmetPopup();
        webForm.bekle();
        webForm.kontratPopup();
        webForm.acikrizametinPopup();
        webForm.bekle();
        webForm.kontratPopup();
        //webForm.recaptcha();
        webForm.scroll();
        webForm.pressSubmitButton();
        webForm.bekle();
        webForm.kontratPopup();
    }

    @Test(testName = "Hizmet sözlesmesi kabul etmeden üye olma")
    public static void basarisizKayit1(){
        driver.get(Utils.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebForm webForm = new WebForm(driver);
        webForm.uyeOl();
        webForm.isimGirisi();
        webForm.soyisimGirisi();
        webForm.mailGirisi();
        webForm.sifreGirisi();
        webForm.acikrizametinPopup();
        webForm.bekle();
        webForm.kontratPopup();
        webForm.bekle();
        //webForm.recaptcha();
        webForm.scroll();
        webForm.pressSubmitButton();
        Assert.assertTrue(webForm.renkAl().equals("#ff0000"));
    }

    @Test(testName = "Hatali mail adresi ile üye olma")
    public static void basarisizKayit2(){
        driver.get(Utils.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebForm webForm = new WebForm(driver);
        webForm.uyeOl();
        webForm.isimGirisi();
        webForm.soyisimGirisi();
        webForm.hatalimailGirisi();
        webForm.sifreGirisi();
        webForm.hizmetPopup();
        webForm.bekle();
        webForm.kontratPopup();
        webForm.acikrizametinPopup();
        webForm.bekle();
        webForm.kontratPopup();
        //webForm.recaptcha();
        webForm.scroll();
        webForm.pressSubmitButton();
        Assert.assertTrue(webForm.hataliMailText().equals("Uygun E-posta adresi giriniz."));
    }

    @Test(testName = "Soyisimsiz şekilde üye olma")
    public static void basarisizKayit3(){
        driver.get(Utils.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebForm webForm = new WebForm(driver);
        webForm.uyeOl();
        webForm.isimGirisi();
        //webForm.soyisimGirisi();
        webForm.mailGirisi();
        webForm.sifreGirisi();
        webForm.hizmetPopup();
        webForm.bekle();
        webForm.kontratPopup();
        webForm.acikrizametinPopup();
        webForm.bekle();
        webForm.kontratPopup();
        //webForm.recaptcha();
        webForm.scroll();
        webForm.pressSubmitButton();
        Assert.assertTrue(webForm.hataliSoyisimText().equals("Soyadını yazmalısın."));
    }
    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}