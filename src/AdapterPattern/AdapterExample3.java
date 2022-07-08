package AdapterPattern;

interface WebDriver {

    public void getElement();

    public void selectElement();

}

class ChromeDriver implements WebDriver {

    @Override
    public void getElement() {
        System.out.println("Get Element from ChromeDriver"); //Get Element from ChromeDriver
    }

    @Override
    public void selectElement() {
        System.out.println("Select Element from ChromeDriver"); //Select Element from ChromeDriver
    }
}

class IEDriver {

    public void findElement() {
        System.out.println("Find Element from IEDriver"); //Find Element from IEDriver
    }

    public void clickElement() {
        System.out.println("Click Element from IEDriver"); //Click Element from IEDriver
    }
}

class WebDriverAdapter implements WebDriver {

    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        this.ieDriver = ieDriver;
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}

class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement(); //Click Element from IEDriver
    }
}
