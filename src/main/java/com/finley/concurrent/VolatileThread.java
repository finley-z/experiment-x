<<<<<<< HEAD
package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class VolatileThread implements Runnable {
    private VolatileOpt volatileOpt;

    public VolatileThread(VolatileOpt volatileOpt){
        this.volatileOpt=volatileOpt;
    }
    @Override
    public void run() {
//        while(true){
            volatileOpt.increment();
//        }
    }
}
=======
package com.finley.concurrent;

/**
 * @author zyf
 * @date 2017/8/23
 */
public class VolatileThread implements Runnable {
    private VolatileOpt volatileOpt;

    public VolatileThread(VolatileOpt volatileOpt){
        this.volatileOpt=volatileOpt;
    }
    @Override
    public void run() {
//        while(true){
            volatileOpt.increment();
//        }
    }
}

>>>>>>> ae1fda4d7af7738be4f60e17e3c5535f6452d6d7
