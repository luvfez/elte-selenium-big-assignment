package skiline_test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.*;

public class TestSuite {

    private WebDriver driver;
    private StaticPage staticPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private ProfileEditPage profileEditPage;

    public void waitMs(int msToWait) {
        try {
            Thread.sleep(msToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pageLogin() {
        // Sign in
        driver.get("https://www.skiline.cc/home");
        loginPage.login("grouppyxtv@gmail.com", "SeleniumAssignmentLuvfez");
        assertEquals("LUVFEZ Tester", loginPage.getUsername());
        waitMs(2000);
    }

    public String generateRandomString(int stringLength) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < stringLength; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            stringBuilder.append(alphabet.charAt(randomIndex));
        }

        return stringBuilder.toString();
    }

    @Before
    public void setup() {
        try {
            ChromeOptions options = new ChromeOptions();
            this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
            this.driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        profileEditPage = new ProfileEditPage(driver);
        staticPage = new StaticPage(driver);
    }

    @Test
    public void testStaticPagesFromArray() {
        String[] staticPageAddresses = { "https://www.skiline.cc/resort/nassfeld",
                "https://www.skiline.cc/resort/gerlitzen", "https://www.skiline.cc/resort/lachtal" };
        String[] expectedPageTitles = { "Skiline - General info about ski resort Nassfeld-Pressegger See",
                "Skiline - General info about ski resort Gerlitzen",
                "Skiline - General info about ski resort Lachtal" };
        for (int i = 0; i < staticPageAddresses.length; i++) {
            driver.get(staticPageAddresses[i]);
            assertEquals(expectedPageTitles[i], staticPage.getPageTitle());
            waitMs(2000);
        }
    }

    @Test
    public void testClickOnRegister() {
        driver.get("https://www.skiline.cc/home");
        loginPage.waitForAndClickOnRegister();
        waitMs(2000);
    }

    @Test
    public void testLoginAndLogout() {
        pageLogin();

        // Logout
        loginPage.logout();

        // Verify logout
        loginPage.isUsernameFieldPresent();
        waitMs(2000);
    }

    @Test
    public void testLoginAndUserProfileEditing() {
        pageLogin();

        // Edit profile
        driver.get("https://www.skiline.cc/myprofile/edit_personal");
        waitMs(2000);
        Random random = new Random();
        String newUsername = "luvfezt" + String.valueOf(random.nextInt(100) + 1);
        String newAboutMe = generateRandomString(20);
        profileEditPage.changeUsername(newUsername);
        profileEditPage.changeAboutMe(newAboutMe);
        waitMs(2000);
        profileEditPage.saveProfile();
        waitMs(2000);

        // Validate new profile data
        assertEquals("LUVFEZ Tester (" + newUsername + ")", profilePage.getName());
        assertEquals(newAboutMe, profilePage.getAboutMe());
        waitMs(2000);
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

}
