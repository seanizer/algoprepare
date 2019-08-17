package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

abstract class AbstractBstNode<T extends Comparable<? super T>, N extends AbstractBstNode<T, N>> extends AbstractBinaryTreeNode<T, N> {


    protected AbstractBstNode(T value) {
        super(value);
    }

    public void addValue(T value) {
        int result = value.compareTo(this.getValue());
        if (result < 0) {
            if (left == null) left = newNode(value);
            else left.addValue(value);
        } else if (result > 0) {
            if (right == null) right = newNode(value);
            else right.addValue(value);
        }
    }

}
