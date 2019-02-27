import javafx.application.Application;


public class Controller {
    Master myMaster;

    public Controller(){

    }

    public static void main(String[] args){
        Controller c = new Controller();
        c.myMaster = new Master();
        Application.launch(Master.class,args);

    }
}
