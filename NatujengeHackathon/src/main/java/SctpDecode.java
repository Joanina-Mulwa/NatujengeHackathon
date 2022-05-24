public class SctpDecode {
    public static void main(String[] args) {
        byte bytes[]= new byte[] {
                    0x13, 0x55, (byte)0xb6, 0x76,
                    0x79, (byte)0x88, 0x29, 0x5e,
                    0x00, 0x00, 0x00, 0x00,
                    0x00, 0x03, 0x00, 0x34,
                    0x7e, 0x58, 0x1e, 0x36,
                    0x00, 0x00, 0x00, 0x00,
                    0x00, 0x00, 0x00, 0x00
        };

        int sourcePort = 0;
        sourcePort |= (bytes[0]&0xff) << 8;
        sourcePort |= (bytes[1]&0xff);
        System.out.println("Source Port is : "+sourcePort);

        int destinationPort = 0;
        destinationPort |= (bytes[2]&0xff) << 8;
        destinationPort |= (bytes[3]&0xff);
        System.out.println("Destination Port is : "+destinationPort);

        int verificationTag = 0;
        verificationTag |= (bytes[4]&0xff) << 24;
        verificationTag |= (bytes[5]&0xff) << 16;
        verificationTag |= (bytes[6]&0xff) << 8;
        verificationTag |= (bytes[7]&0xff);
        long verTag = Integer.toUnsignedLong(verificationTag);
        System.out.println("Verification Tag is : "+verTag);

        int type = (bytes[8]&0xff)&0b11111111;
        System.out.println("Type is : "+type);

        boolean bFlag = ((bytes[9]&0xff)&0b01000000)>0;
        System.out.println("B Flag is : "+ bFlag);

        int length = ((bytes[9]&0xff)&0b00011111) | (bytes[10]&0xff);
        System.out.println("Length is :"+ length);

    }


}
