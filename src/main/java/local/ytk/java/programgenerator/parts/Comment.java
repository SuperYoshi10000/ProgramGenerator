package local.ytk.java.programgenerator.parts;

import local.ytk.java.programgenerator.parts.Builder.Ref;

public class Comment extends ProgramPartType<Comment> {
    public Comment(String name) {
        super(name);
    }

    public static class CmRef extends Ref<Comment> {
        public CmRef(Comment t, String content, boolean multiline, boolean documentation) {
            super(t);
            this.content = content;
            this.multiline = multiline;
            this.documentation = documentation;
        }
        public final String content;
        public final boolean multiline;
        public final boolean documentation;
    }
}
