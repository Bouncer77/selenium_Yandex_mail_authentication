import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора меню пользователя
     */
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[1]")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[2]/div")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    //@FindBy(xpath = "//*[contains(@class, 'menu-item_action_exit menu__item menu__item_type_link')]")
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/ul/ul/li[6]")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[1]/div[2]/div")
    private WebElement logoutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        String userName = userMenu.getText();
        return userName; }
    /*в метод getUserName() пришлось добавить еще одно ожидание,
     т.к. страница «тяжелая» и загружалась довольно медленно. В итоге тест падал, потому что метод не мог получить
      имя пользователя. Метод getUserName() с ожиданием*/
    /*public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'account__name_hasAccentLetter')]")));
        String userName = userMenu.getText();
        return userName;
    }*/
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click();
    }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        // logoutBtn.click();
        driver.findElement(By.linkText("Подписки")).click();
    }
}