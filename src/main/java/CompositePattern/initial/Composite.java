package CompositePattern.initial;

public interface Composite extends Component{
    @Override
    default void operation() {

    }

    @Override
    default void add(Component component) {

    }

    @Override
    default void remove(Component component) {

    }

    @Override
    default Component getChild(int index) {
        return null;
    }
}
