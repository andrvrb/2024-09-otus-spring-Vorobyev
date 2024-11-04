package ru.otus.hw.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class StreamsIOServiceTest {

    @InjectMocks
    private StreamsIOService streamsIOService;

    @Mock
    private PrintStream printStream;

    @Test
    void printLine() {
        String testStr = "Test string";
        streamsIOService.printLine(testStr);

        verify(printStream).println(testStr);
        verifyNoMoreInteractions(printStream);
    }

    @Test
    void printFormattedLine() {
        String testStr = "Test string";
        String result = testStr.concat("%n");
        streamsIOService.printFormattedLine(testStr);

        verify(printStream).printf(result);
    }
}