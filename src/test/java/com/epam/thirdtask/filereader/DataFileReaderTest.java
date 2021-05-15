package com.epam.thirdtask.filereader;

import com.epam.thirdtask.exception.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataFileReaderTest {
    private final static String PATH_TO_FILE = "src/test/resources/data/triangleData.txt";
    private final static String WRONG_PATH_TO_FILE = "src/test/resourcfffes/data/triangleData.txt";
    private static DataFileReader dataFileReader;

    @BeforeEach
    void setUp() throws TriangleException {
        dataFileReader = new DataFileReader();
        int actualLinesSize = dataFileReader.readAllDataFromFile(PATH_TO_FILE).size();
        int expectedLinesSize = 1;
        Assertions.assertEquals(expectedLinesSize, actualLinesSize);
    }

    @Test()
    void testReadDataWhenFileNotFound() {
        Assertions.assertThrows(TriangleException.class, () ->
            dataFileReader.readAllDataFromFile(WRONG_PATH_TO_FILE));
    }
}