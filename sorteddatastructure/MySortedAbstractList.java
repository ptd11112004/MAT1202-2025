package hus.oop.sorteddatastructure;

import java.util.Arrays;

public abstract class MySortedAbstractList implements MySortedList {

    public MySortedAbstractList() {
        // Constructor mặc định
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index vị trí cần kiểm tra
     * @param limit giới hạn trên
     * @return true nếu hợp lệ, false nếu không
     */
    public boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index < limit;
    }

    /**
     * Mô tả tập dữ liệu theo định dạng [a1, a2, ..., an].
     * Dựa trên phương thức toArray() của interface MySortedList.
     * @return Chuỗi mô tả tập dữ liệu.
     */
    @Override
    public String toString() {
        int[] arr = this.toArray();  // toArray được định nghĩa trong interface
        return Arrays.toString(arr); // Dạng [a1, a2, ..., an]
    }
    
}
