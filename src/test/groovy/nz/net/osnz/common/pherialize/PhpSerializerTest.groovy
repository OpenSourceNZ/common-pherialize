package nz.net.osnz.common.pherialize

/**
 * @author Kefeng Deng
 */
class PhpSerializerTest {

    public void testSerialize() {

        List<Object> list = new ArrayList<Object>()

        list.add('A string')
        list.add(Integer.valueOf(12345))
        list.add(Boolean.TRUE)

        assert 'a:3:{i:0;s:8:"A string";i:1;i:12345;i:2;b:1;}'.equals( PhpSerializer.serialize(list) )

    }

    public void testUnserialize() {
        String value = 'a:3:{i:0;s:8:"A string";i:1;i:12345;i:2;b:1;}';
        List<Object> list = PhpSerializer.unserialize(value)

        assert list.size() == 3

        assert 'A string'.equals( (String) list.get(0) )
        assert 12345 == Integer.parseInt( (String) list.get(1) )
        assert list.get(2)

    }

    public void testEmptyUnserialize() {
        String value = ''
        List<Object> list = PhpSerializer.unserialize(value)

        assert list.size() == 0
    }


}
