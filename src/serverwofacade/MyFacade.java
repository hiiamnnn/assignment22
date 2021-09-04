/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author nkotchs
 */
public class MyFacade {
    private static MyFacade facadeObj = null;
    private MyFacade() {}
    public static MyFacade getMyFacadeObject(){
        if(facadeObj == null)
            facadeObj = new MyFacade();
        return facadeObj;
    }
    public void startServer(){
        ScheduleServer scheduleServer = new ScheduleServer();
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
    }
    public void stopServer(){
        ScheduleServer scheduleServer = new ScheduleServer();
        scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
