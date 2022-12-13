package com.shiva.webservices.restfulwebservices.buisiness;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTest {

    @Mock
    private DataService dataServiceMock = mock(DataService.class);

    @InjectMocks
    private SomeBusinessImpl businessImpl;


    // First mock-test
    @Test
    @DisplayName("first mock test")
    void mockTest() {

        // DataService dataServiceMock = mock(DataService.class);
        // SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

        when(dataServiceMock.retrieveData()).thenReturn(new int[]{25, 15, 5, 20, -100, 0, 3});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());

        when(dataServiceMock.retrieveData()).thenReturn(new int[]{2500, 15, 5, 20, -100, 0, 3});
        assertEquals(2500, businessImpl.findTheGreatestFromAllData());

    }


    @Mock
    private List arr = mock(List.class);

    @Test
    @DisplayName("List mock test")
    void mockTest2() {

        int size = 3;
        when(arr.size()).thenReturn(size).thenReturn(size + 1);
        assertEquals(size, arr.size());
        assertEquals(size + 1, arr.size());
        assertEquals(size + 1, arr.size());
        assertEquals(size + 1, arr.size());
    }
}
