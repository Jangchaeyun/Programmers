import java.util.HashMap;
import java.util.Map;

public class HotelRoomAssignment {
    Map<Long, Long> map = new HashMap<>();

    private long findEmptyRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long nextRoom = map.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }

        return answer;
    }
}
