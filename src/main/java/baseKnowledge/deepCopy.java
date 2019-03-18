package baseKnowledge;

import java.util.ArrayList;


public class deepCopy {
    public static void main(String[] args) {
        ArrayList<myclass> src = new ArrayList<>();
        src.add(new myclass(0));
        src.add(new myclass(1));
        src.add(new myclass(2));

        ArrayList<myclass> dest = (ArrayList<myclass>) src.clone();
        src.get(2).testInt = 100;
        dest.get(2).testInt = -100;

        System.out.println(src.get(1).testInt);
        System.out.println(src.get(2).testInt);
        System.out.println(dest.get(1).testInt);
        System.out.println(src.get(2).testInt);

    }
}

class myclass implements Cloneable{
    public int testInt;
    public myclass(int i) {testInt = i;}
    @Override
    protected  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}