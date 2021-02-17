package DecoratorPattern._4_homework;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase(c));
    }

    /* 不需要复写 都一样，均是调用 read(byte[] b, int off, int len)
    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }*/

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int bytesCount = super.read(b, off, len);
        for (int i = 0; i < off + bytesCount; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return bytesCount;
    }
}
