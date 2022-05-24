public class TlvDecode {
    public static void main(String[] args) {
        byte bytes[]= new byte[]{
                0x00, 0x19,
                0x00, 0x06,
                0x48, 0x65, 0x6C, 0x6C, 0x6F
        };

        int tag = 0;
        tag |= (bytes[0]&0xff) <<8;
        tag |= bytes[1]&0xff;
        System.out.println("Tag is : "+ tag);

        System.out.println("Number of Octets is 9");

        int length = 0;
        length |= (bytes[2]&0xff) <<8;
        length |= bytes[3]&0xff;
        System.out.println("Length is : "+ length);

    }
}
