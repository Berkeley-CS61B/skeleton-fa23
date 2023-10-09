public class TwoThreeTree<T extends Comparable<T>> {

    /* Root of the tree. */
    TwoThreeNode<T> root;

    public static class TwoThreeNode<T> implements Node<T> {

        private final T[] items;
        private final Node<T>[] children;

        @SuppressWarnings("unchecked")
        public TwoThreeNode(T... items) {
            if (items.length != 1 && items.length != 2) {
                throw new IllegalArgumentException("Invalid number of items for 2-3 tree node");
            }
            this.items = (T[]) new Object[items.length];
            System.arraycopy(items, 0, this.items, 0, items.length);
            this.children = (Node<T>[]) new Node[items.length + 1];
        }

        @Override
        public int getItemCount() {
            return items.length;
        }

        @Override
        public int getChildrenCount() {
            return children.length;
        }

        @Override
        public T getItemAt(int i) {
            if (i < 0 || i >= items.length) {
                throw new IllegalArgumentException("No item at index: " + i);
            }
            return items[i];
        }

        @Override
        public Node<T> getChildAt(int i) {
            return children[i];
        }

        @Override
        public void setChildAt(int i, Node<T> node) {
            if (i < 0 || i >= children.length) {
                throw new IllegalArgumentException(
                    "Child index out of bounds: " + i);
            }
            if (!(node instanceof TwoThreeNode)) {
                throw new IllegalArgumentException(
                    "Children of 2-3 node must be a 2-3 node.");
            }
            children[i] = node;
        }
    }
}
