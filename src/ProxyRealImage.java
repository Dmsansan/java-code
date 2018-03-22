public class ProxyRealImage implements Image{

    private realImage realImage;
    private String fileName;

    public ProxyRealImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new realImage(fileName);
        }
        realImage.display();
    }
}
