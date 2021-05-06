import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[1]")
    private WebElement userMenu;

    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/div/div/div/div[7]/div[2]/div[1]/div[2]")
    private WebElement openMenuForLogout;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[1]/div/div/div/div[7]/div[2]/div[2]/div[3]/div/div[1]/a")
    private WebElement logoutBtn;


    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        return userMenu.getText();
    }

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
        openMenuForLogout.click();
        System.out.println("Element is visible? " + logoutBtn.isDisplayed());
        if (logoutBtn.isDisplayed())
            logoutBtn.click();
    }
}