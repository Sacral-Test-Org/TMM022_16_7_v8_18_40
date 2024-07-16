package com.project.tmm022_fmb.modules.hpms;

import com.project.tmm022_fmb.modules.hpms.PartMasterController;
import com.project.tmm022_fmb.modules.hpms.PartMasterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PartMasterControllerTest {

    @Mock
    private PartMasterService partMasterService;

    @InjectMocks
    private PartMasterController partMasterController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPartMasterWindow() {
        // Arrange
        String expectedResponse = "PART_MASTER_WINDOW";
        when(partMasterService.getPartMasterWindow()).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> response = partMasterController.getPartMasterWindow();

        // Assert
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testGetSystemDate() {
        // Arrange
        String expectedDate = "01-OCT-2023";
        when(partMasterService.getSystemDate()).thenReturn(expectedDate);

        // Act
        ResponseEntity<String> response = partMasterController.getSystemDate();

        // Assert
        assertEquals(expectedDate, response.getBody());
    }

    @Test
    public void testClearForm() {
        // Act
        partMasterController.clearForm();

        // Assert
        verify(partMasterService).clearForm();
    }

    @Test
    public void testEditPart() {
        // Arrange
        String partId = "123";
        String expectedResponse = "EDIT_SUCCESS";
        when(partMasterService.editPart(partId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> response = partMasterController.editPart(partId);

        // Assert
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testExitForm() {
        // Act
        partMasterController.exitForm();

        // Assert
        verify(partMasterService).exitForm();
    }
}
