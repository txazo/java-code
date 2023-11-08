package jdk.java.io;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.io.*;

/**
 * 对象序列化/反序列化
 * <p>
 * 1、序列化优先级: Externalizable > writeObject/readObject > 默认字段
 * 2、transient
 * 3、serialVersionUID
 * 4、writeReplace，write时替换为新的Object
 * 5、readResolve，先read，再执行readResolve()替换为新的Object
 */
public class SerializableTest {

    @Test
    public void test() throws Exception {
        serializeAndDeserialize(new NormalObject(1L, "张三", 24));
        serializeAndDeserialize(new SerializableObject(2L, "李四"));
        serializeAndDeserialize(new ExternalizableObject(3L, "王五"));
    }

    private void serializeAndDeserialize(Object object) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(object);
        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Object deserializeObject = input.readObject();
        System.out.println(object);
        System.out.println(deserializeObject);
    }

    @Data
    static class NormalObject implements Serializable {

        private Long id;

        private String name;

        private transient Integer age;

        public NormalObject(Long id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

    }

    @Data
    @EqualsAndHashCode
    static class SerializableObject implements Serializable {

        private static final int MAGIC = 0xab;

        private Long id;

        private String name;

        public SerializableObject(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeByte((byte) MAGIC);
            out.writeLong(id);
            out.writeUTF(name);
        }

        private void readObject(ObjectInputStream in) throws IOException {
            byte magic = in.readByte();
            if (magic != (byte) MAGIC) {
                throw new IOException("magic is invalid");
            }
            this.id = in.readLong();
            this.name = in.readUTF();
        }

    }

    @Data
    @EqualsAndHashCode
    static class ExternalizableObject implements Externalizable {

        private Long id;

        private String name;

        public ExternalizableObject() {
        }

        public ExternalizableObject(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeLong(id);
            out.writeUTF(name);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException {
            this.id = in.readLong();
            this.name = in.readUTF();
        }

    }

}
