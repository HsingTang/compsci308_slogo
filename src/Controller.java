
public class Controller {
    Master myMaster;

    public Controller(){

    }

    public static void main(String[] args){
        Controller c = new Controller();
        c.myMaster = new Master();
        c.myMaster.launchMaster(args);

    }
}
