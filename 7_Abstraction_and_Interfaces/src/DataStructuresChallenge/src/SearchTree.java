public class SearchTree implements NodeList{
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    /*
    Returns true if item was added successfully.
    If item is already present, it does not get added and returns false.
     */
    @Override
    public boolean addItem(ListItem item){
        if (root == null){
            root = item;
            return true;
        }
        ListItem current = root;
        while (current != null){
            int comparison = current.compareTo(item);
            if (comparison < 0) {
                // item is greater, move right
                if (current.next() == null) {
                    current.setNext(item);
                    return true;
                }
                current = current.next();
            } else if (comparison > 0) {
                // item is smaller, move left
                if (current.previous() == null) {
                    current.setPrevious(item);
                    return true;
                }
                current = current.previous();
            } else {
                // duplicate value
                return false;
            }
        }
        return false;
    }

    /*
    Returns true if item was removed successfully.
    If item is not present returns false.
     */
    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        }

        System.out.println("Deleting item " + item.getValue());

        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = ((Comparable) currentItem.getValue()).compareTo(item.getValue());

            if (comparison == 0) {
                // Item found — perform removal
                performRemoval(currentItem, parentItem);
                return true;
            } else if (comparison < 0) {
                // Move right
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else {
                // Move left
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
        }

        // Item not found
        return false;
    }

    /*
    To implement recursion
     */
    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous()); // left child
            System.out.println(root.getValue()); // node
            traverse(root.next()); // right child
        }
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // Case 1: Removing the root node
        if (item == this.root) {
            this.root = item.next();
            if (this.root != null) {
                this.root.setPrevious(null);
            }
            return;
        }

        // Case 2: Removing an item in the middle or end
        if (parent.next() == item) {
            parent.setNext(item.next());
            if (item.next() != null) {
                item.next().setPrevious(parent);
            }
        } else if (parent.previous() == item) {
            parent.setPrevious(item.previous());
            if (item.previous() != null) {
                item.previous().setNext(parent);
            }
        }
    }
}