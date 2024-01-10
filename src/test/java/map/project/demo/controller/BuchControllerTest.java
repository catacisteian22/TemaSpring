package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.repository.BuchRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
class BuchControllerTest {

    @Mock
    private BuchRepo buchRepo;

    @InjectMocks
    private BuchController buchController;

    @BeforeEach
    void setUp() {
        buchRepo.save(new Buch(1L, "Titel", "Author", "genre", 298, 2023, 33.8f));
        buchRepo.save(new Buch(2L, "Titel", "Author", "genre", 298, 2023, 33.8f));
        buchRepo.save(new Buch(3L, "Titel", "Author", "genre", 298, 2023, 33.8f));
        buchRepo.save(new Buch(4L, "Titel", "Author", "genre", 298, 2023, 33.8f));
    }

    @Test
    void testDeleteBuchRequest() {
        Long idToDelete = 1L;

        ResponseEntity<String> responseEntity = buchController.deleteBuchRequest(idToDelete);

        verify(buchRepo, times(1)).deleteById(idToDelete);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Operation succeeded!", responseEntity.getBody());
    }

    @Test
    void testGetBuchById() {
        Long idToFind = 4L;
        Buch expectedBuch = new Buch();
        when(buchRepo.findById(idToFind)).thenReturn(Optional.of(expectedBuch));

        ResponseEntity<Buch> responseEntity = buchController.getBuchById(idToFind);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBuch, responseEntity.getBody());
    }

    @Test
    void testGetAll() {
        List<Buch> expectedBuchs = Arrays.asList(new Buch(), new Buch());
        when(buchRepo.findAll()).thenReturn(expectedBuchs);

        ResponseEntity<List<Buch>> responseEntity = buchController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBuchs, responseEntity.getBody());
    }
}
