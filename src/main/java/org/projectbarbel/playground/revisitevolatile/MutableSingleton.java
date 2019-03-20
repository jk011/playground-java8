package org.projectbarbel.playground.revisitevolatile;

public class MutableSingleton {
    private static volatile MutableSingleton INSTANCE;
    private static final Object mutex = new Object();
    private boolean someFlag;
    // more mutable state on this singleton
    private MutableSingleton(boolean someFlag) {
        this.someFlag = someFlag;
    }
    public static MutableSingleton getInstance() {
        if (INSTANCE==null) {
            synchronized (mutex) {
                if (INSTANCE==null) {
                    INSTANCE = new MutableSingleton(false);
                }
            }
        }
        return INSTANCE;
    }
    public boolean isSomeFlag() {
        return someFlag;
    }
    public void setSomeFlag(boolean someFlag) {
        this.someFlag = someFlag;
    }
}
