package edu.iu.es.esi.demo;

public enum BrowserWidth {
    MOBILE(300),
    TABLET(768),
    SMALL_DESKTOP(992),
    DESKTOP(1200);

    private final int width;

    private BrowserWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public static BrowserWidth getWidth(String widthName) {
        for( BrowserWidth width : BrowserWidth.values() ) {
            if(width.toString().equals(widthName)) {
                return width;
            }
        }
        throw new IllegalStateException("Attempted to retrieve unsupported width: " + widthName);
    }
}
