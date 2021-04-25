import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebForm extends PageObject{

    private final String Name = "deneme";
    private final String LastName = "deneme2";
    private final String Mail = "qtwayysuaysuyu@hotmail.com";
    private final String HataliMail = "qtwayysuaysuyuhotmail.com";
    private final String Password = "Qwerty12345";

    WebDriverWait wait = new WebDriverWait(driver,30);

    @FindBy(xpath = "//a[contains(text(),'ÜYE OL')]")
    private WebElement uyeol;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "lastName")
    private WebElement lastname;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "form[id='register-form'] div[class='col-12'] a[class='serviceContractPopup']")
    private WebElement servicepopup;

    @FindBy(xpath = "//a[@id='btnModalYesCallback']")
    private WebElement popupaccept;

    @FindBy(css = "form[id='register-form'] div[class='col-12'] a[class='explicitConsentContractPopup']")
    private WebElement contractpopup;

    @FindBy(id = "recaptcha-anchor")
    private WebElement recaptcha;

    @FindBy(xpath = "//button[contains(text(),'ÜYELİĞİNİ OLUŞTUR')]")
    private WebElement submit_button;

    @FindBy(xpath = "//p[@id='email-error']")
    private WebElement emailerror;

    @FindBy(xpath = "//p[@id='lastName-error']")
    private WebElement lastnameerror;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void uyeOl(){
        this.uyeol.click();
    }

    public void isimGirisi(){
        this.name.sendKeys(Name);
    }

    public void soyisimGirisi(){
        this.lastname.sendKeys(LastName);
    }

    public void mailGirisi(){
        this.email.sendKeys(Mail);
    }

    public void hatalimailGirisi(){
        this.email.sendKeys(HataliMail);
    }

    public void sifreGirisi(){
        this.password.sendKeys(Password);
    }

    public void hizmetPopup(){
        this.servicepopup.click();
    }

    public void acikrizametinPopup(){
        this.contractpopup.click();
    }

    public void kontratPopup(){
        this.popupaccept.click();
    }

    public void recaptcha(){
        this.recaptcha.click();
    }

    public void pressSubmitButton(){
        this.submit_button.click();
    }

    public void bekle() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnModalYesCallback")));
    }

    public String renkAl(){
        String color = driver.findElement(By.xpath("//span[contains(text(),'Hizmet sözleşmesini')]")).getCssValue("color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }

    public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    public String hataliMailText(){
        String hatalimailtext = this.emailerror.getText();
        return hatalimailtext;
    }

    public String hataliSoyisimText(){
        String hatalisoyisimtext = this.lastnameerror.getText();
        return hatalisoyisimtext;
    }
}