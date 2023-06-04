package utils;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private boolean isEmpty;
    private List<Call> calls = new ArrayList<>();

    public static final Callback EMPTY = new Callback(true);

    private Callback(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
    public Callback(){
        this(false);
    }


    public void observe(Call call){
        if(isEmpty) {
            call.onStartProcess();
            call.onFinishProcess(false);
            return;
        }

        calls.add(call);
    }

    public void notifyOnFinish(boolean state){
        for (Call call : calls) {
            call.onFinishProcess(state);
        }
    }
    public void notifyOnStart(){
        for (Call call : calls) {
            call.onStartProcess();
        }
    }
}
