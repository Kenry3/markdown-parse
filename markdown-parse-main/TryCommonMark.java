import java.util.ArrayList;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

class TryCommonMark {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        Node node = parser.parse("[another link!](some-page.html)");
        //WordCountVisitor visitor = new WordCountVisitor();
        LinkVistor visitor = new LinkVistor();
        node.accept(visitor);
        //System.out.println(visitor.getWordCount());
        System.out.println(visitor.getLinkCount());
    }
}
class WordCountVisitor extends AbstractVisitor {
    int wordCount = 0;

    @Override
    public void visit(Text text) {
        // This is called for all Text nodes. Override other visit methods for other node types.

        // Count words (this is just an example, don't actually do it this way for various reasons).
        wordCount += text.getLiteral().split("\\W+").length;

        // Descend into children (could be omitted in this case because Text nodes don't have children).
        visitChildren(text);
    }

    public int getWordCount() {
        return wordCount;
    }
}
class LinkVistor extends AbstractVisitor {
    int linkCount = 0;
    ArrayList<String> linksList = new ArrayList<>();
    @Override
    public void visit(Link link) {
        linksList.add(link.getDestination());
        visitChildren(link);
    }

    public ArrayList<String> getLinkCount() {
        return linksList;
    }
}