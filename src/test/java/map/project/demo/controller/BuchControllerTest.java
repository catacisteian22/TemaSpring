package map.project.demo.controller;

import map.project.demo.model.Buch;
import map.project.demo.repository.BuchRepo;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
class BuchControllerTest {

    @Mock
    private BuchRepo buchRepo;

    @InjectMocks
    private BuchController buchController;

    @Test
    void testDeleteBuchRequest() {
        Long idToDelete = 1L;
        when(buchRepo.findById(idToDelete)).thenReturn(Optional.of(new Buch()));

        ResponseEntity<String> responseEntity = buchController.deleteBuchRequest(idToDelete);

        verify(buchRepo, times(1)).deleteById(idToDelete);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("operation succeeded!", responseEntity.getBody());
    }

    @Test
    void testDeleteBuchRequestNotFound() {
        Long idToDelete = 1L;
        when(buchRepo.findById(idToDelete)).thenReturn(Optional.empty());

        ResponseEntity<String> responseEntity = buchController.deleteBuchRequest(idToDelete);

        verify(buchRepo, never()).deleteById(any());
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(" id not found", responseEntity.getBody());
    }

    @Test
    void testGetBuchById() {
        Long idToFind = 1L;
        Buch expectedBuch = new Buch();
        when(buchRepo.findById(idToFind)).thenReturn(Optional.of(expectedBuch));

        ResponseEntity<Buch> responseEntity = buchController.getBuchById(idToFind);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBuch, responseEntity.getBody());
    }

    @Test
    void testGetBuchByIdNotFound() {
        Long idToFind = 1L;
        when(buchRepo.findById(idToFind)).thenReturn(Optional.empty());

        ResponseEntity<Buch> responseEntity = buchController.getBuchById(idToFind);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
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
