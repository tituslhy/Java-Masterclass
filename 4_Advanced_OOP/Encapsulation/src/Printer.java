public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <=100) ? tonerLevel : -1;
        this.pagesPrinted = 0; //no pages printed at the start
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){
        if ((tonerAmount >0) && (tonerAmount<=100)){
            if ((tonerLevel + tonerAmount) > 100){
                return -1;
            } else {
                tonerLevel += tonerAmount;
                return tonerLevel;
            }
        }
        return -1;
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if (duplex){
            if (pages % 2 == 0){
                pagesToPrint = pages /2;
            } else {
                pagesToPrint = pages /2 + 1;

            }
        }
        System.out.println("Evaluated job for " + pages + " duplex mode: " + duplex + " | pagesPrinted: " + pagesPrinted);
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
