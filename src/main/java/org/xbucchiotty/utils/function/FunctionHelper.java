package org.xbucchiotty.utils.function;

import com.google.common.base.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * User: xbucchiotty
 * Date: 27/04/12
 * Time: 19:16
 */
public abstract class FunctionHelper {


    public static <I, O> O reduce(@NotNull Reducer<I, O> reducer, Iterable<I> inputs) {
        checkArgument(reducer != null);

        for (I input : inputs) {
            reducer.agrege(input);
        }

        return reducer.getResult();
    }

    public static <I, O> O reduce(@NotNull Reducer<I, O> reducer, I... inputs) {
        checkArgument(reducer != null);

        for (I input : inputs) {
            reducer.agrege(input);
        }

        return reducer.getResult();
    }

    public static <I, O> Collection<O> map(@NotNull Converter<I, O> converter, Iterable<I> inputs) {
        checkArgument(converter != null);

        Collection<O> convertedObjects = new ArrayList<O>();
        for (I input : inputs) {
            convertedObjects.add(converter.convert(input));
        }

        return convertedObjects;
    }

    public static <I, O> Collection<O> map(@NotNull Converter<I, O> converter, I... inputs) {
        checkArgument(converter != null);

        Collection<O> convertedObjects = new ArrayList<O>(inputs.length);
        for (I input : inputs) {
            convertedObjects.add(converter.convert(input));
        }

        return convertedObjects;
    }


    @Null
    public static <O> O getOrDefault(@NotNull Optional<O> optional, @Null O defaultValue) {
        checkArgument(optional != null);
        return optional.or(defaultValue);
    }
}
