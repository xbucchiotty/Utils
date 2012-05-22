package org.xbucchiotty.utils.function;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: xbucchiotty
 * Date: 27/04/12
 * Time: 19:16
 */
public abstract class FunctionHelper {


    public static <I, O> O reduce(Reducer<I, O> reducer, Iterable<I> inputs) {
        for (I input : inputs) {
            reducer.agrege(input);
        }

        return reducer.getResult();
    }

    public static <I, O> O reduce(Reducer<I, O> reducer, I... inputs) {
        for (I input : inputs) {
            reducer.agrege(input);
        }

        return reducer.getResult();
    }

    public static <I, O> Collection<O> map(Converter<I, O> converter, Iterable<I> inputs) {
        Collection<O> convertedObjects = new ArrayList<O>();
        for (I input : inputs) {
            convertedObjects.add(converter.convert(input));
        }

        return convertedObjects;
    }

    public static <I, O> Collection<O> map(Converter<I, O> converter, I... inputs) {
        Collection<O> convertedObjects = new ArrayList<O>(inputs.length);
        for (I input : inputs) {
            convertedObjects.add(converter.convert(input));
        }

        return convertedObjects;
    }

}
