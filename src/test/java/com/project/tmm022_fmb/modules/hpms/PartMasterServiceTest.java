package com.project.tmm022_fmb.modules.hpms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PartMasterServiceTest {

    @Mock
    private PartMasterRepository partMasterRepository;

    @InjectMocks
    private PartMasterService partMasterService;

    @BeforeEach
    public void setUp() {
        // Initialize any required setup here
    }

    @Test
    public void testGetPartMasterDetails() {
        // Given
        PartMaster expectedPartMaster = new PartMaster();
        expectedPartMaster.setPartId("P123");
        expectedPartMaster.setPartDesc("Test Part");

        when(partMasterRepository.findById("P123")).thenReturn(Optional.of(expectedPartMaster));

        // When
        PartMaster actualPartMaster = partMasterService.getPartMasterDetails("P123");

        // Then
        assertEquals(expectedPartMaster, actualPartMaster);
        verify(partMasterRepository).findById("P123");
    }

    @Test
    public void testGetSystemDate() {
        // Given
        String expectedDate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());

        // When
        String actualDate = partMasterService.getSystemDate();

        // Then
        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testClearForm() {
        // When
        partMasterService.clearForm();

        // Then
        // Add assertions to verify the form is cleared, 'UNIT_ID' is enabled, 'PART_STATUS' is set to 'A'
        // and the 'WHEN-NEW-FORM-INSTANCE' trigger is executed.
        // This might involve checking the state of the form or calling certain methods.
    }

    @Test
    public void testEditPart() {
        // Given
        PartMaster partMaster = new PartMaster();
        partMaster.setPartId("P123");
        partMaster.setPartDesc("Updated Part");

        // When
        partMasterService.editPart(partMaster);

        // Then
        // Add assertions to verify the part is edited correctly.
        // This might involve checking the state of the part or calling certain methods.
    }

    @Test
    public void testExitForm() {
        // When
        partMasterService.exitForm();

        // Then
        // Add assertions to verify the form is closed successfully.
        // This might involve checking the state of the form or calling certain methods.
    }
}
