package tree;

/**
 * Created by stephen on 18-8-9.
 *
 * huffman树，利用最小堆构造
 */
public class HuffmanTree {

    /**
     * huffman树的节点
     */
    static class HuffmanNode implements Comparable<HuffmanNode> {
        String label;
        int weight; //权值

        HuffmanNode left;
        HuffmanNode right;
        HuffmanNode parent;

        public HuffmanNode(int w) {
            this.weight = w;
        }

        public HuffmanNode(int w, HuffmanNode left, HuffmanNode right, HuffmanNode p) {
            this.weight = w;
            this.left = left;
            this.right = right;
            this.parent = p;
        }

        public HuffmanNode(String label, int w, HuffmanNode left, HuffmanNode right, HuffmanNode p) {
            this.label = label;
            this.weight = w;
            this.left = left;
            this.right = right;
            this.parent = p;
        }

        @Override
        public int compareTo(HuffmanNode huffmanNode) {
            return this.weight > huffmanNode.weight ? 1 : -1;
        }

    }

    private HuffmanNode head;

    public HuffmanTree(HuffmanNode[] nodes) {
        buildHuffmanTree(nodes);
    }

    public HuffmanTree(Integer[] weights) {
        HuffmanNode[] nodes = new HuffmanNode[weights.length];
        for (int i = 0; i < weights.length; i++){
            HuffmanNode huffmanNode = new HuffmanNode(weights[i]);
            nodes[i] = huffmanNode;
        }
        buildHuffmanTree(nodes);
    }

    public void buildHuffmanTree(HuffmanNode[] nodes){
        HuffmanNode parent = null;
        //构建最小堆
        MinHeap<HuffmanNode> minHeap = new MinHeap<>(nodes);
        //构建huffman树
        while (minHeap.getTop() != null) {
            HuffmanNode left = minHeap.dequeueTop();
            HuffmanNode right = minHeap.dequeueTop();
            parent = new HuffmanNode(left.weight + right.weight, left, right, null);//父节点不需要label
            left.parent = parent;
            right.parent = parent;
            minHeap.add(parent);
        }
        head = parent;
    }

    public HuffmanNode getHead() {
        return head;
    }
}
