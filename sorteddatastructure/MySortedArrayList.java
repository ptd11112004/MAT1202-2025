package hus.oop.sorteddatastructure;

import java.util.Arrays;

public class MySortedArrayList extends MySortedAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public MySortedArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     */
    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        return data[index];
    }

    /**
     * Thêm phần tử dữ liệu vào danh sách có thứ tự tăng dần.
     */
    @Override
    public void add(int value) {
        if (size == data.length) {
            allocateMore();
        }

        int i = size - 1;
        while (i >= 0 && data[i] > value) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = value;
        size++;
    }

    /**
     * Xóa phần tử tại vị trí index.
     */
    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public int binarySearch(int value) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == value) return mid;
            if (data[mid] < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value) != -1;
    }

    /**
     * Mở rộng mảng khi hết chỗ.
     */
    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Trả về mảng dữ liệu.
     */
    @Override
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

}
