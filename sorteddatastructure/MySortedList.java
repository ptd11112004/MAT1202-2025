package hus.oop.sorteddatastructure;

/**
 * Tạo danh sách các phần tử dữ liệu được sắp xếp theo thứ tự tăng dần.
 */
public interface MySortedList {
    /**
     * Lấy kích thước list.
     * @return kích thước mẫu.
     */
    int size();

    /**
     * Xóa toàn bộ list.
     */
    void clear();

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return giá trị phần tử ở vị trí index.
     */
    int get(int index);

    /**
     * Thêm dữ liệu vào danh sách.
     * @param value
     */
    void add(int value);

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Tìm xem giá trị value có trong list không, nếu có trả về chỉ số của phần tử đầu tiên có trong list,
     * nếu không có trả về -1.
     * @param value
     * @return chỉ số hoặc -1 nếu không có
     */
    int binarySearch(int value);

    /**
     * Kiểm tra xem trong list có phần tử nào có giá trị bằng value không, nếu có trả về true,
     * nếu không có trả về false.
     * @param value
     * @return true nếu tồn tại, ngược lại false
     */
    boolean contains(int value);

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return mảng dữ liệu
     */
    int[] toArray();
}
