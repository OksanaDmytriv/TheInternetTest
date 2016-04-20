import org.junit.Test;
import pages.TheInternet;
import testconfigs.BaseTest;
import testdata.AccountData;

import static pages.TheInternet.assertErrorShown;
import static pages.TheInternet.assertOpenedURL;
import static pages.TheInternet.logout;
import static testdata.AccountData.username;

public class TheInternetTest extends BaseTest {

    @Test
    public void loginAndLogoutTest() {
        TheInternet.visit();
        TheInternet.login(username, AccountData.password);

        assertOpenedURL("The Internet");
        logout();
    }

    @Test
    public void incorrectPasswordTest() {
        TheInternet.visit();
        TheInternet.login(username, AccountData.incorrectPassword);

        assertErrorShown("Your password is invalid!");
    }

    @Test
    public void incorrectUsernameTest() {
        TheInternet.visit();
        TheInternet.login(AccountData.incorrectUsername, AccountData.password);

        assertErrorShown("Your username is invalid!");
    }

    @Test
    public void incorrectUsernameAndPasswordTest() {
        TheInternet.visit();
        TheInternet.login(AccountData.incorrectUsername, AccountData.incorrectPassword);

        assertErrorShown("Your username is invalid!");
    }

}

