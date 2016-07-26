/**
 * WaterBoardCtrl.java   2015年10月27日 下午11:06:10 by Xuebing 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.demo;

public class WaterBoardCtrl {

    /**
     * 水板的远程操作功能
     * 
     * 沉淀池进水阀门状态 valveStatus (1=on, 0=off)
     * 
     * 集水板工作状态 workStatus (1=手动状态, 2=自动状态, 3=就地状态)
     */
    public void remoteCtrlWaterBoard(int valveStatus,int workStatus) {
        if(valveStatus == 0) {
            //水阀门是关闭状态
            return;
        }
        boolean isContinue = true;
        while (isContinue) {
            isContinue = waterCollectorWorkProcess(workStatus);
        }
    }

    public boolean waterCollectorWorkProcess(int workStatus) {
        boolean result = false;
        // 处理手动
        if (workStatus == 1) {
            //do nothing
            System.out.println("不动作，等待相关操作");
            result = true;
        }
        // 处理自动
        if (workStatus == 2) {
            System.out.println("这要如何自动计算集水板高度");
            result = true;
        }
        // 处理就地
        if (workStatus == 3) {
            System.out.println("调度程序关闭水阀");
            result = false;
        }
        return result;
    }

}
