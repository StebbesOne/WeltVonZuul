package befehle;

import spielsteuerung.Befehl;

import java.util.LinkedList;

public class BackBefehl implements Befehl {

    private LinkedList<Befehl> befehlStack;

    public BackBefehl(LinkedList befehlStack) {
        this. befehlStack = befehlStack;
    }

    @Override
    public void ausfuehren() {
        if (!befehlStack.isEmpty()) {
            Befehl b = befehlStack.pop();
            b.back();
        }
    }

    @Override
    public void back() {

    }
}
