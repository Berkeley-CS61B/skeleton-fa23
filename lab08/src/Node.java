public interface Node<T> {

    /* Returns the number of items in this node. */
    int getItemCount();

    /* Returns the number of children of this node. It should equal to
       getItemCount() + 1. */
    int getChildrenCount();

    /* Returns the I-th item of this node. It must hold that
       0 <= i < getItemCount(). */
    T getItemAt(int i);

    /* Returns the I-th child of this node. It must hold that
       0 <= i < getChildrenCount(). */
    Node<T> getChildAt(int i);

    /* Sets the I-th child of this node to NODE. */
    void setChildAt(int i, Node<T> node);
}

