public class RoomMain {
    public static void main(String[] args) {
        Room room = new Room();
        int area = room.computeArea();
        System.out.println("Area is " + area); // 150
        System.out.println(room.length);
        System.out.println(room.width);

        Room room1 = room;

        room1.length = 20;
        room1.width = 15;

//        room = new Room();
        System.out.println("Area is " + room1.computeArea()); // 300


    }
}
