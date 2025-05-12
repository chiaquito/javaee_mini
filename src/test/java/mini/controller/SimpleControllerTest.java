package mini.controller;


import java.util.Collections;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;



import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import mini.usecase.SimpleUsecase;

@ExtendWith(MockitoExtension.class)
class SimpleControllerTest {

    @InjectMocks
    SimpleController controller;

    @Mock
    SimpleUsecase mockUsecase;

    @Nested
    class Success {
        @Test
        void test正常レスポンスが返る() {
            Mockito.when(mockUsecase.get()).thenReturn(Collections.emptyList());

            Response response = controller.get();

            assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
            assertEquals(Collections.emptyList(), response.getEntity());
        }
    }

    @Nested
    class Failure {
        @Test
        void testRuntimeException発生時に400が返る() {
            Mockito.when(mockUsecase.get()).thenThrow(new RuntimeException("失敗"));

            Response response = controller.get();

            assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
            assertTrue(response.getEntity() instanceof RuntimeException);
        }
    }
}