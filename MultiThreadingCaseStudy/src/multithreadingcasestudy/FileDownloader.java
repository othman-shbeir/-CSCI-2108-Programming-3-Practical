package multithreadingcasestudy;

public class FileDownloader extends File implements Runnable {

    private String fileName;

    public FileDownloader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        this.download();
    }

    private void download() {
        System.out.println("Dowloading " + this.fileName + " Started...");

        try {
            //Simulation for time take to download the file(internet speed)
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.getLogger(FileDownloader.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        System.out.println("Dowloading " + this.fileName + " Completed!");
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
