package learn.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import learn.annotation.Sensitivity;
import learn.model.enums.SensitivityEnum;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author tou tou
 * @Date 2023/1/15
 * @Des
 */
public class SensitivitySerializer extends JsonSerializer<String> implements ContextualSerializer {
    private SensitivityEnum sensitivityEnum;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(sensitivityEnum.desensitizer().apply(value));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {

        Sensitivity annotation = property.getAnnotation(Sensitivity.class);
        if (Objects.nonNull(annotation)&&Objects.equals(String.class, property.getType().getRawClass())) {
            this.sensitivityEnum = annotation.strategy();
            return this;
        }

        return prov.findValueSerializer(property.getType(), property);
    }
}