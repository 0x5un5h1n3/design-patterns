package AdapterPattern;

interface HDMICable {

    void plug(String txt);
}

class MyLaptop {

    private HDMICable myHdmiCable;
    
    public void plugTheCable(String plug) {
        myHdmiCable.plug(plug);
    }
    
    public HDMICable getMyCable() {
        return myHdmiCable;
    }
    
    public void setMyCable(HDMICable hdmi) {
        this.myHdmiCable = hdmi;
    }
}

class USBCable {

    public void plugUSBCable(String txt) {
        System.out.println(txt); //USB Cable Connected!
    }
}

class HDMIAdapter implements HDMICable {

    USBCable usb = new USBCable();
    
    @Override
    public void plug(String txt) {
        usb.plugUSBCable("USB " + txt);
    }
}

class test {

    public static void main(String[] args) {
        HDMICable cable = new HDMIAdapter();
        MyLaptop laptop = new MyLaptop();
        laptop.setMyCable(cable);
        laptop.plugTheCable("Cable Connected!");
    }
}
