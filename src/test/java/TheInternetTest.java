import org.junit.Test;
import testconfigs.BaseTest;
import testdata.AccountData;

import static pages.TheInternet.*;
import static testdata.AccountData.username;

public class TheInternetTest extends BaseTest {

    @Test
    public void loginAndLogoutTest() {
        visit();
        login(username, AccountData.password);

        assertMessage("You logged into a secure area!");
        logout();

        assertMessage("You logged out of the secure area!");
    }

    @Test
    public void incorrectPasswordTest() {
        visit();
        login(username, AccountData.incorrectPassword);

        assertMessage("Your password is invalid!");
    }

    @Test
    public void incorrectUsernameTest() {
        visit();
        login(AccountData.incorrectUsername, AccountData.password);

        assertMessage("Your username is invalid!");
    }

    @Test
    public void incorrectUsernameAndPasswordTest() {
        visit();
        login(AccountData.incorrectUsername, AccountData.incorrectPassword);

        assertMessage("Your username is invalid!");
    }

}

