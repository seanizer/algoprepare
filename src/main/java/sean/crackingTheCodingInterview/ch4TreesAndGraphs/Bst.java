package sean.crackingTheCodingInterview.ch4TreesAndGraphs;

public class Bst<T extends Comparable<? super T>> extends AbstractBstNode<T, Bst<T>> {
    private Bst(T value) {
        super(value);
    }

    public static <T extends Comparable<? super T>> Bst<T> createBst(T value) {
        return new Bst<>(value);
    }

    @Override
    protected Bst<T> newNode(T value) {
        return createBst(value);
    }
}
