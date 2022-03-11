import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    /**@Test
    public void testGetLink() throws IOException {
        Path fileName = Path.of("/Users/kenry/Documents/GitHub/markdown-parse/Snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    }*/

    @Test
    public void testGetLink() throws IOException {
        Path fileName = Path.of("/Users/kenry/Documents/GitHub/markdown-parse/Snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(contents);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }

    @Test
    public void testS1() throws IOException {
        Path fileName = Path.of("/Users/kenry/Documents/GitHub/markdown-parse/Snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void testS2() throws IOException {
        Path fileName = Path.of("/Users/kenry/Documents/GitHub/markdown-parse/Snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "a.com(())", "example.com"), links);
    }

    @Test
    public void testS3() throws IOException {
        Path fileName = Path.of("/Users/kenry/Documents/GitHub/markdown-parse/Snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/",
        "https://cse.ucsd.edu/"), links);
    }
}