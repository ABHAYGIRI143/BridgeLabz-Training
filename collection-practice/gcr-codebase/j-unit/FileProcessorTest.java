import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileProcessorTest {

    private FileProcessor fileProcessor;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        fileProcessor = new FileProcessor();
        tempFile = Files.createTempFile("\\sample", ".txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    // ✅ Test: content is written and read correctly
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Testing";

        fileProcessor.writeToFile(tempFile.toString(), content);
        String result = fileProcessor.readFromFile(tempFile.toString());

        assertEquals(content, result);
    }

    // ✅ Test: file exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(tempFile.toString(), "Test Data");

        assertTrue(Files.exists(tempFile));
    }

    // ✅ Test: IOException when file does not exist
    @Test
    void testReadFileThatDoesNotExist() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("non_existing_file.txt");
        });
    }
}
