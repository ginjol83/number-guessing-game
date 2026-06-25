package models;
import org.example.models.AttemptModel;
import org.example.repositories.MainMenuRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AttemptModelTest {

    @Test
    void guestResponseTest () {
        MainMenuRepository mainMenuRepository = new MainMenuRepository();
        AttemptModel       attemptModel       = new AttemptModel();

        // The number is greater than
        assertEquals(mainMenuRepository.theNumberisGreaterThanString(50) ,attemptModel.guestResponse(50,60,5) );
        // The number is less than
        assertEquals(mainMenuRepository.theNumberisLessThanString(50) ,attemptModel.guestResponse(50,40,5) );
        // The number is equal than
        assertEquals(mainMenuRepository.congratString(5) ,attemptModel.guestResponse(50,50,5) );
    }
}