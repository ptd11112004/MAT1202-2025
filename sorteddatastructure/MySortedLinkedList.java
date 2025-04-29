package hus.oop.sorteddatastructure;

/**
 * Lớp MySortedLinkedList
 * Cài đặt danh sách liên kết đơn chứa các phần tử sắp xếp theo thứ tự tăng dần.
 */
public class MySortedLinkedList extends MySortedAbstractList {
    private Node head;
    private int size;

    /**
     * Hàm dựng khởi tạo danh sách rỗng.
     */
    public MySortedLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        return getNodeByIndex(index).data;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null || value < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
        size--;
    }

    @Override
    public int binarySearch(int value) {
        // Do danh sách liên kết không hỗ trợ tìm kiếm nhanh, dùng tìm tuyến tính.
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            if (current.data > value) {
                break; // Vì danh sách luôn sắp xếp tăng dần
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value) != -1;
    }

    /**
     * Trả về node tại vị trí index.
     * @param index vị trí cần lấy node
     * @return node tại vị trí index
     */
    private Node getNodeByIndex(int index) {
        Node current = head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        return current;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }
}
