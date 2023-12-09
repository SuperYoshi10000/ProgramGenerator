package local.ytk.java.programgenerator.builder;

import java.util.ArrayList;
import java.util.Random;

public class Builder {
    public final ArrayList<File> filelist = new ArrayList<>();
    public Identifier projectName;
    public Builder(Identifier projectName) {
        this.projectName = projectName;
    }
    public static Builder builder() {
        return new Builder(Identifier.create(randomProjectName()));
    }
    public static Builder builder(Identifier projectName) {
        return new Builder(projectName);
    }
    public static String randomProjectName() {
        // " !#$%&'\"()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"
        Random r = new Random();
        StringBuilder sb = new StringBuilder("");
        byte l1 = (byte)(1 + r.nextInt(3));
        for (int i = 0; i < l1; i++) {
            byte l2 = (byte)(4 + r.nextInt(9));
            for (int j = 0; j < l2; j++) {
                char c = (char)(97 + r.nextInt(26));
                sb.append(c);
                // System.out.println(sb.toString() + "   " + c);
                // try {
                //     Thread.sleep(1000);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            }
            sb.append("-");
        }
        sb.append(r.nextInt(10000));
        return sb.toString();
    }
    public Builder addFile(File file) {
        filelist.add(file);
        return this;
    }
}
