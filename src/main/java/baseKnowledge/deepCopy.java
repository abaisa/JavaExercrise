package baseKnowledge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class deepCopy {
    public static void main(String[] args) {
        ArrayList<myclass> src = new ArrayList<>();
        src.add(new myclass(0));
        src.add(new myclass(1));
        src.add(new myclass(2));

        ArrayList<myclass> dest = (ArrayList<myclass>) src.clone();
//        try {
//            dest = (ArrayList<myclass>) serialDeepCopy(src);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        src.get(2).testInt = 100;
        dest.get(2).testInt = -100;

        System.out.println(src.get(1).testInt);
        System.out.println(src.get(2).testInt);

        System.out.println(dest.get(1).testInt);
        System.out.println(dest.get(2).testInt);

    }

    // 序列化是可以的
    public static <T> List<T> serialDeepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

}

class myclass implements Cloneable, java.io.Serializable{
    private static final long serialVersionUID = 8683552581122892189L;
    public int testInt;
    public myclass(int i) {testInt = i;}
    @Override
    protected  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}