import java.util.LinkedList;

public class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot(){
        return root;
    }

    /*
    Returns true if item was added successfully.
    If item is already present, it does not get added and returns false.
     */
    @Override
    public boolean addItem(ListItem item) {
        if (root == null) {
            root = item;
            return true;
        }

        ListItem current = root;
        while (current != null) {
            int comparison = current.compareTo(item);
            if (comparison < 0) {
                // item is greater, move right
                if (current.next() != null) {
                    current = current.next();
                } else {
                    current.setNext(item);
                    item.setPrevious(current);
                    return true;
                }
            } else if (comparison > 0) {
                // item is smaller, insert before current
                if (current.previous() != null) {
                    current.previous().setNext(item);
                    item.setPrevious(current.previous());
                    item.setNext(current);
                    current.setPrevious(item);
                } else {
                    // current is root
                    item.setNext(root);
                    root.setPrevious(item);
                    root = item;
                }
                return true;
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
        if (item == null) return false;

        ListItem current = root;
        while (current != null) {
            int comparison = current.compareTo(item);
            if (comparison == 0) {
                // found the item
                if (current.previous() != null) {
                    current.previous().setNext(current.next());
                } else {
                    root = current.next();
                }
                if (current.next() != null) {
                    current.next().setPrevious(current.previous());
                }
                return true;
            } else if (comparison < 0) {
                current = current.next();
            } else {
                // since list is ordered, if current > item, stop searching
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }

        ListItem current = root;
        while (current != null) {
            System.out.print(current.getValue());
            current = current.next();
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
