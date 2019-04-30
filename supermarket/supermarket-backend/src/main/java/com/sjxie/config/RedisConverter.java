package com.sjxie.config;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
 
/**
 * @author 谢尚杰
 * @date 2018/11/29 10
 * redis配置
 */

public class RedisConverter implements RedisSerializer<Object> {
    private Converter<Object, byte[]> serializer = new SerializingConverter();//序列化器
    private Converter<byte[], Object> deserializer = new DeserializingConverter();//反序列化器
 
    @Override
    public byte[] serialize(Object obj) throws SerializationException {//将对象序列化成字节数组
        if (obj == null) {
        	return new byte[0];
        }
        try {
            return serializer.convert(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
 
    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {//将字节数组反序列化成对象
        if (bytes == null || bytes.length == 0) {
        	return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}