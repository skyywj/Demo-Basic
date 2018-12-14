package test;

import java.util.ArrayList;

/**
 * @author yanwenjie
 * @since 2018/12/6
 */
public class F {
    public ArrayList<String> list = new ArrayList<>();
    public static final long MAX_SIZE = 1000;

    // 将当前事件id（event_id）添加到数据结构中
    public void record(String eventId) {
        if (list.size() > MAX_SIZE) {
            for (int i = 0; i < 64; i++) {
                list.remove(i);
            }
        }
        list.add(eventId);
    }

    // 获取下标为i的事件的事件id，最后一个事件的下标是0，保证 i < N
    public String getLast(int i) {
        String res = list.get(list.size() - i - 1);
        list.remove(i);
        list.add(res);
        return res;
    }
}
