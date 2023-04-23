package vintage.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    /**
     * Tests the User constructor.
     */
    @Test
    public void userTest() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@mail.com");
        user.setResidence(new Residence("Portugal", "Braga", "Rua dos Bares", "4710-000"));
        user.setTaxNumber("123456789");

        assertEquals("John Doe", user.getName());
        assertEquals("johndoe@mail.com", user.getEmail());
        assertEquals(new Residence("Portugal", "Braga", "Rua dos Bares", "4710-000"), user.getResidence());
        assertEquals("123456789", user.getTaxNumber());
    }
}
