package AdapterPattern;

interface USBCPort {

    public void plugIn(String msg);
}

interface USBAPort {

    public void plug(String str);
}

class USBC implements USBCPort {

    @Override
    public void plugIn(String msg) {
        System.out.println("USB C Cable plugging in to: " + msg);
    }
}

class USBA implements USBAPort {

    @Override
    public void plug(String str) {
        System.out.println("USB A Cable plugging in to: " + str);
    }
}

class OTGAdapter implements USBAPort, USBCPort {

    private USBC usbC;
    private USBA usbA;

    public OTGAdapter(USBC cable) {
        this.usbC = cable;
    }

    public OTGAdapter(USBA cable) {
        this.usbA = cable;
    }

    @Override
    public void plug(String str) {
        usbC.plugIn(str);
    }

    @Override
    public void plugIn(String msg) {
        usbA.plug(msg);
    }

}

class OTGAdapterTest {

    public static void main(String[] args) {
        USBC usbC = new USBC();
        USBA usbA = new USBA();

        USBAPort usbCToA = new OTGAdapter(usbC);
        usbCToA.plug("USB C Port");
        usbC.plugIn("USB C Port");
        
        USBCPort usbAToC = new OTGAdapter(usbA);
        usbAToC.plugIn("USB A Port");
    }
}
