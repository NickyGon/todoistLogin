package factoryBrowser;

public class FactoryBrowser {
    public static IBrowser make(String type){
        IBrowser browser;
        switch (type.toLowerCase()){
            case "chrome":
                browser=new Chrome();
                break;
            case "edge":
                browser=new Edge();
                break;
            case "firefox":
                browser=new Firefox();
                break;
            default:
                browser=new Chrome();
                break;
        }
        return browser;
    }
}
