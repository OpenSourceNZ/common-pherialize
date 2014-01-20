package nz.net.osnz.common.pherialize

import de.ailis.pherialize.MixedArray
import de.ailis.pherialize.Pherialize
import org.apache.commons.lang3.StringUtils

/**
 * @author Kefeng Deng
 */
class PhpSerializer {

    /**
     * This class is not instantiable
     */
    private PhpSerializer() {}

    /**
     * Serialize a given list to a string
     *
     * @param list given list to be serialized
     * @return a string
     */
    public static String serialize(Collection list) {
        return Pherialize.serialize(list)
    }

    /**
     * Un-serialize a given string to a list
     *
     * @param value given string to be unserialized
     * @return a list
     */
    public static Collection unserialize(String value) {
        if (StringUtils.isBlank(value)) {
            return []
        }

        MixedArray mixedArray = Pherialize.unserialize(value).toArray()
        return mixedArray.collect { k, v ->
            return v
        }
    }

}
