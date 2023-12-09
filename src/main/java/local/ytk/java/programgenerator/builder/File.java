package local.ytk.java.programgenerator.builder;

import java.util.ArrayList;

import local.ytk.java.programgenerator.builder.Member.Visibility;
import local.ytk.java.programgenerator.builder.Variable.GlobalVariable;

public class File extends Namespace {
    public final Identifier packageName;
    protected PClass publicClass;
    protected final ArrayList<PClass> classes = new ArrayList<>();
    protected final ArrayList<GlobalVariable<?>> globalVariables = new ArrayList<>();
    protected final ArrayList<Namespace> namespaces = new ArrayList<>();
    public File(Identifier packageName) {
        super();
        this.packageName = packageName;
    }

    public File addClass(PClass cls) {
        this.classes.add(cls);
        return this;
    }
    public File addClass(Visibility visibility, PClass cls, boolean isStatic, boolean isFinal, boolean isConstant) {
        cls.visibility = visibility;
        cls.isStatic = isStatic;
        cls.isFinal = isFinal;
        cls.isConstant = isConstant;
        this.classes.add(cls);
        return this;
    }

    public File addVariable(GlobalVariable<?> globalVariable) {
        this.globalVariables.add(globalVariable);
        return this;
    }
    public File addNamespace(Namespace namespace) {
        this.namespaces.add(namespace);
        return this;
    }

    public PClass getPublicClass() {
        return publicClass;
    }

}
