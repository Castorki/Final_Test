package Code.Model.Counter;


public class Counter implements AutoCloseable{
    private int count;
    private boolean isClosed;

    public Counter() {
        this.count = 0;
        this.isClosed = false;
    }

    public void add() throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        count++;
    }

    @Override
    public void close() throws Exception {
        if (isClosed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        isClosed = true;
        System.out.println("Ресурс закрыт.");
    }

    public int getCount() {
        return count;
    }

    public void minus() throws IllegalStateException {
        if (isClosed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        count--;
    }
}
