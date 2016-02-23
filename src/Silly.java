import java.util.function.*;
import java.util.*;

class Silly {
    private int _acc;
    public void run() {
        System.out.format("Bye!\n");
        _acc = 0;
        Consumer<Integer> adder = (Integer x) ->  _acc += x;
        Consumer<Integer> timer = (Integer x) ->  _acc *= x;
        HashMap<String,Consumer<Integer>> hm = new HashMap<String,Consumer<Integer>>();
        hm.put("hello",adder);
        hm.put("world",timer);
        hm.get("hello").accept(10);
        hm.get("world").accept(5);
        Consumer<Integer>[] t = new Consumer[]{adder,timer};                                                                                
        t[0].accept(10);                                                                                                                    
        t[1].accept(5);                                                                                                                     
        System.out.format("got %d\n",_acc);
    }
    public static void main(String[] args) {
        new Silly().run();
    }
}