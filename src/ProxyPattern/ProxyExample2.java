package ProxyPattern;

class ImageClass{
    private String fileName;
    
    public ImageClass(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    
    void display(){
        System.out.println("Display my Image :"+ fileName);
    }
    
    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

class Client{
    /*
    As part of its implementation, the Client class creates an instance of the ImageClass and directly accesses its services.
    In Other words, for a client object, the way of accessing a Image object is fairly straightforward
    */
    public static void main(String[] args) {
        ImageClass aa = new ImageClass("/Proxy/com.png");
        aa.display();
    }
}

