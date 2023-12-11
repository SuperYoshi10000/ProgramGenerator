package local.ytk.java.programgenerator.builder;

import java.util.ArrayList;

public abstract class DataHolder<T extends DataHolder<T>> {
    protected final ClassList classes = new ClassList();
    protected final FileList files = new FileList();
    public ClassList getClasses() {
        return classes;
    }
    public FileList getFiles() {
        return files;
    }

    @SuppressWarnings("unchecked")
    public T self() {
        try {
            return (T) this;
        } catch(ClassCastException e) {
            return null;
        }
    }

    public T addFile(File file) {
        files.add(file);
        return self();
    }
    public T addClass(PClass cls) {
        classes.add(cls);
        return self();
    }

    protected class BoundList<E> extends ArrayList<E> {
        public BoundList() {
            super();
        }
        public BoundList(BoundList<E> original) {
            super(original);
            if (owner != original.owner) throw new IllegalArgumentException("Copied list must have same owner");
        }
        protected final DataHolder<?> owner = DataHolder.this;
    }

    public class ClassList extends BoundList<PClass> {
        public ClassList() {
            super();
        }
        public ClassList(ClassList original) {
            super(original);
        }
    }
    public class FileList extends BoundList<File> {
        public FileList() {
            super();
        }
        public FileList(FileList original) {
            super(original);
        }
    }
}
