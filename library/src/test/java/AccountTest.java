import com.thoughtworks.step.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws Exception {
        account = new Account("dhanu", "123", 800);
    }

    @Test
    public void checkBalance() {
        assertEquals(800,account.getBalance(),0);
    }


    @Test
    public void checkAccNumber() {
        assertThat(account.getAccNumber(),is("123"));
    }
}
