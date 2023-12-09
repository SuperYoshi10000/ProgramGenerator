package local.ytk.java.programgenerator;

import local.ytk.java.programgenerator.builder.Builder;
import local.ytk.java.programgenerator.builder.File;
import local.ytk.java.programgenerator.builder.Identifier;
import local.ytk.java.programgenerator.builder.PClass;
import local.ytk.java.programgenerator.builder.Value;
import local.ytk.java.programgenerator.builder.Member.Visibility;

public class test {
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());
        System.out.println(Builder.builder().projectName.toString());

        new File(Identifier.create("f"))
            .addClass(Visibility.PUBLIC, new PClass()
                .addClass(new PClass(Identifier.create("c")))
                .addField(Identifier.create("null"), Value.Integer.type, null),
            false, false, false);
    }
}
