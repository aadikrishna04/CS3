import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class HuffmanTree {
    PriorityQueue<Node> chars;

    public HuffmanTree(int[] counts) {
        if (counts.length != 256) {
            throw new IllegalArgumentException("counts's length is not 256");
        }

        chars = new PriorityQueue<>();
        for (int i = 0; i < 256; i++) {
            chars.add(new Node(counts[i], null, null));
        }
    }

    public void write(String fileName) {
        BitOutputStream out = new BitOutputStream(fileName);
        encode(out, fileName);
    }

    public void decode(BitInputStream in, String outFile) {
        try {
            PrintWriter pw = new PrintWriter(outFile);
            in.readBit()
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void encode(BitOutputStream out, String filename) {

    }
}
